package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {
    public static void main(String[] args) {
        Stakes stakes = new Stakes(100,1);

        // Start with 100$ Stakes for every day and 1$ bet for every game.
        System.out.println("Total stakes for every day: " + stakes.getStakesPerDay() + "$");
        System.out.println("Total bet for every game: " + stakes.getBetPerGame() + "$");
    }
}
