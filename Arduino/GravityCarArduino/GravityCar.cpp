#include "GravityCar.h"

GravityCar::GravityCar(int leftBrakePin, int rightBrakePin, int steeringAnglePin, int leftMotorPin, int rightMotorPin) {
  pinMode(leftBrakePin, INPUT);
  pinMode(rightBrakePin, INPUT);
  pinMode(steeringAnglePin, INPUT);

  pinMode(leftMotorPin, OUTPUT);
  pinMode(rightMotorPin, OUTPUT);
  

  mLeftBrakePin = leftBrakePin;
  mRightBrakePin = rightBrakePin;
  mSteeringAnglePin = steeringAnglePin;

  mLeftMotorPin = leftMotorPin;
  mRightMotorPin = rightMotorPin;
}

void GravityCar::calibrate(int steps){
  int step;
  for (step = 0; step < steps; step++){
    
  }
}

void GravityCar::writeSerialJson(void){
  StaticJsonBuffer<JSON_BUFFER_SIZE> jsonBuffer;
  JsonObject& object = jsonBuffer.createObject();
  object[JSON_LEFT_BRAKE_TAG] = getLeftBrake();
  object[JSON_RIGHT_BRAKE_TAG] = getRightBrake();
  object[JSON_STEERING_ANGLE_TAG] = getSteeringAngle();
  object.printTo(Serial);
  Serial.print("\r\n");
  Serial.flush();
}

void GravityCar::readSerialJson(void){
  
}
