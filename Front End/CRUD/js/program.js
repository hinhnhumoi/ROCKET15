var employees = [];
var counter =0;

function Employee (name, department, phone){
    this.id = ++counter;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

$(function(){
    $(".header").load("header.html"); 
    $(".main").load("home.html"); 
    $(".footer").load("footer.html"); 
    });

    function clickNavHome(){
        $(".main").load("home.html"); 
    };

    function clickNavViewListEmp(){
        $(".main").load("viewListEmp.html"); 
        buildTable();
    };

    function initEmployees(){
        if(employees != null && employees.length >0) return;
        //init data
        employees.push(new Employee("John Doe", "Administration", "(171) 555-2222"));
        employees.push(new Employee("Peter Parker", "Customer Service", "(313) 555-5735"));
        employees.push(new Employee("Fran Wilson", "Human Resources", "(503) 555-9931"));
    }

    function buildTable (){
        setTimeout (function name(params) {
            initEmployees();
            $('tbody').empty();

            employees.forEach(function(item){
                $('tbody').append('<tr>' + 
                    '<td>'+item.name+'</td>'+
                    '<td>'+item.department+'</td>'+
                    '<td>'+item.phone+'</td>' +
                    '<td>'+
                        ' <a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal('+ item.id + ')" ><i class="material-icons">&#xE254;</i></a>' +
                        '<a class="delete" title="Delete" data-toggle="tooltip" onclick="openConfirmDelete('+ item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                    '</td>'
    
                    +'</tr>')
              });

        }, 0);
    }
        
    function openAddModal(){
        resetForm();
        openModal();
    }
    function openModal(){
        $('#myModal').modal('show');
    }
    function resetForm(){
        document.getElementById("id").value="";
        document.getElementById("name").value="";
        document.getElementById("department").value="";
        document.getElementById("phone").value="";

    }
    function hideModal(){
        $('#myModal').modal('hide');
    }
    function addEmployee(){
        var name =document.getElementById("name").value;
        var department =document.getElementById("department").value;
        var phone = document.getElementById("phone").value;

        //TO DO VALIDATE

        employees.push(new Employee(name, department, phone));

        hideModal();
        buildTable();
    }

function openUpdateModal(id){
    // get index from employee's id - có thể viết vòng for thay thế. 
    var index = employees.findIndex(x => x.id == id);
    // fill data:
    document.getElementById("id").value=employees[index].id;
    document.getElementById("name").value=employees[index].name;
    document.getElementById("department").value=employees[index].department;
    document.getElementById("phone").value=employees[index].phone;

    openModal();
}

function save(){
    var id = document.getElementById("id").value;
    if(id == null || id == "") 
        addEmployee();
    else 
        updateEmployee();
}

function updateEmployee(){
    var id = document.getElementById("id").value;
    var name =document.getElementById("name").value;
    var department =document.getElementById("department").value;
    var phone = document.getElementById("phone").value;
    //TO DO VALIDATE

    employees[id].name = name;
    employees[id].department = department;
    employees[id].phone = phone;

    hideModal();
    showSuccessAlert();
    buildTable();
}

function showSuccessAlert(){
    $("#success-alert").fadeTo(2000,500).slideUp(500, function(){
        $("#success-alert").slideUp(500);
    });
}

function openConfirmDelete(id){
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;
    var result = confirm("Want to delete " + name + "? " );
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id){
    // To do validate
    var index = employees.findIndex(x => x.id == id);
    employees.splice(index,1);
    
    showSuccessAlert();
    buildTable();
}