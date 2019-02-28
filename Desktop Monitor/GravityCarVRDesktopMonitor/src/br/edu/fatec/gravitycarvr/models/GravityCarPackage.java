package br.edu.fatec.gravitycarvr.models;

import java.io.Serializable;

public class GravityCarPackage implements Serializable {

    private final int mLeftBrake;
    private final int mRightBrake;
    private final int mSteeringAngle;
    private final long mMillis;

    private int mLeftVibrationMotor;
    private int mRightVibrationMotor;

    public GravityCarPackage(int mLeftBrake, int mRightBrake, int mSteeringAngle) {
        this.mLeftBrake = mLeftBrake;
        this.mRightBrake = mRightBrake;
        this.mSteeringAngle = mSteeringAngle;
        this.mMillis = System.currentTimeMillis();
    }

    public GravityCarPackage(int mLeftBrake, int mRightBrake, int mSteeringAngle, long mMillis, int mLeftVibrationMotor, int mRightVibrationMotor) {
        this.mLeftBrake = mLeftBrake;
        this.mRightBrake = mRightBrake;
        this.mSteeringAngle = mSteeringAngle;
        this.mMillis = mMillis;
        this.mLeftVibrationMotor = mLeftVibrationMotor;
        this.mRightVibrationMotor = mRightVibrationMotor;
    }

    public int getmLeftBrake() {
        return mLeftBrake;
    }

    public int getmRightBrake() {
        return mRightBrake;
    }

    public int getmSteeringAngle() {
        return mSteeringAngle;
    }

    public long getmMillis() {
        return mMillis;
    }

    @Override
    public String toString() {
        return "GravityCar{" + "mLeftBrake=" + mLeftBrake + ", mRightBrake=" + mRightBrake + ", mSteeringAngle=" + mSteeringAngle + ", mMillis=" + mMillis + '}';
    }

    public void setmLeftVibrationMotor(int mLeftVibrationMotor) {
        this.mLeftVibrationMotor = mLeftVibrationMotor;
    }

    public void setmRightVibrationMotor(int mRightVibrationMotor) {
        this.mRightVibrationMotor = mRightVibrationMotor;
    }
}
