/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kietna.main;

import java.util.ArrayList;
import kietna.info.Account;
import validation.MyToys;

/**
 *
 * @author Admin
 */
public class ManageAccount {
    public void addNewAccount(ArrayList<Account> listAcc){
        System.out.println("------------Add a new user------------");
        String username = MyToys.getUsername("Username: ", "Not empty", "", "");
        
    }
}
