/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kietna.counter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class Counter {

    private static Scanner sc = new Scanner(System.in);
    private static Map<Character, Integer> charCounter = new HashMap<>();
    private static Map<String, Integer> stringCounter = new HashMap<>();

    public void analyze(String content) {
        //character counter
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, (int) charCounter.get(ch) + 1);
            }
        }
        //content count
        StringTokenizer stk = new StringTokenizer(content);
        while (stk.hasMoreTokens()) {            
            String token = stk.nextToken();
            if (!stringCounter.containsKey(token)) {
                stringCounter.put(token, 1);
            } else {
                stringCounter.put(token, (int) stringCounter.get(token) + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.print("Enter your content: ");
        String content = sc.nextLine();
        Counter counter = new Counter();
        counter.analyze(content);
        System.out.println(charCounter);
        System.out.println(stringCounter);
    }
}
