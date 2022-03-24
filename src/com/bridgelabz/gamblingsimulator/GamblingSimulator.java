package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {

    static int BET_PER_DAY = 1;

    public static void checkWinOrLoose() {
        Stakes stakes = new Stakes();

        int minStake = stakes.getTotalStakes() - 50;
        int maxStake = stakes.getTotalStakes() + 50;

        while(stakes.getTotalStakes() > minStake && stakes.getTotalStakes() > maxStake) {
            int betState = (int) ((Math.random() * 10)) % 2;

            int bet = stakes.getTotalStakes();

            if(betState == 1) {
                stakes.setTotalStakes(bet + BET_PER_DAY);
            }
            else {
                stakes.setTotalStakes(bet - BET_PER_DAY);
            }
        }
    }

    public static void printResult () {
        Stakes stakes = new Stakes();

        // Start with 100$ Stakes for every day and 1$ bet for every game.
        System.out.println("Total stakes for day: " + stakes.getTotalStakes() + "$");
        System.out.println("Total bet per game: " + stakes.getBetPerGame() + "$");
    }

    public static void main(String[] args) {
        checkWinOrLoose();
        printResult();
    }
}
