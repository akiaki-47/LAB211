/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import info.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class StudentInformation {

    private final Scanner sc = new Scanner(System.in);
    private final String NAME = "[A-Za-z]+";
    private final String CLASS = "\\w+";
    
    private float checkInputFloat(int min, int max) {
        while (true) {
            try {
                float result = Float.parseFloat(sc.nextLine());
                if (result < min || result > max) {
                    System.out.println("Marks must be from 0 to 100");
                    System.out.print("Marks:");
                } else 
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Marks must be digit: ");
            }
        }
    }

    private String checkInputString() {
        boolean match;
        while (true) {
            try {
                String result = sc.nextLine();
                match = result.matches(NAME);
                if (result.length() == 0) {
                    System.out.println("Please not empty.");
                    System.out.print("Name:");
                } else if (match == false) {
                    System.out.print("Please input character: ");
                } else 
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }   
        }
    }
    
    private String checkInputClass() {
        boolean match;
        while (true) {
            try {
                String result = sc.nextLine();
                match = result.matches(CLASS);
                if (result.length() == 0) {
                    System.out.println("Please not empty.");
                    System.out.print("Class:");
                }  else if (match == false) {
                    System.out.print("Class:");
                } else 
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }   
        }
    }

    private boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine();
            if (result.length() == 1 && result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.length() == 1 && result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please choose Y or N: ");
        }
    }
    
    private void addStudent(ArrayList<Student> listStudent){
        System.out.println("---------Input student information---------");
        System.out.print("Name: ");
        String name = checkInputString();
        System.out.print("Class: ");
        String classes = checkInputClass();
        System.out.print("Marks: ");
        float mark = checkInputFloat(0, 100);
        listStudent.add(new Student(name, mark, classes));
    }
    
    private void printStudents(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("--------Student " + i + 1 + "--------");
            System.out.println("Name: " + list.get(i).getName());
            System.out.println("Classes: " + list.get(i).getClasses());
            System.out.println("Mark: " + list.get(i).getMark());
        }
    }

    public static void main(String[] args) {
        StudentInformation stin = new StudentInformation();
        ArrayList<Student> list = new ArrayList<>();
        stin.addStudent(list);
        while (true) {            
            System.out.println("Do you want to enter more student information? (Y/N): ");
            if (stin.checkInputYN()) {
                stin.addStudent(list);
            } else {
                break;
            }
        }
        stin.printStudents(list);
    }
}
