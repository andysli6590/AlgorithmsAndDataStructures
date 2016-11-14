package com.jayplabs.dsa.spoj;

import java.util.Scanner;

/**
 * Created by Chandra Gopalaiah on 11/13/16.
 *
 * http://www.spoj.com/problems/TEST/
 */
public class TEST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int input = scanner.nextInt();
            if (input == 42) {
                break;
            }
            System.out.println(input);
        }

    }
}
