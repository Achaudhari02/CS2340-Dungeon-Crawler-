package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Player;

public interface MovementStrat {
    void move(Player player);
    boolean ableMove(Player player);
}
