package br.edu.fatec.gravitycarvr.models;

public class ControlPackage {

    private int mLeftVibrationMotor;
    private int mRightVibrationMotor;

    public ControlPackage() {
    }
    
    public ControlPackage(int mLeftVibrationMotor, int mRightVibrationMotor) {
        this.mLeftVibrationMotor = mLeftVibrationMotor;
        this.mRightVibrationMotor = mRightVibrationMotor;
    }

    public int getLeftVibrationMotor() {
        return mLeftVibrationMotor;
    }

    public void setLeftVibrationMotor(int mLeftVibrationMotor) {
        this.mLeftVibrationMotor = mLeftVibrationMotor;
    }

    public int getRightVibrationMotor() {
        return mRightVibrationMotor;
    }

    public void setRightVibrationMotor(int mRightVibrationMotor) {
        this.mRightVibrationMotor = mRightVibrationMotor;
    }

    @Override
    public String toString() {
        return "ControlPackage{" + "mLeftVibrationMotor=" + mLeftVibrationMotor + ", mRightVibrationMotor=" + mRightVibrationMotor + '}';
    }
}
