package com.example.bruce.snake_startercode;
import java.util.ArrayList;
import java.util.List;

public class SnakeGame {
  private int mSpriteDim, mBOARD_WIDTH, mBOARD_HEIGHT, mScore, mLevel, mCountdown, mMillisDelay, mXMax, mYMax;
  private int[] mAppleCoord;
  private List <SnakeSegment> mSnake;
  private boolean mGameOver;


  public SnakeGame(int beginningDirection, int beginningSpriteDim, int beginningX, int beginningY, int width, int height, int xMax, int yMax){
    mSpriteDim = beginningSpriteDim;
    mBOARD_WIDTH = width;
    mBOARD_HEIGHT = height;
    mXMax = xMax;
    mYMax = yMax;
    mScore = 0;
    mLevel = 1;
    mCountdown = 12;
    mMillisDelay = 400;
    mAppleCoord = new int[2];
    setAppleCoord();
    mSnake = new ArrayList<>();
    mSnake.add(new SnakeSegment(SnakeSegment.Body.HEAD, beginningDirection,beginningX,beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.Body.BODY, beginningDirection,beginningX-1,beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.Body.TAIL, beginningDirection,beginningX-2,beginningY));
    mGameOver = false;
  }

  protected void touched(float xTouched, float yTouched){

  }

  protected void eatApple(){

  }

  protected boolean play(){
    for(int segment = 0; segment < mSnake.size(); segment++){
      mSnake.get(segment).setXLoc(mSnake.get(segment).getXLoc()+1);

      if(mSnake.get(segment).getXLoc() > mXMax){
        mGameOver = true;
      }
    }

    return mGameOver;
  }

  private void setAppleCoord(){
    mAppleCoord[0] = (int)(mBOARD_WIDTH*Math.random());
    mAppleCoord[1] = (int)(mBOARD_HEIGHT*Math.random());
  }

  // getters and Setters

  protected int getSpriteDim(){
    return mSpriteDim;
  }

  protected int getBOARD_WIDTH(){
    return mBOARD_WIDTH;
  }

  protected int getBOARD_HEIGHT(){
    return mBOARD_HEIGHT;
  }

  protected int getScore(){
    return mScore;
  }

  protected int getLevel(){
    return mLevel;
  }

  protected int getCountdown(){
    return mCountdown;
  }
  protected int getMillisDelay() {
    return mMillisDelay;
  }

  protected boolean getGameOver(){
    return mGameOver;
  }

  protected List<SnakeSegment> getSnake(){
    return mSnake;
  }
  protected int[] getAppleCoord(){
    return mAppleCoord;
  }

}



