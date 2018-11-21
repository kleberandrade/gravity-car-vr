package br.edu.fatec.gravitycar.communication;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

public class Arduino {

    private OutputStream mSerialOut;
    private int mBaudRate;
    private String mPort;

    public Arduino() {
    }

    public static void listPorts() {
        java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier portIdentifier = portEnum.nextElement();
            System.out.println(portIdentifier.getName() + " - " + getPortTypeName(portIdentifier.getPortType()));
        }
    }

    public boolean isConnected() {
        return mSerialOut != null;
    }

    public void connect() {
        try {
            CommPortIdentifier portId = null;
            portId = CommPortIdentifier.getPortIdentifier(mPort);

            SerialPort port = (SerialPort) portId.open("Comunicação serial", this.mBaudRate);
            mSerialOut = port.getOutputStream();
            port.setSerialPortParams(this.mBaudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | HeadlessException | IOException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    public void close() {
        try {
            mSerialOut.close();
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar porta COM.", "Fechar porta COM", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
