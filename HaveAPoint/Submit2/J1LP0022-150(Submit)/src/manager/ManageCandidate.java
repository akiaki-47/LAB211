/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.ArrayList;
import java.util.Calendar;
import persons.Candidate;
import persons.Experience;
import persons.Fresher;
import persons.Internship;
import validation.MyToys;

/**
 *
 * @author Admin
 */
public class ManageCandidate {

    public int menu() {
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = MyToys.checkInputIntLimit(1, 5);
        return choice;
    }

    public void createCandidate(ArrayList<Candidate> candidates, int type) {
        //loop until user don't want to create new a candidate
        while (true) {
            //input info
            System.out.print("ID: ");
            String id = MyToys.checkInputString();
            System.out.print("First name: ");
            String fname = MyToys.checkInputName();
            System.out.print("Last name: ");
            String lname = MyToys.checkInputName();
            System.out.print("Birth of Date: ");
            int birthDate = MyToys.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Address: ");
            String address = MyToys.checkInputString();
            System.out.print("Phone: ");
            String phone = MyToys.checkInputPhone();
            System.out.println("Email: ");
            String email = MyToys.checkInputEmail();
            //create a new candidate
            Candidate candidate = new Candidate(id, fname, lname, birthDate, address, phone, email, type);
            //check id exist or not
            if (MyToys.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        //experience
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        //fresher
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        //internship
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            if (!MyToys.checkInputYN()) {
                return;
            }

        }
    }

    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = MyToys.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = MyToys.checkInputString();
        candidates.add(new Experience(yearExperience, professionalSkill, candidate.getId(), candidate.getFirstName(),
                candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getTypeCandidate()));
        System.out.println("Create Success.");
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = MyToys.checkInputString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = MyToys.checkInputGraduationRank();
        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.out.println("Create Success.");
    }

    public void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter major: ");
        String major = MyToys.checkInputString();
        System.out.print("Enter semester: ");
        String semester = MyToys.checkInputString();
        System.out.print("Enter university: ");
        String university = MyToys.checkInputString();
        candidates.add(new Internship(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public void searchNameCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        boolean key = false;
        System.out.print("Enter candidate name (First Name or Last Name): ");
        String nameSearch = MyToys.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = MyToys.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && (candidate.getFirstName().contains(nameSearch) || candidate.getLastName().contains(nameSearch))) {
                System.out.println(candidate.toString());
                key = true;
            }
        }
        if (!key) {
            System.out.println("Can't found");
        }
    }

    public void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.out.println("-------Experience-------");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("-------Fresher-------");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("-------Internship-------");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("------------------------------");
    }
}
