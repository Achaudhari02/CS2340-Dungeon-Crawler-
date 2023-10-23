package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.view.RectangleWallView;

public class CheckCollision implements CollisionStrat {
    @Override
    public boolean isColliding(Player obj1, RectangleWallView obj2) {
        return obj1.getX() < obj2.getX() + obj2.getWallWidth()
                && obj1.getX() + 25 > obj2.GetX()
                && obj1.getY() < obj2.getY() + obj2.getWallHeigth()
                && obj1.getY() + 25 > obj2.GetY();
    }
}
