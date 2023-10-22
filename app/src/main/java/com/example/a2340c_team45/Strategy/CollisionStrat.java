package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.view.RectangleWallView;

public interface CollisionStrat {

    boolean isColliding(Player obj1, RectangleWallView obj2);
}
