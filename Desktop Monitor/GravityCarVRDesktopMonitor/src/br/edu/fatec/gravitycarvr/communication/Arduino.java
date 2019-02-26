package br.edu.fatec.gravitycarvr.communication;

import br.edu.fatec.gravitycarvr.json.JSONObject;
import br.edu.fatec.gravitycarvr.models.GravityCarPackage;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class Arduino implements SerialPortDataListener {

    private static final int QUEUE_SIZE = 64;

    private static final String JSON_LEFT_BRAKE = "leftbrake";
    private static final String JSON_RIGHT_BRAKE = "rightbrake";
    private static final String JSON_STEERING_ANGLE = "steeringangle";

    private SerialPort mSerialPort = null;

    private volatile StringBuilder mBuffer = new StringBuilder();

    private BlockingQueue<GravityCarPackage> mQueue = new ArrayBlockingQueue<>(QUEUE_SIZE);

    public boolean connect(String port, int baudRate) {

        mSerialPort = SerialPort.getCommPort(port);
        mSerialPort.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 0, 0);
        mSerialPort.setComPortParameters(baudRate, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);

        if (mSerialPort.openPort()) {
            mSerialPort.addDataListener(this);
            return true;
        } else {
            disconnect();
            return false;
        }
    }

    public synchronized void disconnect() {
        if (mSerialPort != null) {
            mSerialPort.removeDataListener();
            mSerialPort.closePort();
        }
    }

    public synchronized boolean isEmpty() {
        return mQueue.isEmpty();
    }

    public GravityCarPackage remove() throws InterruptedException {
        return mQueue.take();
    }

    public synchronized GravityCarPackage fromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        int leftBrake = jsonObject.getInt(JSON_LEFT_BRAKE);
        int rightBrake = jsonObject.getInt(JSON_RIGHT_BRAKE);
        int steeringAngle = jsonObject.getInt(JSON_STEERING_ANGLE);

        return new GravityCarPackage(leftBrake, rightBrake, steeringAngle);
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {

        if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
            return;
        }

        byte[] newData = new byte[mSerialPort.bytesAvailable()];
        mSerialPort.readBytes(newData, newData.length);

        String part = new String(newData);
        mBuffer.append(part);

        checkCommandBuffer();
    }
    

    private void checkCommandBuffer() {
        String commands = mBuffer.toString();
        if (commands.contains("}") && commands.contains("{") && (commands.lastIndexOf("{") < commands.lastIndexOf("}"))) {

            int startIndex = commands.lastIndexOf("{");
            int endIndex = commands.lastIndexOf("}") + 1;

            String command = commands.substring(startIndex, endIndex);
            mBuffer.delete(startIndex, endIndex);

            GravityCarPackage gravityCar = fromJson(command);
            if (gravityCar != null) {
                mQueue.add(gravityCar);
            }
        }
    }
    
    public void sendVibrationMotor(SerialPortEvent event){
        if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
            return;
            
            
        }
        
        
    }
    
}
