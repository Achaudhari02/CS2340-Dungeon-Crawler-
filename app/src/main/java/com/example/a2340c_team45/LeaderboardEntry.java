package com.example.a2340c_team45;

import java.util.Date;

public class LeaderboardEntry {
    private String name;
    private int score;
    private Date date;
    public LeaderboardEntry(String name, int score) {
        this.name = name;
        this.score = score;
        date = new java.util.Date();
    }
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
    public String getEntry() {
        return "Name: " + name + "  Score: " + score + "  Date: " + date;
    }
}
