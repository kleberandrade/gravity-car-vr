package br.edu.fatec.gravitycarvr.utils;

public class StatisticsTracker {
    
    private int mCount;
    private double mTotal;
    private double mMinimum;
    private double mMximum;
    
    public void clear(){
        mCount = 0;
        mTotal = 0;
    }

    public void addNumber(double number) {
        mCount++;
        mTotal += number;
        adjustMinimumAndMaximum(number);
    }
   
    private void adjustMinimumAndMaximum(double number) {
        if (containsSingleNumber()) {
            mMinimum = number;
            mMximum = number;
        } else if (number < mMinimum) {
            mMinimum = number;
        } else if (number > mMximum) {
            mMximum = number;
        }
    }
    
    private boolean containsSingleNumber() {
        return mCount == 1;
    }

    public int getCount() {
        return mCount;
    }

    public double getTotal() {
        return mTotal;
    }

    public double getMinimum() {
        return mMinimum;
    }

    public double getMaximum() {
        return mMximum;
    }

    public double getAverage() {
        return mTotal / (double)mCount;
    }
}
