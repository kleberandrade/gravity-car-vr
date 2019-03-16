#include "GravityCar.h"

#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#define PIN_LEFT_BRAKE      A0
#define PIN_RIGHT_BRAKE     A1
#define PIN_STEERING_ANGLE  A2

#define PIN_RIGHT_MOTOR     9
#define PIN_LEFT_MOTOR      10
#define PIN_FAN_SPEED       11  

#define SERIAL_BAUD_RATE    9600
#define INTERVAL            20

#define OLED_WIDTH          128
#define OLED_HEIGHT         32
#define OLED_ADDR           0x3C
#define OLED_RESET          4

long previousMillis = 0;

Adafruit_SSD1306  display(OLED_WIDTH, OLED_HEIGHT, &Wire, OLED_RESET);

GravityCar car(PIN_LEFT_BRAKE, PIN_RIGHT_BRAKE, PIN_STEERING_ANGLE, PIN_LEFT_MOTOR, PIN_RIGHT_MOTOR, PIN_FAN_SPEED);

void setup() {
  oled_setup();

  Serial.begin(SERIAL_BAUD_RATE);
  while (!Serial) continue;
}

void oled_setup() {
  display.begin(SSD1306_SWITCHCAPVCC, OLED_ADDR);
  display.display();
}

void oled_debug() {
  display.clearDisplay();
  display.setTextSize(1);
  display.setTextColor(WHITE);
  display.setCursor(0, 0);

  display.println("Sending [LB|RB|SA]");
  display.print(car.getLeftBrake());
  display.print("|");
  display.print(car.getRightBrake());
  display.print("|");
  display.print(car.getSteeringAngle());
  display.println();
  display.println("Reading [LM|RM|FS]");
  display.print(car.getLeftMotor());
  display.print("|");
  display.print(car.getRightMotor());
  display.print("|");
  display.println(car.getFanSpeed());

  display.display();
}

void loop() {
  unsigned long currentMillis = millis();
  if (currentMillis - previousMillis > INTERVAL) {
    previousMillis = currentMillis;
    car.writeSerialJson();
    car.readSerialJson();

    oled_debug();
  }
}
