package com.bridgelabz.gamblingsimulator;

public class Stakes {
    int stakesPerDay;
    static int betPerGame = 1;
    static int totalStakes = 100;


    public Stakes(int stakesPerDay, int betPerGame) {
        this.stakesPerDay = stakesPerDay;
        this.betPerGame = betPerGame;
    }

    public Stakes() {

    }

    public int getTotalStakes() {
        return totalStakes;
    }

    public void setTotalStakes(int totalStakes) {
        Stakes.totalStakes = totalStakes;
    }

    public int getStakesPerDay() {
        return stakesPerDay;
    }

    public void setStakesPerDay(int stakesPerDay) {
        this.stakesPerDay = stakesPerDay;
    }

    public int getBetPerGame() {
        return betPerGame;
    }

    public void setBetPerGame(int betPerGame) {
        Stakes.betPerGame = betPerGame;
    }
}
