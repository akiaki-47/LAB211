/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kietna.management;

import java.util.Scanner;
import kietna.info.PersonalInfo;

/**
 *
 * @author Admin
 */
class PersonalWrap {

    PersonalInfo p;

    public PersonalWrap() {
    }

    public PersonalWrap(PersonalInfo p) {
        this.p = p;
    }
}

public class ManagerPerson {

    private final Scanner sc = new Scanner(System.in);

    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Input must be a digit.");
                System.out.print("Try-again: ");
            }
        }
    }

    public double checkInputSalary() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                if (result < 0) {
                    System.out.println("Salary is bigger than 0");
                    System.out.print("Salary: ");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.out.println("Salary must be a digit.");
                System.out.print("Salary: ");
            }
        }
    }

    public void swap(PersonalWrap person1, PersonalWrap person2) {
        PersonalInfo temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }

    public void sortBySalary(PersonalInfo[] persons, PersonalWrap[] listPersonWrap) {
        int n = persons.length;

        for (int i = 0; i < persons.length; i++) {
            listPersonWrap[i] = new PersonalWrap(persons[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrap[i].p.getSalary() > listPersonWrap[j].p.getSalary()) {
                    swap(listPersonWrap[i], listPersonWrap[j]);
                }
            }
        }
    }

    public PersonalInfo inputPerson() {
        System.out.println("----Input Information----");
        System.out.print("Input name: ");
        String name = checkInputString();
        System.out.print("Input address: ");
        String address = checkInputString();
        System.out.print("Input salary: ");
        double salary = checkInputSalary();
        PersonalInfo person = new PersonalInfo(name, address, salary);
        return person;
    }

    public static void main(String[] args) {
        ManagerPerson mp = new ManagerPerson();
        System.out.print("Enter number student: ");
        int n = mp.checkInputInt();
        PersonalInfo[] persons = new PersonalInfo[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = mp.inputPerson();
        }
        System.out.println("--------------------------");
        PersonalWrap[] listPersonalWrap = new PersonalWrap[persons.length];
        mp.sortBySalary(persons, listPersonalWrap);
        for (int i = 0; i < persons.length; i++) {
            listPersonalWrap[i].p.showInfo();
        }
    }

}
