package com.example.bruce.snake_startercode;

public class PivotPoint {
    private int mXLoc;
    private int mYLoc;
    private int mDegree;

    PivotPoint(int xLoc, int yLoc, int degree){
        mXLoc = xLoc;
        mYLoc = yLoc;
        mDegree = degree;
    }

    // Getters
    public int getXLoc() {
        return mXLoc;
    }

    public int getYLoc() {
        return mYLoc;
    }

    public int getDegree() {
        return mDegree;
    }
}
