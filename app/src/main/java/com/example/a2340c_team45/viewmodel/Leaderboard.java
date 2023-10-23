package com.example.a2340c_team45.viewmodel;

import android.os.Handler;

import com.example.a2340c_team45.models.LeaderboardEntry;

import java.util.ArrayList;

public class Leaderboard {
    private static Leaderboard leaderboard;
    private ArrayList<LeaderboardEntry> entries = new ArrayList<>(100);
    private static int score = 1000;
    private static boolean running;
    private static int time;
    private Leaderboard() { }
    public static Leaderboard getLeaderboard() { //singleton for leaderboard
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
            leaderboard.running = true;
            doTime();
        }
        return leaderboard;
    }
    public void setArrayList(ArrayList<LeaderboardEntry> entries) {
        this.entries = entries;
    }
    public ArrayList<LeaderboardEntry> getArrayList() {
        return entries;
    }

    public ArrayList<LeaderboardEntry> getEntries() {
        return entries;
    }

    public String toString() { // prints out top 5 scores with name, score, and date
        String list = "";
        if (entries.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                list = list.concat(entries.get(i).getEntry());
                list = list.concat("\n");
            }
        } else {
            for (int i = 0; i < entries.size(); i++) {
                list = list.concat(entries.get(i).getEntry());
                list = list.concat("\n");
            }
        }
        return list;
    }
    public void add(LeaderboardEntry entry) { // adds the entry and sorts by descending order
        if (entries.size() == 0) {
            entries.add(0, entry);
        } else {
            for (int i = entries.size() - 1; i >= 0; i--) {
                entries.add(entry);
                if (entries.get(i).getScore() < entry.getScore()) {
                    LeaderboardEntry temp = entries.get(i);
                    entries.set(i, entry);
                    entries.set(i + 1, temp);
                }
            }
        }

    }

    public static int getScore() {
        return score - time;
    }

    private static void doTime() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                if (running) {
                    time++;
                }
                handler.postDelayed(this, 1000);
            }
        });

    }
}
