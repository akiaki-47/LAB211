/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import information.Fruit;
import information.Order;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        ArrayList<Fruit> listF = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> listTable = new Hashtable<>();
        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.createFruit(listF);
                    break;
                case 2:
                    manager.viewOrder(listTable);
                    break;
                case 3:
                    manager.shopping(listF, listTable);
                    break;
                case 4:
                    return;
            }
        }
    }

}
