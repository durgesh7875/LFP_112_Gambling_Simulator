package com.bridgelabz.gamblingsimulator;

import java.util.Scanner;

public class GamblingSimulator {

    public static int counter;
    static int BET_PER_DAY = 1;
    static int TOTAL_MONTHS = 1;
    static int TOTAL_DAYS = 20;
    static int[] perDayAmount;// = new int[TOTAL_DAYS];//for the storing day wiz amount

    GamblingSimulator() {
        counter = 0;//initialize the counter
    }

    public static void main(String[] args) {
        Stakes stakes = new Stakes();
        //Repeat if user want  to play next month
        while (TOTAL_MONTHS == 1) {
            TOTAL_DAYS = 20; //Reinitialize for next month
            counter = 0;//Reinitialize for next month
            perDayAmount = new int[TOTAL_DAYS];//Reinitialize for next month
            int totalDays = TOTAL_DAYS;
            while (totalDays > 0) {
                checkWinnerLoose();
                totalDays--;
            }
            System.out.println("You want to play again if yes press 1, If not press 0");
            TOTAL_MONTHS = (new Scanner(System.in)).nextInt();
            if (TOTAL_MONTHS == 0) {
                break;
            }
            calculateLuckyDay(perDayAmount);
        }
    }

    //Find the lucky and unlucky day from the month
    public static void calculateLuckyDay(int[] perDayAmount) {
        int lucky = perDayAmount[0];
        int unLucky = perDayAmount[0];
        int luckyWinDay = 0;
        int unLuckyLostDay = 0;
        for (int i = 0; i < perDayAmount.length; i++) {
            if (lucky < perDayAmount[i]) {
                luckyWinDay = i;
                lucky = perDayAmount[i];
            }
            if (unLucky > perDayAmount[i]) {
                unLuckyLostDay = i;
                unLucky = perDayAmount[i];
            }
        }
        System.out.println("luckiest day where you won maximum : " + luckyWinDay);
        System.out.println("Unluckiest day where you lost maximum : " + unLuckyLostDay);
    }

    //Check the bet win or loose
    public static void checkWinnerLoose() {
        Stakes stakes = new Stakes();
        int loosCash = 0;
        int winCash = 0;
        //50% of Stake
        int minStake = stakes.getTotalStakes() - 50;
        int maxStake = stakes.getTotalStakes() + 50;
        //Win lost 50% stake
        while (stakes.getTotalStakes() > minStake && stakes.getTotalStakes() < maxStake) {
            int betState = (int) ((Math.random() * 10)) % 2;

            int bet = stakes.getTotalStakes();

            if (betState == 1) {
                stakes.setTotalStakes(bet + BET_PER_DAY);
                winCash++;

            } else {
                stakes.setTotalStakes(bet - BET_PER_DAY);
                loosCash++;
            }
        }
        calculatePerDayAmmount(stakes.getTotalStakes(), winCash, loosCash);
    }

    public static void calculatePerDayAmmount(int totalStakes, int winCash, int loosCash) {
        // Storing the win or lost amount in variable
        if (totalStakes == 150) {
            perDayAmount[counter++] = winCash;
        } else perDayAmount[counter++] = loosCash;
    }
}

