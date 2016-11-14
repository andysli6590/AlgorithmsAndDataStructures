package com.jayplabs.dsa.dp;

/**
 * Created by Chandra Gopalaiah on 11/8/16.
 *
 * Objective:
 * Give a amount N, if we want to make change for N, and we have an infinite supply of coins, how many ways can we
 * make the change.
 * Note : The order of coins doesn't matter
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * http://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
 * https://www.hackerrank.com/challenges/coin-change
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

    public static int coinChangeRec(int[] coins, int amount, int coinIndex) {
        if (amount < 0) return 0;

        if (amount == 0) return 1;

        // coins are exhausted but still amount is left, hence no solution
        if (coinIndex == coins.length && amount > 0) return 0;

        return coinChangeRec(coins, amount-coins[coinIndex], coinIndex) + coinChangeRec(coins, amount, coinIndex+1);
    }

    public static int coinChangeDP(int[] coins, int amount) {
        int[][] sol = new int[coins.length+1][amount+1];

        for (int i=0;i<=coins.length;i++) {
            sol[i][0] = 1;
        }

        for (int j=1;j<=amount;j++) {
            sol[0][j] = 0;
        }

        for (int i=1;i<=coins.length;i++) {
            for (int j=1;j<=amount;j++) {
                // coin can be used only if it is less than amount
                if (coins[i-1] <= j) {
                    sol[i][j] = sol[i-1][j] +       // excluding coin
                            sol[i][j - coins[i-1]]; // including coin
                } else {
                    sol[i][j] = sol[i-1][j]; // previous coin with same amount
                }
            }
        }

        return sol[coins.length][amount];
    }

    public static void main(String[] args) {
        int amount = 4;
        int[] coins = {1,2,3};
        System.out.println("By Dynamic Programming " + coinChangeDP(coins, amount));
        System.out.println("By Recursive Programming " + coinChangeRec(coins, amount, 0));
    }
}
