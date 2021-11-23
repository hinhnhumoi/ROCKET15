package org.VTI.Test;

import org.VTI.Entity.Account;
import org.VTI.Entity.Address;
import org.VTI.Repository.AccountRepository;
import org.VTI.Repository.AddressRepository;

import java.util.List;

public class AccountTest {
    public static void main(String[] args) {

        AccountRepository accountRepository = new AccountRepository();

//        Exam examCreate = new Exam();
//        examCreate.setTitle("Bai thi 1");
//        examCreate.setDuration((short) 185);

//        departmentRepository.createExam(examCreate);

        List<Account> accounts= accountRepository.getAllAccount() ;

        for (Account account: accounts) {
            System.out.println(account);
        }
    }
}
