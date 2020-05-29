/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kietna.linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LinearSearch {

    private static Scanner sc = new Scanner(System.in);

    public int linearSearch(int[] arr, int key) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print("Enter number of array:");
        int length = Integer.parseInt(sc.nextLine());

        System.out.print("Enter search value:");
        int search = Integer.parseInt(sc.nextLine());

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        LinearSearch searcher = new LinearSearch();
        System.out.print("The array: [");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

        int foundIndex = searcher.linearSearch(array, search);
        System.out.println("\nFound " + search + " at index: " + foundIndex);
    }
}
