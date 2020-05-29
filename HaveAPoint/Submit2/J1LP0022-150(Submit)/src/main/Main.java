/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import manager.ManageCandidate;
import persons.Candidate;
import persons.Experience;
import persons.Fresher;
import persons.Internship;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        ManageCandidate mc = new ManageCandidate();
        ArrayList<Candidate> candidates = new ArrayList<>();
//        candidates.add(new Experience(10, "HIhi", "SE130172", "Nguyen", "AnhKiet", 1999, "23/10", "0123123123", "kietnase130172@gmail.com.vn", 0));
//        candidates.add(new Experience(10, "HIhi", "SE130172", "Kguyen", "AnhKiet", 1999, "23/10", "0123123123", "kietnase130172@gmail.com.vn", 0));
//        candidates.add(new Fresher("2/2/2020", "10", "FPTU-GV", "Kieu", "Trong Khanh", 1954, "khong biete", "0909999999", "khanhkt@fu.fpt.vn", 1));
//        candidates.add(new Internship("Software Engineer", "Spring 2020", "FPT", "BA101212", "Huynh", "Buu", 2000, "1212", "0121212123", "buuh2020@fpt.edu.vn", 2));
        while (true) {
            int choice = mc.menu();
            switch (choice) {
                case 1:
                    mc.createCandidate(candidates, 0);
                    break;
                case 2:
                    mc.createCandidate(candidates, 1);
                    break;
                case 3:
                    mc.createCandidate(candidates, 2);
                    break;
                case 4:
                    mc.searchNameCandidate(candidates);
                    break;
                case 5:
                    return;
            }
        }
    }
}
