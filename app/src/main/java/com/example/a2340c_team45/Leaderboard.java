package com.example.a2340c_team45;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Leaderboard {
    private static Leaderboard leaderboard;
    public ArrayList<LeaderboardEntry> entries = new ArrayList<>(100);
    private Leaderboard() {

    }
    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }
    public void setArrayList(ArrayList<LeaderboardEntry> entries) {
        this.entries = entries;
    }
    public ArrayList<LeaderboardEntry> getArrayList() {
        return entries;
    }
    public String toString() {
        String list = "";
        if (entries.size() >=5 ) {
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
    public void add(LeaderboardEntry entry) {
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
}
