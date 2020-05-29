/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubbleSort;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BubbleSort {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int n = sort.inputSizeOfArray();
        int[] a = sort.inputValueOfArray(n);
        sort.sortArray(a);
        sort.printArray(a);
    }

    private int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input a number");
                System.out.println("Try again: ");
            }
        }
    }

    private int inputSizeOfArray() {
        System.out.println("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }

    private int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter a[" + i + "]: ");
            a[i] = checkInputInt();
        }
        return a;
    }

    private void printArray(int[] a) {
        System.out.println("Sort Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private void sortArray(int[] a) {
        System.out.print("Unsorted: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
    }
}
