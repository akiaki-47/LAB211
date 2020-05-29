/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CheckDataFormat {

    private final String PHONE = "\\d{10}";
    private final String EMAIL = "\\w+@\\w{2,5}(([.]\\w{2,5})([.]\\w{2,5})?)";
    private final Scanner sc = new Scanner(System.in);

    private String checkInputString() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Empty.");
            } else {
                return input;
            }
        }
    }

    private String checkPhoneNumber() {
        while (true) {
            try {
                String phone = sc.nextLine().trim();
                if (!(phone.matches(PHONE))) {
                    System.out.println("Wrong format!");
                    System.out.print("Enter again: ");
                } else {
                    return phone;
                }
            } catch (Exception e) {
                System.out.println("Wrong format!");
                System.out.print("Enter again: ");
            }
        }
    }

    private String checkEmail() {
        while (true) {
            String mail = sc.nextLine().trim();
            if (!(mail.matches(EMAIL))) {
                System.out.println("Wrong format!");
                System.out.print("Enter again: ");
            } else {
                return mail;
            }
        }
    }

    private String checkDate() {
        while (true) {
            try {
                String dateCheck = checkInputString();
                Date date = new SimpleDateFormat("dd/MM/YYYY").parse(dateCheck);
                return dateCheck;
            } catch (ParseException e) {
                System.out.println("Somethings wrong in DateCheck");
                System.out.print("Enter again: ");
            }
        }
    }

    public static void main(String[] args) {
        CheckDataFormat cdf = new CheckDataFormat();
        System.out.print("Enter phone number: ");
        cdf.checkPhoneNumber();
        System.out.print("Enter email: ");
        cdf.checkEmail();
        System.out.print("Enter date: ");
        cdf.checkDate();
    }

}
