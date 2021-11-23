function clickNavViewListUsers() {
    $(".main").load("viewlistusers.html", function() {
        buildUserTable();
    });
    
}

function buildUserTable() {
    $('tbody').empty();
    getListUsers();
}

var currentUserPage = 1;
var userPagesize = 5; 
var userSortField ="id";
var isUserAsc = true;


function getListUsers() {

    var url = "http://localhost:8080/api/v1/users";
    url+= "?page=" + currentUserPage +"&size=" + userPagesize;
    url+= "&sort=" + userSortField +"," + (isUserAsc ? "asc" : "desc" ) ;

    var search = document.getElementById("input-search-user").value;
    if(search){
        url += "&search=" + search;
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
        fillUserToTable();
        pagingUserTable(data.totalPages);
        renderUserSortUI();
        },
        error (jqXHR, textStatus, errorThrown){
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function fillUserToTable() {
    groups.forEach(function(item,index) {
        $('tbody').append(
            '<tr>' +
            '<td>' + item.id + '</td>' +
            '<td>' + item.fullName + '</td>' +
            '<td>' + item.username + '</td>' +
            '<td>' + item.email + '</td>' +
            '<td>' + item.group + '</td>' +
            '</tr>')
    });
}

function pagingUserTable(pageAmount){
    var pagingStr = "";

    if(pageAmount>1 && currentUserPage>1 ){
        pagingStr += '<li class="page-item">'+
        '<a class="page-link" onclick ="prevUserPaging()" >Previous</a></li>' ; 
    }

    for(i=0; i < pageAmount ;i++ ){
        pagingStr += '<li class="page-item ' + (currentUserPage == i+1 ? "active" : "" ) + ' ">'+
        '<a class="page-link" onclick="changeUserPage('+ (i+1) +')">'+ (i+1) + '</a>'+
        '</li>';
    }

    if(pageAmount>1 && currentUserPage<pageAmount ){
        pagingStr += '<li class="page-item"><a class="page-link" onclick="nextUserPaging()">Next</a></li>' ; 
    }

    $('#pagination').empty();
    $('#pagination').append(pagingStr);

}

function changeUserPage (page){
    if(page == currentUserPage) {
        return;
    }
        currentUserPage = page;
        buildUserTable();
}

function resetUserPaging(){
    currentUserPage = 1;
    userPagesize = 5; 
}

function prevUserPaging(page){
    changeUserPage(currentUserPage -1);
}

function nextUserPaging(page){
    changeUserPage(currentUserPage +1);
}

function handleUserSearch(){
    resetUserPaging();
    resetUserSort();
    buildUserTable();
}

function handleKeyUpEventForUserSearching(event){
    if(event.keyCode === 13){
        event.preventDefault();
        handleUserSearch();
    }
}

function resetUserSearch(){
    document.getElementById("input-search-user").value = "";
}

function renderUserSortUI(){
    var sortTypeClazz = isUserAsc ? "fa-sort-asc" : "fa-sort-desc";

    switch(sortField){
        case 'id':
            changeIconSort( "heading-user-id" , sortTypeClazz);
            changeIconSort( "heading-user-fullName" , "fa-sort");
            changeIconSort( "heading-user-group" , "fa-sort");
            break;

        case 'fullName':
            changeIconSort( "heading-user-fullName" , sortTypeClazz);
            changeIconSort( "heading-user-id" , "fa-sort");
            changeIconSort( "heading-user-group" , "fa-sort");
            break;

        case 'group':
            changeIconSort( "heading-user-group" , sortTypeClazz);
            changeIconSort( "heading-user-id" , "fa-sort");
            changeIconSort( "heading-user-fullName" , "fa-sort");
            break;

        default:
            changeIconSort( "heading-user-id" , "fa-sort");
            changeIconSort( "heading-user-fullName" , "fa-sort");
            changeIconSort( "heading-user-group" , "fa-sort");
            break;
    }
}

function changeUserIconSort( id, sortTypeClazz){
    document.getElementById(id).classList.remove("fa-sort","fa-sort-asc","fa-sort-desc");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function changeUserSort(field){
    if(field == sortField){
        isUserAsc = !isUserAsc;
    }else{
        sortField = field;
        isUserAsc = true;
    }
    buildUserTable();
}

function resetUserSort(){
    sortField ="id";
    isUserAsc = true;
}

function refreshUserTable(){
    resetUserTable ();
    buildUserTable();
}

function resetUserTable (){
    resetUserSort();
    resetUserPaging();
    resetUserSearch();
}