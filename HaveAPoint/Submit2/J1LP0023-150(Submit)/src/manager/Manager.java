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
public class Manager {

    //Show Menu
    public int menu() {
        int choice;
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = MyToys.checkInputIntLimit(1, 4);
        return choice;
    }

    // Allow user create fruit
    public void createFruit(ArrayList<Fruit> list) {
        while (true) {
            System.out.print("Enter Fruit Id: ");
            String fruitId = MyToys.checkInputString();
            if (!MyToys.checkIdExist(list, fruitId)) {
                System.out.println("Id existed");
            } else {
                System.out.print("Enter Fruit Name: ");
                String fruitName = MyToys.checkInputString();
                System.out.print("Enter price: ");
                double price = MyToys.checkInputDouble();
                System.out.print("Enter quantity: ");
                int quantity = MyToys.checkInputInt();
                System.out.print("Enter origin: ");
                String origin = MyToys.checkInputString();
                list.add(new Fruit(fruitId, fruitName, price, quantity, origin));
                //check user want to continue or not
                if (!MyToys.checkInputYN()) {
                    return;
                }
            }
        }
    }

    //Allow user show order
    public void viewOrder(Hashtable<String, ArrayList<Order>> hasht) {
        if (hasht.isEmpty()) {
            System.out.println("View Order is empty " + "\n");
            return;
        } else {
            for (String name : hasht.keySet()) {
                System.out.println("Customer: " + name);
                ArrayList<Order> listOrder = hasht.get(name);
                displayListOrder(listOrder);
            }
        }
    }

    public void shopping(ArrayList<Fruit> list, Hashtable<String, ArrayList<Order>> listHash) {
        if (list.isEmpty()) {
            System.out.println("No have items.");
            return;
        } else {
            ArrayList<Order> lo = new ArrayList<>();
            while (true) {
                displayListFruit(list);
                System.out.print("Enter item: ");
                int item = MyToys.checkInputIntLimit(1, list.size());
                Fruit fruit = getFruitByItem(list, item);
                System.out.print("Enter quantity: ");
                int quantity = MyToys.checkInputIntLimit(1, fruit.getQuantity());
                fruit.setQuantity(fruit.getQuantity() - quantity);
                //check item exist or not
                if (!MyToys.checkItemExist(lo, fruit.getFruitId())) {
                    updateOrder(lo, fruit.getFruitId(), quantity);
                } else {
                    lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                            quantity, fruit.getPrice()));
                }
                if (!MyToys.checkInputYN()) {
                    break;
                }
            }
            displayListOrder(lo);
            System.out.print("Enter name: ");
            String name = MyToys.checkInputString();
            listHash.put(name, lo);
        }
        System.err.println("Add successfull");
    }

    public void displayListFruit(ArrayList<Fruit> list) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : list) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    //get fruit user want to buy
    public Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

}
