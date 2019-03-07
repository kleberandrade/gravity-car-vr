/*
  GravityCar.h - Library for gravity car simulator.
*/

#ifndef __GRAVITY_CAR_H__
#define __GRAVITY_CAR_H__

#include <ArduinoJson.h>
#include "Arduino.h"

#define JSON_BUFFER_SIZE          64
#define JSON_LEFT_BRAKE_TAG       "leftbrake"
#define JSON_RIGHT_BRAKE_TAG      "rightbrake"
#define JSON_STEERING_ANGLE_TAG   "steeringangle"

#define JSON_LEFT_MOTOR_TAG       "leftmotor"
#define JSON_RIGHT_MOTOR_TAG      "rightmotor"

class GravityCar {
  public:
    GravityCar(int leftBrakePin, int rightBrakePin, int steeringAnglePin, int leftMotorPin, int rightMotorPin);

    void calibrate(int steps);

    void writeSerialJson(void);
    void readSerialJson(void);

    int getLeftBrake() const { return analogRead(mLeftBrakePin); }
    int getRightBrake() const { return analogRead(mRightBrakePin); }
    int getSteeringAngle() const { return analogRead(mSteeringAnglePin); }

    int getLeftMotor() const { return mLeftMotor; }
    int getRightMotor() const { return mRightMotor; }

    String getIncomingCommand() const { return incomingCommand; }

    void setLeftMotor(int leftMotor);
    void setRightMotor(int rightMotor);

  private:
    int mLeftBrakePin;
    int mRightBrakePin;
    int mSteeringAnglePin;

    int mLeftMotorPin;
    int mRightMotorPin;

    int mLeftBrakeOffset;
    int mRightBrakeOffset;
    int mSteeringAngleOffset;

    int mLeftMotor;
    int mRightMotor;

    String incomingCommand;
};

#endif  /* __GRAVITY_CAR_H__ */
