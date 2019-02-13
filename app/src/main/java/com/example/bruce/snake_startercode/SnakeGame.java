package com.example.bruce.snake_startercode;
import java.util.ArrayList;
import java.util.List;

public class SnakeGame {
  private int mSpriteDim, mBOARD_WIDTH, mBOARD_HEIGHT, mScore, mLevel, mCountdown, mMillisDelay, mXMax, mYMax;
  private int[] mAppleCoord;
  private List <SnakeSegment> mSnake;
  private List <PivotPoint> mPivotPoint;
  private boolean mGameOver;


  public SnakeGame(int beginningDirection, int beginningSpriteDim, int beginningX, int beginningY, int width, int height){
    mSpriteDim = beginningSpriteDim;
    mBOARD_WIDTH = width;
    mBOARD_HEIGHT = height;
    mXMax = mBOARD_WIDTH / beginningSpriteDim;
    mYMax = mBOARD_HEIGHT / beginningSpriteDim;
    mScore = 0;
    mLevel = 1;
    mCountdown = 12;
    mMillisDelay = 400*mLevel;
    mAppleCoord = new int[2];
    setAppleCoord();
    mSnake = new ArrayList<>();
    mPivotPoint = new ArrayList<>();
    mSnake.add(new SnakeSegment(SnakeSegment.Body.HEAD, beginningDirection,beginningX,beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.Body.BODY, beginningDirection,beginningX-1,beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.Body.TAIL, beginningDirection,beginningX-2,beginningY));
    mGameOver = false;
  }

  protected void touched(float xTouched, float yTouched){
    int headX = mSnake.get(0).getXLoc() * mSpriteDim;
    int headY = mSnake.get(0).getYLoc() * mSpriteDim;
    int currentDeg = mSnake.get(0).getDegrees();
    int newDeg = currentDeg;

    switch(currentDeg) {

      case 0:
        if (yTouched > headY)
          newDeg = 90;
        else if (yTouched < headY)
          newDeg = 270;
      break;

      case 180:
        if (yTouched > headY)
          newDeg = 90;
        else if (yTouched < headY)
          newDeg = 270;
      break;

      case 90:
        if (xTouched > headX)
          newDeg = 0;
        else if (xTouched < headX)
          newDeg = 180;
        break;

      case 270:
        if (xTouched > headX)
          newDeg = 0;
        else if (xTouched < headX)
          newDeg = 180;
        break;
    }

    mPivotPoint.add(new PivotPoint(mSnake.get(0).getXLoc(), mSnake.get(0).getYLoc(), newDeg));

  }

  private void growSnake(){
    mSnake.add((mSnake.size()-1), new SnakeSegment(SnakeSegment.Body.BODY, mSnake.get(mSnake.size()-1).getDegrees(),mSnake.get(mSnake.size()-1).getXLoc(),mSnake.get(mSnake.size()-1).getYLoc()));

    switch(mSnake.get(mSnake.size()-1).getDegrees()){
      case 0:
        mSnake.get(mSnake.size()-1).setXLoc(mSnake.get(mSnake.size()-1).getXLoc()-1);
        break;

      case 90:
        mSnake.get(mSnake.size()-1).setYLoc(mSnake.get(mSnake.size()-1).getYLoc()-1);
        break;

      case 180:
        mSnake.get(mSnake.size()-1).setXLoc(mSnake.get(mSnake.size()-1).getXLoc()+1);
        break;

      case 270:
        mSnake.get(mSnake.size()-1).setYLoc(mSnake.get(mSnake.size()-1).getYLoc()+1);
        break;
    }
  }

  protected void eatApple(){
    if((mSnake.get(0).getXLoc() == mAppleCoord[0] / mSpriteDim) && mSnake.get(0).getYLoc() == mAppleCoord[1] / mSpriteDim) {
        updateScore();
        growSnake();
        setAppleCoord();
    }
  }

  protected boolean play(){

    eatApple();

    for(int segment = 0; segment < mSnake.size(); segment++){

      for(int ppoint = 0; ppoint < mPivotPoint.size(); ppoint++) {
        if ((mSnake.get(segment).getXLoc() == mPivotPoint.get(ppoint).getXLoc()) && mSnake.get(segment).getYLoc() == mPivotPoint.get(ppoint).getYLoc()) {
          mSnake.get(segment).setDegrees(mPivotPoint.get(ppoint).getDegree());
          if (mSnake.get(segment).getBodyPart() == SnakeSegment.Body.TAIL) {
            mPivotPoint.remove(ppoint);
          }
        }
      }

        switch(mSnake.get(segment).getDegrees()) {
          case 0:
            mSnake.get(segment).setXLoc(mSnake.get(segment).getXLoc() + 1);
            break;

          case 90:
            mSnake.get(segment).setYLoc(mSnake.get(segment).getYLoc() + 1);
            break;

          case 180:
            mSnake.get(segment).setXLoc(mSnake.get(segment).getXLoc() - 1);
            break;

          case 270:
            mSnake.get(segment).setYLoc(mSnake.get(segment).getYLoc() - 1);
            break;
        }


      if((mSnake.get(segment).getXLoc() >= mXMax+1)
              || (mSnake.get(segment).getXLoc() <= -1)
              || (mSnake.get(segment).getYLoc() >= mYMax+1)
              || (mSnake.get(segment).getYLoc() <= 0-1)){
        mGameOver = true;
      }

      int collisionSeg = segment;
      if(!(collisionSeg == 0)) {
          if ((mSnake.get(0).getXLoc() == mSnake.get(segment).getXLoc()) && (mSnake.get(0).getYLoc() == mSnake.get(segment).getYLoc())) {
              mGameOver = true;
          }
      }
    }

    if(mCountdown <= 0){
        mLevel++;
        mCountdown = 12;
    }

    return mGameOver;
  }

  private void setAppleCoord(){
    mAppleCoord[0] = (int)((mBOARD_WIDTH-1)*Math.random()+1);
    mAppleCoord[1] = (int)((mBOARD_HEIGHT-1)*Math.random()+1);
  }

  private void updateScore(){
      mScore++;
      mCountdown--;
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