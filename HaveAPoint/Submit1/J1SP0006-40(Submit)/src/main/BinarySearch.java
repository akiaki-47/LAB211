/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BinarySearch {

    private static Scanner sc = new Scanner(System.in);

    public int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }

    public void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public void displayArray(int[] arr) {
        System.out.print("Array sorted: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Random rd = new Random();
        System.out.print("Enter a number of array: ");
        int length = Integer.parseInt(sc.nextLine());

        System.out.print("Enter search value: ");
        int searchNumber = Integer.parseInt(sc.nextLine());

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = rd.nextInt(length);
        }
        BinarySearch search = new BinarySearch();
        search.bubbleSort(array);
        search.displayArray(array);

        int index = search.binarySearch(array, searchNumber, 0, length - 1);
        if (index == -1) {
            System.out.println("\nCan't found");
        } else {
            System.out.println("\nFound " + searchNumber + " at index: " + index);
        }
    }
}
