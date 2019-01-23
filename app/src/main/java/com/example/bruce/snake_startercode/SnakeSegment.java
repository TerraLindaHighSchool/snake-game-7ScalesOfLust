package com.example.bruce.snake_startercode;

public class SnakeSegment {

    private int mXLoc;
    private int mYLoc;
    private int mDegrees;
    private Body mBodyPart;

    SnakeSegment(Body bodyPart, int degrees, int xLoc, int yLoc){
        mXLoc = xLoc;
        mYLoc = yLoc;
        mDegrees = degrees;
        mBodyPart = bodyPart;
    }

    protected enum Body{
        HEAD, BODY, TAIL
    }

    protected Body getBodyPart() {
        return mBodyPart;
    }

    protected int getXLoc() {
        return mXLoc;
    }

    protected void setXLoc(int XLoc) {
        mXLoc = XLoc;
    }

    protected int getYLoc() {
        return mYLoc;
    }

    protected void setYLoc(int YLoc) {
        mYLoc = YLoc;
    }

    protected int getDegrees() {
        return mDegrees;
    }

    protected void setDegrees(int degrees) {
        mDegrees = degrees;
    }

}
