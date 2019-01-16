package com.example.bruce.snake_startercode;

public class SnakeSegment {

    private int mXLoc;
    private int mYLoc;
    private int mDegrees;
    private bodyPart mBodyPart;

    SnakeSegment(int xLoc, int yLoc, int degrees, bodyPart bodyPart){
        mXLoc = xLoc;
        mYLoc = yLoc;
        mDegrees = degrees;
        mBodyPart = bodyPart;
    }

    public enum bodyPart{
        HEAD, BODY, TAIL
    }

    public bodyPart getBodyParts() {
        return mBodyPart;
    }

    public int getXLoc() {
        return mXLoc;
    }

    public void setXLoc(int XLoc) {
        mXLoc = XLoc;
    }

    public int getYLoc() {
        return mYLoc;
    }

    public void setYLoc(int YLoc) {
        mYLoc = YLoc;
    }

    public int getDegrees() {
        return mDegrees;
    }

    public void setDegrees(int degrees) {
        mDegrees = degrees;
    }

}
