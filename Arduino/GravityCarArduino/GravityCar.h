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

class GravityCar {
  public:
    GravityCar(int leftBrakePin, int rightBrakePin, int steeringAnglePin);

    void calibrate(int steps);

    void writeSerialJson(void);
    void readSerialJson(void);

    int getLeftBrake() const { return analogRead(mLeftBrakePin); }
    int getRightBrake() const { return analogRead(mRightBrakePin); }
    int getSteeringAngle() const { return analogRead(mSteeringAnglePin); }

  private:
    int mLeftBrakePin;
    int mRightBrakePin;
    int mSteeringAnglePin;

    int mLeftBrakeOffset;
    int mRightBrakeOffset;
    int mSteeringAngleOffset;
};

#endif  /* __GRAVITY_CAR_H__ */
