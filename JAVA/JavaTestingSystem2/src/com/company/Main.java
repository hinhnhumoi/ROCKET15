package com.company;
import java.time.LocalDate;

import static java.time.LocalDate.now;
import static java.time.LocalDate.of;

public class Main {

    public static void main(String[]args) {
//        Tạo Department
        department dep1 = new department();
        dep1.departmentID = 1;
        dep1.departmentName = "Marketing";
        department dep2 = new department();
        dep2.departmentID = 2;
        dep2.departmentName = "Sale";
        department dep3 = new department();
        dep3.departmentID = 3;
        dep3.departmentName = "BOD";

//        Tạo Position

        position pos1 = new position();
        pos1.positionID = 1;
        pos1.PositionName = "Dev";
        position pos2 = new position();
        pos2.positionID = 2;
        pos2.PositionName = "PM";
        position pos3 = new position();
        pos3.positionID = 3;
        pos3.PositionName = "Scrum_Master";

        // Tạo Group

        group group1 = new group();
        group1.groupID = 1;
        group1.groupName = "Testing System";
        group group2 = new group();
        group2.groupID = 2;
        group2.groupName = "Development";
        group group3 = new group();
        group3.groupID = 3;
        group3.groupName = "Sale";

        // Tạo Account
        account acc1 = new account();
        acc1.accountID = 1;
        acc1.email = "daonq1";
        acc1.userName = "daonq1";
        acc1.fullName = "Dao Nguyen 1";
        acc1.departments = dep1;
        acc1.positions = pos1;
        acc1.createDate = now();
        group[] groupAcc1 = {group1, group2};
        acc1.groups = groupAcc1;
        account acc2 = new account();
        acc2.accountID = 2;
        acc2.email = "daonq2";
        acc2.userName = "daonq2";
        acc2.fullName = "Dao Nguyen 2";
        acc2.departments = dep2;
        acc2.positions = pos2;
        acc2.createDate = of(2021, 03, 17);
        acc2.groups = new group[]{group3, group2};
        account acc3 = new account();
        acc3.accountID = 3;
        acc3.email = "daonq3";
        acc3.userName = "daonq3";
        acc3.fullName = "Dao Nguyen 3";
        acc3.departments = dep3;
        acc3.positions = pos3;
        acc3.createDate = now();

        //Tao typeQuestion
        typeQuestion type1 = new typeQuestion();
        type1.typeID = 1;
        type1.typeName = "loai1";
        typeQuestion type2 = new typeQuestion();
        type1.typeID = 2;
        type1.typeName = "loai2";
        typeQuestion type3 = new typeQuestion();
        type1.typeID = 3;
        type1.typeName = "loai3";

        //  Tao categoryQuestion
        categoryQuestion category1 = new categoryQuestion();
        category1.categoryID = 1;
        category1.categoryName = "khuvuc1";
        categoryQuestion category2 = new categoryQuestion();
        category2.categoryID = 2;
        category2.categoryName = "khuvuc2";
        categoryQuestion category3 = new categoryQuestion();
        category3.categoryID = 3;
        category3.categoryName = "khuvuc3";

        // Tao Question
        question question1 = new question();
        question1.questionID= 1;
        question1.content ="cau hoi 500k";
        question1.categoryQuestions = category1;
        question1.typeQuestions = type1;
        question1.creatorID =1;
        question1.createDate = of(2020,10,15);


    }
}
