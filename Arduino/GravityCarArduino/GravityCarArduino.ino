#include "GravityCar.h"

#define PIN_LEFT_BRAKE      A0
#define PIN_RIGHT_BRAKE     A1
#define PIN_STEERING_ANGLE  A2

#define PIN_RIGHT_MOTOR     7
#define PIN_LEFT_MOTOR      6

#define SERIAL_BAUD_RATE    9600
#define INTERVAL            20

long previousMillis = 0;

GravityCar car(PIN_LEFT_BRAKE, PIN_RIGHT_BRAKE, PIN_STEERING_ANGLE, PIN_LEFT_MOTOR, PIN_RIGHT_MOTOR);

void setup() {
  Serial.begin(SERIAL_BAUD_RATE);
  while (!Serial) continue;
}

void loop() {
  unsigned long currentMillis = millis();
  if(currentMillis - previousMillis > INTERVAL) {
    previousMillis = currentMillis;  
    car.writeSerialJson();
    car.readSerialJson();
  }
}
