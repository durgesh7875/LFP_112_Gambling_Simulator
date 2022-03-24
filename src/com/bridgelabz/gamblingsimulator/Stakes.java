package com.bridgelabz.gamblingsimulator;

public class Stakes {
    int stakesPerDay;
    int betPerGame;

    public Stakes(int stakesPerDay, int betPerGame) {
        this.stakesPerDay = stakesPerDay;
        this.betPerGame = betPerGame;
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
        this.betPerGame = betPerGame;
    }
}
