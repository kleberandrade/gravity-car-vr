package br.edu.fatec.gravitycar.communication;

import br.edu.fatec.gravitycar.json.JSONObject;
import br.edu.fatec.gravitycarvr.models.GravityCarPackage;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TooManyListenersException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.parser.JSONParser;

public final class Arduino implements SerialPortEventListener {

    private static final int QUEUE_SIZE = 64;

    private static final String JSON_LEFT_BRAKE = "leftbrake";
    private static final String JSON_RIGHT_BRAKE = "rightbrake";
    private static final String JSON_STEERING_ANGLE = "steeringangle";

    private SerialPort mSerialPort = null;
    private BufferedReader mSerialIn = null;
    private final int mBaudRate;
    private final String mPort;

    private BlockingQueue<GravityCarPackage> mQueue = null;

    public Arduino(String port, int baudRate) {
        mPort = port;
        mBaudRate = baudRate;
        mQueue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        initialize();
    }

    public void initialize() {
        try {
            CommPortIdentifier portId = null;
            portId = CommPortIdentifier.getPortIdentifier(mPort);

            mSerialPort = (SerialPort) portId.open("Comunicação serial", this.mBaudRate);
            mSerialIn = new BufferedReader(new InputStreamReader(mSerialPort.getInputStream()));
            mSerialPort.setSerialPortParams(this.mBaudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            mSerialPort.addEventListener(this);
            mSerialPort.notifyOnDataAvailable(true);

        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | HeadlessException | IOException | TooManyListenersException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    public synchronized void close() {
        if (mSerialPort != null) {
            mSerialPort.removeEventListener();
            mSerialPort.close();
        }

        try {
            mSerialIn.close();
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    @Override
    public synchronized void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = mSerialIn.readLine();
                GravityCarPackage gravityCar = fromJson(inputLine);
                mQueue.add(gravityCar);
            } catch (IOException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public synchronized boolean isEmpty() {
        return mQueue.isEmpty();
    }

    public synchronized GravityCarPackage remove() throws InterruptedException {
        return mQueue.take();
    }

    public GravityCarPackage fromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        int leftBrake = jsonObject.getInt(JSON_LEFT_BRAKE);
        int rightBrake = jsonObject.getInt(JSON_RIGHT_BRAKE);
        int steeringAngle = jsonObject.getInt(JSON_STEERING_ANGLE);

        return new GravityCarPackage(leftBrake, rightBrake, steeringAngle);
    }
}
