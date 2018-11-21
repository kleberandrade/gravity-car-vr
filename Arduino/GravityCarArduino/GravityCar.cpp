#include "GravityCar.h"

GravityCar::GravityCar(int leftBrakePin, int rightBrakePin, int steeringAnglePin) {
  pinMode(leftBrakePin, INPUT);
  pinMode(rightBrakePin, INPUT);
  pinMode(steeringAnglePin, INPUT);

  mLeftBrakePin = leftBrakePin;
  mRightBrakePin = rightBrakePin;
  mSteeringAnglePin = steeringAnglePin;
}

void GravityCar::calibrate(int steps){
  int step;
  for (step = 0; step < steps; step++){
    
  }
}

void GravityCar::writeSerialJson(void){
  StaticJsonBuffer<JSON_BUFFER_SIZE> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root[JSON_LEFT_BRAKE_TAG] = getLeftBrake();
  root[JSON_RIGHT_BRAKE_TAG] = getRightBrake();
  root[JSON_STEERING_ANGLE_TAG] = getSteeringAngle();
  root.printTo(Serial);
  Serial.println();
}

void GravityCar::readSerialJson(void){
  
}
