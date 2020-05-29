/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import kietna.info.Account;

/**
 *
 * @author Admin
 */
public class MyToys {

    private static final Scanner in = new Scanner(System.in);
    /*
    \\d{10} user must be input 10 number
    \\d* user can input more number or not
     */
    private static final String PHONE_VALID = "^\\d{10}\\d*$";

    /*
    [A-Za-z0-9.-+%]+ user must be input from a-z ignore case,0-9 and .-+% least one times
    @ user must be input "@"
    [A-Za-z.-]+ user mustbe input from a-z ignore case, "." "-" least one times
    \\. user must be input "."
    [A-Za-z]{2,4} user must be input from a-z ignore 2 - 4 times
     */
    private static final String EMAIL_VALID
            = "\\w+@\\w{2,5}(([.]\\w{2,5})?([.]\\w{2,5})?)";
    private static final String NAME_VALID = "[A-Za-z ]{1,50}";

    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input name
    public static String checkInputName() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else if (!result.matches(NAME_VALID)) {
                System.out.println("Name must be characters.");
                System.out.print("Enter again: ");
            }
            return result;
        }
    }

    //check user input y/Y or n/N
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check phone is number with minimum 10 characters
    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            //check user input phone valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    //check email with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)
    public static String checkInputEmail() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check user input email valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input graduation rank
    public static String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    //check id exist or not
    public static boolean checkUsernameExist(ArrayList<Account> accounts, String username) {
        for (Account account : accounts) {
            if (account.getUsername() == username) {
                System.err.println("Username exist.");
                return false;
            }
        }
        return true;
    }

    //check experience must be smaller then age
    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }

    public static String getUsername(String inputMsg, String errorMsg, String error2, String format) {
        String user;
        boolean match;
        while (true) {
            System.out.println(inputMsg);
            user = in.nextLine().trim();
            match = user.matches(format);
            if (user.length() == 0 || user.isEmpty()) {
                System.out.println(errorMsg);
            } else if (match == false) {
                System.out.println(error2);
            } else {
                return user;
            }
        }
    }
}
