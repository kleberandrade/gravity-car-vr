#include "GravityCar.h"

GravityCar::GravityCar(int leftBrakePin, int rightBrakePin, int steeringAnglePin, int leftMotorPin, int rightMotorPin, int fanSpeedPin) {
  pinMode(leftBrakePin, INPUT);
  pinMode(rightBrakePin, INPUT);
  pinMode(steeringAnglePin, INPUT);

  pinMode(leftMotorPin, OUTPUT);
  pinMode(rightMotorPin, OUTPUT);
  pinMode(fanSpeedPin, OUTPUT);

  mLeftBrakePin = leftBrakePin;
  mRightBrakePin = rightBrakePin;
  mSteeringAnglePin = steeringAnglePin;

  mLeftMotorPin = leftMotorPin;
  mRightMotorPin = rightMotorPin;
  mFanSpeedPin = fanSpeedPin;

  setRightMotor(0);
  setLeftMotor(0);
  setFanSpeed(0);

  incomingCommand = "";
}

void GravityCar::setLeftMotor(int leftMotor) {
  mLeftMotor = leftMotor;
  analogWrite(mLeftMotorPin, leftMotor);
}

void GravityCar::setRightMotor(int rightMotor) {
  mRightMotor = rightMotor;
  analogWrite(mRightMotorPin, rightMotor);
}

void GravityCar::setFanSpeed(int fanSpeed) {
  mFanSpeed = fanSpeed;
}

void GravityCar::calibrate(int steps) {
  int step;
  for (step = 0; step < steps; step++) {

  }
}

void GravityCar::writeSerialJson(void) {
  StaticJsonBuffer<JSON_BUFFER_SIZE> jsonBuffer;
  JsonObject& object = jsonBuffer.createObject();
  object[JSON_LEFT_BRAKE_TAG] = getLeftBrake();
  object[JSON_RIGHT_BRAKE_TAG] = getRightBrake();
  object[JSON_STEERING_ANGLE_TAG] = getSteeringAngle();
  object.printTo(Serial);
  Serial.print("\r\n");
  Serial.flush();
}

void GravityCar::readSerialJson(void) {
  
  while (Serial.available() > 0) {
    noInterrupts();

    char command = Serial.read();
    incomingCommand += command;

    if (command == '}') {

      DynamicJsonBuffer jsonBuffer;
      JsonObject& root = jsonBuffer.parseObject(incomingCommand);

      if (!root.success()) {
        incomingCommand = "";
        return;
      }
      
      setLeftMotor(root[JSON_LEFT_MOTOR_TAG]);
      setRightMotor(root[JSON_RIGHT_MOTOR_TAG]);
      setFanSpeed(root[JSON_FAN_SPEED_TAG]);

      incomingCommand = "";
    }
  }

  interrupts();
}

void GravityCar::zeroCrossInt(void) {
  int power = map(mFanSpeed, 0, 255, 30, 100);
  
  int powertime = (82 * (100 - power));
  if (powertime <= 820)
    digitalWrite(mFanSpeedPin, HIGH);
  else if (powertime >= 8000)
    digitalWrite(mFanSpeedPin, LOW);
  else if ((powertime > 820) && (powertime < 8000)){
    delayMicroseconds(powertime);
    digitalWrite(mFanSpeedPin, HIGH);
    delayMicroseconds(8);
    digitalWrite(mFanSpeedPin, LOW);
  }
}
