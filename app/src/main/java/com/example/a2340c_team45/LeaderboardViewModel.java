package com.example.a2340c_team45;

import java.util.ArrayList;

public class LeaderboardViewModel {
    private static LeaderboardViewModel leaderboardViewModel;
    public ArrayList<LeaderboardEntryModel> entries = new ArrayList<>(100);
    private LeaderboardViewModel() {

    }
    public static LeaderboardViewModel getLeaderboard() { //singleton for leaderboard
        if (leaderboardViewModel == null) {
            leaderboardViewModel = new LeaderboardViewModel();
        }
        return leaderboardViewModel;
    }
    public void setArrayList(ArrayList<LeaderboardEntryModel> entries) {
        this.entries = entries;
    }
    public ArrayList<LeaderboardEntryModel> getArrayList() {
        return entries;
    }
    public String toString() { // prints out top 5 scores with name, score, and date
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
    public void add(LeaderboardEntryModel entry) { // adds the entry and sorts by descending order
        if (entries.size() == 0) {
            entries.add(0, entry);
        } else {
            for (int i = entries.size() - 1; i >= 0; i--) {
                entries.add(entry);
                if (entries.get(i).getScore() < entry.getScore()) {
                    LeaderboardEntryModel temp = entries.get(i);
                    entries.set(i, entry);
                    entries.set(i + 1, temp);
                }
            }
        }

    }
}
