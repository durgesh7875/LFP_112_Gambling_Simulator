package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {

    public static int counter;
    static int BET_PER_DAY = 1;
    static int TOTAL_MONTHS = 5;
    static int TOTAL_DAYS = 20;
    static int[] perDayAmount;// = new int[TOTAL_DAYS];//for the storing day wiz amount

    GamblingSimulator() {

        counter = 0;//initialize the counter
    }

    public static void main(String[] args) {
        Stakes stakes = new Stakes();
        while (TOTAL_MONTHS >= 1) {
            TOTAL_DAYS = 20;
            counter = 0;
            perDayAmount = new int[TOTAL_DAYS];
            int totalDays = TOTAL_DAYS;
            while (totalDays > 0) {
                checkWinnerLoose();
                totalDays--;
            }
            TOTAL_MONTHS--;
            calculateLuckyDay(perDayAmount);
        }
    }

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

    //Print the day wise amount
    public static void printResult() {
        for (int i = 0; i < TOTAL_DAYS; i++) {
            System.out.println("Day " + (i + 1) + " Amount is " + perDayAmount[i]);
        }
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

