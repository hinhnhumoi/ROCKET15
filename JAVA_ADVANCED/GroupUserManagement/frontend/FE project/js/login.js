$( function(){
    var isRememberMe = storage.getRememberMe();
    document.getElementById("rememberMe").checked = isRememberMe;

} );

function login(){
    //get username + password
    var username= document.getElementById("username").value;
    var password= document.getElementById("password").value;

    //validate username
    if(!username){
        showNameErrorMesseage("username must not be empty!!");
        return;
    }
    if(!password){
        showNameErrorMesseage("password must not be empty!!");
        return;
    }
    if(  username.length < 6 || username.length >50 || password.length < 6 || password.length >50  ){
        showNameErrorMesseage("invalid username or password!!");
        return;
    }


    //call API
    $.ajax ({
        url: 'http://localhost:8080/api/v1/login',
        type: 'GET',
        contentType: "application/json", //type of body (json,xml,text)
        dataType: 'json', //datatype return
        beforeSend: function(xhr){
            xhr.setRequestHeader ("Authorization", "Basic " + btoa(username + ":" + password));
        },
        success : function (data, textStatus, xhr){
            // success
            var isRememberMe = document.getElementById("rememberMe").checked;
            storage.saveRememberMe(isRememberMe);

            storage.setItem("ID", data.id);
            storage.setItem("FULL_NAME", data.fullName);
            storage.setItem("USERNAME", username);
            storage.setItem("PASSWORD", password);
            storage.setItem("ROLE", data.role);



            window.location.replace("http://127.0.0.1:5500/html/program.html");
        },
        error (jqXHR, textStatus, errorThrown){
            if(jqXHR.status == 401){
                showNameErrorMesseage("invalid username or password!!");
            }else{
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }

        }
    });
}

function showNameErrorMesseage(messeage){
    document.getElementById("nameErrorMessage").style.display = "block";
    document.getElementById("nameErrorMessage").innerHTML = messeage;
}

function hideNameErrorMesseage(){
    document.getElementById("nameErrorMessage").style.display = "none";
}