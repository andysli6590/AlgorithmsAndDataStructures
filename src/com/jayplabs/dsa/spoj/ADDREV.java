package com.jayplabs.dsa.spoj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Chandra Gopalaiah on 11/13/16.
 *
 * ADDREV - Adding Reversed Numbers - http://www.spoj.com/problems/ADDREV/
 *
 */
public class ADDREV {

    public static int reverse(int num) {
        int reverseNum = 0;
        while (num != 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }
        return reverseNum;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            int sum = reverse(num1) + reverse(num2);
            System.out.println(reverse(sum));
        }

    }
}
