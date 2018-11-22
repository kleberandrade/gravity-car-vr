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
  JsonObject& object = jsonBuffer.createObject();
  object[JSON_LEFT_BRAKE_TAG] = getLeftBrake();
  object[JSON_RIGHT_BRAKE_TAG] = getRightBrake();
  object[JSON_STEERING_ANGLE_TAG] = getSteeringAngle();
  object.printTo(Serial);
  Serial.print("\r\n");
}

void GravityCar::readSerialJson(void){
  
}
