/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kietna.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kietna.info.Student;
import kietna.validation.MyToys;

/**
 *
 * @author Admin
 */
public class Main {

    public void createStudent(ArrayList<Student> list) {
        while (true) {
            String name = MyToys.getString("Name: ", "Not Empty.","[A-Za-z]{1,50}");
            String className = MyToys.getString("Class: ", "Not empty.");
            System.out.print("Maths: ");
            double maths = MyToys.checkInputMark("Maths");
            System.out.print("Chemistry: ");
            double chemistry = MyToys.checkInputMark("Chemistry");
            System.out.print("Physics: ");
            double physics = MyToys.checkInputMark("Physics");
            double average = (maths + chemistry + physics) / 3;
            char type;
            if (average > 7.5) {
                type = 'A';
            } else if (average >= 6 && average <= 7.5) {
                type = 'B';
            } else if (average >= 4 && average < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            list.add(new Student(name, className, maths, physics, chemistry, average, type));
            if (!MyToys.checkYN()) {
                return;
            }
        }
    }

    public void displayInformationStudent(ArrayList<Student> list) {
        int i = 0;
        for (Student mem : list) {
            System.out.println("Student " + (++i) + " info");
            System.out.println("Name: " + mem.getStudentName());
            System.out.println("Classes: " + mem.getClassName());
            System.out.println("AVG: " + mem.getAverage());
            System.out.println("Type: " + mem.getType());
        }
    }

    public HashMap<String, Double> getPercentTypeStudent(ArrayList<Student> ls) {
        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
        int totalStudent = ls.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (int i = 0; i < totalStudent; i++) {
            if (ls.get(i).getType() == 'A') {
                typeA++;
            }
            if (ls.get(i).getType() == 'B') {
                typeB++;
            }
            if (ls.get(i).getType() == 'C') {
                typeC++;
            }
            if (ls.get(i).getType() == 'D') {
                typeD++;
            }
        }
        getPercentTypeStudent.put("A", typeA / totalStudent * 100);
        getPercentTypeStudent.put("B", typeB / totalStudent * 100);
        getPercentTypeStudent.put("C", typeC / totalStudent * 100);
        getPercentTypeStudent.put("D", typeD / totalStudent * 100);
        return getPercentTypeStudent;
    }

    public static void main(String[] args) {
        Main student = new Main();
        ArrayList<Student> list = new ArrayList<>();
        student.createStudent(list);
        student.displayInformationStudent(list);
        HashMap<String, Double> getPercent = student.getPercentTypeStudent(list);
        for (Map.Entry<String, Double> type : getPercent.entrySet()) {
            System.out.println(type.getKey() + " " + type.getValue() + " %");
        }
    }
}
