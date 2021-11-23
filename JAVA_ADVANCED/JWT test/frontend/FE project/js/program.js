$(function() {
    $(".topbar").load("topbar.html");
    $(".footer").load("footer.html");
    $(".main").load("home.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListGroups() {
    $(".main").load("viewlistgroups.html", function (){ 
        buildTable();
    });
}

var groups = [];
var currentPage = 1;
var size = 5; 
var sortField ="id";
var isAsc = true;
var minCreateDate ="";
var maxCreateDate ="";

function getListGroups() {

    var url = "http://localhost:8080/api/v1/groups";
    url+= "?page=" + currentPage +"&size=" + size;
    url+= "&sort=" + sortField +"," + (isAsc ? "asc" : "desc" ) ;

    var search = document.getElementById("input-search-group").value;
    if(search){
        url += "&search=" + search;
    }
    if(minCreateDate){
        url += "&minDate=" + minCreateDate;
    }
    if(maxCreateDate){
        url += "&maxDate=" + maxCreateDate;
    }

    //call API
    $.ajax ({
        url: url,
        type: 'GET',
        contentType: "application/json", //type of body (json,xml,text)
        dataType: 'json', //datatype return
        beforeSend: function(xhr){
            xhr.setRequestHeader ("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success : function (data, textStatus, xhr){

        // reset list employees
        groups = [];

        // success
        groups = data.content;
        fillGroupToTable();
        resetDeleteCheckbox();
        pagingTable(data.totalPages);
        renderSortUI();
        },
        error (jqXHR, textStatus, errorThrown){
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function pagingTable(pageAmount){
    var pagingStr = "";

    if(pageAmount>1 && currentPage>1 ){
        pagingStr += '<li class="page-item">'+
        '<a class="page-link" onclick ="prevPaging()" >Previous</a></li>' ; 
    }

    for(i=0; i < pageAmount ;i++ ){
        pagingStr += '<li class="page-item ' + (currentPage == i+1 ? "active" : "" ) + ' ">'+
        '<a class="page-link" onclick="changePage('+ (i+1) +')">'+ (i+1) + '</a>'+
        '</li>';
    }

    if(pageAmount>1 && currentPage<pageAmount ){
        pagingStr += '<li class="page-item"><a class="page-link" onclick="nextPaging()">Next</a></li>' ; 
    }

    $('#pagination').empty();
    $('#pagination').append(pagingStr);

}

function changePage (page){
    if(page == currentPage) {
        return;
    }
        currentPage = page;
        buildTable();
}

function resetPaging(){
    currentPage = 1;
    size = 5; 
}

function prevPaging(page){
    changePage(currentPage -1);
}

function nextPaging(page){
    changePage(currentPage +1);
}

function renderSortUI(){
    var sortTypeClazz = isAsc ? "fa-sort-asc" : "fa-sort-desc";

    switch(sortField){
        case 'name':
            changeIconSort( "heading-name" , sortTypeClazz);
            changeIconSort( "heading-creator" , "fa-sort");
            changeIconSort( "heading-createDate" , "fa-sort");
            break;

        case 'creator.fullName':
            changeIconSort( "heading-creator" , sortTypeClazz);
            changeIconSort( "heading-name" , "fa-sort");
            changeIconSort( "heading-createDate" , "fa-sort");
            break;

        case 'createDate':
            changeIconSort( "heading-createDate" , sortTypeClazz);
            changeIconSort( "heading-name" , "fa-sort");
            changeIconSort( "heading-creator" , "fa-sort");
            break;

        default:
            changeIconSort( "heading-name" , "fa-sort");
            changeIconSort( "heading-creator" , "fa-sort");
            changeIconSort( "heading-createDate" , "fa-sort");
            break;
    }
}

function changeIconSort( id, sortTypeClazz){
    document.getElementById(id).classList.remove("fa-sort","fa-sort-asc","fa-sort-desc");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function changeSort(field){
    if(field == sortField){
        isAsc = !isAsc;
    }else{
        sortField = field;
        isAsc = true;
    }
    buildTable();
}

function resetSort(){
    sortField ="modifyDate";
    isAsc = false;
}

function resetDeleteCheckbox(){

    document.getElementById("checkbox-all").checked = false;

    var i=0;
    while(true){
        var checkboxItem = document.getElementById("checkbox-"+i);
        if( checkboxItem !== undefined && checkboxItem !== null ){
            checkboxItem.checked = false;
        i++;
        }else{
            break;
        }
    }
}

function handleSearch(){
    resetPaging();
    resetSort();
    resetDeleteCheckbox();
    buildTable();
}

function handleKeyUpEventForSearching(event){
    if(event.keyCode === 13){
        event.preventDefault();
        handleSearch();
    }
}

function resetSearch(){
    document.getElementById("input-search-group").value = "";
}

function changeMinCreateDate(event){
    minCreateDate = event.target.value;
    buildTable();
    resetPaging();
}

function changeMaxCreateDate(event){
    maxCreateDate = event.target.value;
    buildTable();
    resetPaging();
}

function resetFilter(){
    minCreateDate ="";
    maxCreateDate ="";
    document.getElementById("minCreateDate").value ="";
    document.getElementById("maxCreateDate").value ="";
}

function refreshTable(){
    resetTable ();
    buildTable();
}

function resetTable (){
    resetSort();
    resetPaging();
    resetSearch();
    resetFilter();
    resetDeleteCheckbox();
}

function fillGroupToTable() {
    groups.forEach(function(item,index) {
        $('tbody').append(
            '<tr>' +
            '<th> <input type="checkbox" id="checkbox-' +index+ '" onclick ="onChangeCheckboxItem()" ></th>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.creator.fullName + '</td>' +
            '<td>' + item.createDate + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable() {
    $('tbody').empty();
    getListGroups();
}

function openAddModal() {
    resetFormAdd();
    openModal();
}

function resetFormAdd() {
    document.getElementById("titleModal").innerHTML = "Add Department";
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("creatorLabel").style.display = "none";
    document.getElementById("creator").style.display = "none";
    document.getElementById("createDate").style.display = "none";
    document.getElementById("createDateLabel").style.display = "none";
    hideNameErrorMesseage();
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function showNameErrorMesseage(messeage){
    document.getElementById("nameErrorMessage").style.display = "block";
    document.getElementById("nameErrorMessage").innerHTML = messeage;
}

function hideNameErrorMesseage(){
    document.getElementById("nameErrorMessage").style.display = "none";
}

function addGroup() {

    // get data
    var name = document.getElementById("name").value;

    //validate name
    if(!name || name.length < 6 || name.length >30  ){
        showNameErrorMesseage("Group name must be from 6 to 30 character!!");
        return;
    }

    // validate unique name
    $.ajax ({
        url: "http://localhost:8080/api/v1/groups/name/" +name +" /exists",
        type: 'GET',
        contentType: "application/json", //type of body (json,xml,text)
        dataType: 'json', //datatype return
        beforeSend: function(xhr){
            xhr.setRequestHeader ("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success : function (data, textStatus, xhr){

            if(data == true) {
                showNameErrorMesseage("This Group name has already exists !!");
    
            }else{
                // validate ok, call api create group
                var group = {
                    name: name,
                    creatorId : storage.getItem("ID")
                };
            
                $.ajax ({
                    url: 'http://localhost:8080/api/v1/groups',
                    type: 'POST',
                    data : JSON.stringify(group), //body
                    contentType: "application/json", //type of body (json,xml,text)
                    // dataType: 'json', //datatype return
                    beforeSend: function(xhr){
                        xhr.setRequestHeader ("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
                    },
                    success : function (data, textStatus, xhr){
                        // success
                        console.log(data);
                        hideModal();
                        showSuccessAlert();
                        resetTable();
                        buildTable();
                    },
                    error (jqXHR, textStatus, errorThrown){
                        alert("Error when loading data");
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
        },
        error (jqXHR, textStatus, errorThrown){
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });    
}

function resetFormUpdate() {
    document.getElementById("titleModal").innerHTML = "Update Group";
    document.getElementById("name").value = "";
    document.getElementById("creatorLabel").style.display = "block";
    document.getElementById("creator").style.display = "block";
    document.getElementById("createDate").style.display = "block";
    document.getElementById("createDateLabel").style.display = "block";
    hideNameErrorMesseage();

}

var oldName ;

function openUpdateModal(id) {

    $.ajax ({
        url: "http://localhost:8080/api/v1/groups/" +id,
        type: 'GET',
        contentType: "application/json", //type of body (json,xml,text)
        dataType: 'json', //datatype return
        beforeSend: function(xhr){
            xhr.setRequestHeader ("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success : function (data, textStatus, xhr){

        resetFormUpdate();
        openModal();

        oldName = document.getElementById("name").value = data.name;

        // fill data
        document.getElementById("id").value = data.id;
        document.getElementById("name").value = data.name;
        document.getElementById("creator").value = data.creator.fullName;
        document.getElementById("createDate").value = data.createDate;
        console.log(data.creator.fullName);
        console.log(data.createDate);
        },

        error (jqXHR, textStatus, errorThrown){
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });    
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addGroup();
    } else {
        updateGroup();
    }
}

function updateGroup() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    //validate name
    if(!name || name.length < 6 || name.length >30  ){
        showNameErrorMesseage("Group name must be from 6 to 30 character!!");
        return;
    }

    //same name
    if(oldName === name){
        hideModal();
        showSuccessAlert();
        resetTable();
        buildTable();
        return;
    }
    
    // validate unique name
    $.ajax ({
        url: "http://localhost:8080/api/v1/groups/name/" +name +" /exists",
        type: 'GET',
        contentType: "application/json", //type of body (json,xml,text)
        dataType: 'json', //datatype return
        beforeSend: function(xhr){
            xhr.setRequestHeader ("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success : function (data, textStatus, xhr){

            if(data == true) {
                showNameErrorMesseage("This Group name has already exists !!");
    
            }else{
                // validate ok, call api create department
                var group = {
                    name: name
                };
            
                $.ajax ({
                    url: 'http://localhost:8080/api/v1/departments/' + id,
                    type: 'PUT',
                    data : JSON.stringify(group), //body
                    contentType: "application/json", //type of body (json,xml,text)
                    // dataType: 'json', //datatype return
                    beforeSend: function(xhr){
                        xhr.setRequestHeader ("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
                    },
                    success : function (data, textStatus, xhr){
                        // success
                        console.log(data);
                        hideModal();
                        showSuccessAlert();
                        resetTable();
                        buildTable();
                    },
                    error (jqXHR, textStatus, errorThrown){
                        alert("Error when loading data");
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
        },
        error (jqXHR, textStatus, errorThrown){
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    }); 
}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = groups.findIndex(x => x.id == id);
    var name = groups[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteGroup(id);
    }
}

function deleteGroup(id) {
    // TODO validate

    $.ajax({
        url: 'http://localhost:8080/api/v1/groups/' + id,
        type: 'DELETE',
        beforeSend: function(xhr){
            xhr.setRequestHeader ("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            resetTable();
            buildTable();
        }
    });
}

function onChangeCheckboxItem(){
    var i=0;
    while(true){
        var checkboxItem = document.getElementById("checkbox-"+i);
        if( checkboxItem !== undefined && checkboxItem !== null ){
            if(!checkboxItem.checked){
                document.getElementById("checkbox-all").checked = false ;
                return;
            }
        i++;
        }else{
            break;
        }
    }
    document.getElementById("checkbox-all").checked = true ;    
}

function onChangeCheckboxAll(){

        var i=0;
        while(true){
            var checkboxItem = document.getElementById("checkbox-"+i);
            if( checkboxItem !== undefined && checkboxItem !== null ){
                // if( document.getElementById("checkbox-all").checked ){
                //     checkboxItem.checked = true;
                // } else{
                //     checkboxItem.checked = false;
                // }

                checkboxItem.checked = document.getElementById("checkbox-all").checked;
            i++;
            }else{
                break;
            }
        }

}

function DeleteAllGroup() {
    //get checked
    var ids = [];
    var names = [];
    var i=0;
    while(true){
        var checkboxItem = document.getElementById("checkbox-"+i);
        if(checkboxItem !== undefined && checkboxItem !== null ){
            if(checkboxItem.checked){
                ids.push(groups[i].id);
                names.push(groups[i].name);
            }
            i++;
        }else{
            break;
        }
    }

    console.log(ids);

    //open confirm 
    var result = confirm("Want to delete " + names + "?");
    if (result) {
        //delete
        $.ajax({
            url: 'http://localhost:8080/api/v1/groups/?ids=' + ids,
            type: 'DELETE',
            beforeSend: function(xhr){
                xhr.setRequestHeader ("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
            },
            success: function(result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }

                // success
                showSuccessAlert();
                resetTable();
                buildTable();
            }
        });
    }

}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}