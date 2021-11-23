function department (id, name){
    this.id = id;
    this.name = name;
}
function getDepById (id, departments){
    for (var x in departments ){
        if(x.id = id)
            return x;
        else console.log('không có department có id bằng' + id);
    }
}

function position (id,name){
    this.id = id;
    this.name = name;
}
function getPosById (id, positions ){
    for (var x in positions ){
        if(x.id = id)
            return x;
        else console.log('không có position có id bằng' + id);
    }
}

function account (id, email, username, fullname, depID, posID,groupID, createDate){
    this.id = id;
    this.email = email;
    this.username = username;
    this.fullname = fullname;
    this.department = getDepById(depID);
    this.position = getPosById (posID);
    this.group = getGroupById (groupID);
    this.createDate = createDate;
}

function group (id,name,creatorID,createDate){
    this.id =id;
    this.name = name;
    this.creatorID = creatorID;
    this.creatorID =createDate;
}

function getGroupById (id, groups ){
    for (var x in positions ){
        if(x.id = id)
            return x;
        else console.log('không có group có id bằng' + id);
    }
}
var departments =[] ;
 departments.push (new department(1,"marketing"));
 departments.push (new department(2,"code"));
 departments.push (new department(3,"sales"));
var positions= [];
 positions.push (new position(1, "cheaf"));
 positions.push (new position(2, "side kick"));
 positions.push (new position(3, "employee"));
var groups =[];
 groups.push (new group (1, "group1", 1, "2021"));
 groups.push (new group (2, "group2", 1, "2020"));
 groups.push (new group (3, "group3", 1, "2019"));
var accounts =[];
 accounts.push (new account(1,"1@gmail.com","user1","Tung",1,1,1,"2020"));
 accounts.push (new account(2,"2@gmail.com","user2","Tuan",2,2,1,"2020"));
 accounts.push (new account(3,"3@gmail.com","user3","Tien",3,4,1,"2020"));

for ( var i=0;i<=20;i+=2) console.log(i);