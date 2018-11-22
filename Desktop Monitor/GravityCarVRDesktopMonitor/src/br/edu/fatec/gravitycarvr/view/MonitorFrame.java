package br.edu.fatec.gravitycarvr.view;

import br.edu.fatec.gravitycar.chart.RealTimeLineChart;
import br.edu.fatec.gravitycar.communication.Arduino;
import br.edu.fatec.gravitycarvr.models.GravityCarPackage;
import com.fazecast.jSerialComm.SerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

public class MonitorFrame extends javax.swing.JFrame implements ActionListener {

    private static final int SPEED_TIME = 10;

    private static final int MAX_ITEM_COUNTS = 100;

    private static final int[] BAUD_RATES = new int[]{1200, 1800, 2400, 4800, 7200, 9600, 14400, 19200, 38400, 57600, 115200, 128000};

    private Arduino mArduino = new Arduino();

    private RealTimeLineChart mLeftBrakeChart;
    private RealTimeLineChart mRightBrakeChart;
    private RealTimeLineChart mSteeringAngleChart;

    private Timer mTimer;

    public MonitorFrame() {
        initComponents();
        initialize();
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initialize() {
        SerialPort[] portNames = SerialPort.getCommPorts();
        for (SerialPort portName : portNames) {
            mSerialPortComboBox.addItem(portName.getSystemPortName());
        }

        for (int baudRate : BAUD_RATES) {
            mBaudRateComboBox.addItem(String.valueOf(baudRate));
        }
        mBaudRateComboBox.setSelectedItem("9600");
        mDisconnectButton.setEnabled(false);
        
        mLeftBrakeChart = new RealTimeLineChart("Left Brake", "Time", "Values", mLeftBrakeLineChartPanel);
        mRightBrakeChart = new RealTimeLineChart("Right Brake", "Time", "Values", mRightBrakeLineChartPanel);
        mSteeringAngleChart = new RealTimeLineChart("Steering Angle", "Time", "Values", mSteeringAngleLineChartPanel);

        mTimer = new Timer(SPEED_TIME, this);
        mTimer.start();
    }
    
    public void updateChart(double x, double y, RealTimeLineChart chart, JTextField min, JTextField max, JTextField avg){
        chart.addSeries(x, y, MAX_ITEM_COUNTS);
        min.setText(String.format("%.2f", chart.getMinimum()));
        max.setText(String.format("%.2f", chart.getMaximum()));
        avg.setText(String.format("%.2f", chart.getAverage()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mSerialPortComboBox = new javax.swing.JComboBox<>();
        mConnectButton = new javax.swing.JButton();
        mDisconnectButton = new javax.swing.JButton();
        mReceiveLedPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mTransmitLedPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mBaudRateComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        mLeftBrakeLineChartPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        mMinLeftBrakeTextField = new javax.swing.JTextField();
        mAvgLeftBrakeTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mMaxLeftBrakeTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        mRightBrakeLineChartPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        mMinRightBrakeTextField = new javax.swing.JTextField();
        mAvgRightBrakeTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        mMaxRightBrakeTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        mSteeringAngleLineChartPanel = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        mMinSteeringAngleTextField = new javax.swing.JTextField();
        mAvgSteeringAngleTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        mMaxSteeringAngleTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gravity Car VR Telemetry Viewer");

        jPanel1.setBackground(new java.awt.Color(236, 240, 241));

        jPanel2.setBackground(new java.awt.Color(236, 240, 241));

        jPanel3.setBackground(new java.awt.Color(236, 240, 241));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 165, 166)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Port");

        mSerialPortComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        mConnectButton.setBackground(new java.awt.Color(46, 204, 113));
        mConnectButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mConnectButton.setText("CONNECT");
        mConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConnectButtonActionPerformed(evt);
            }
        });

        mDisconnectButton.setBackground(new java.awt.Color(231, 76, 60));
        mDisconnectButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mDisconnectButton.setText("DISCONNECT");
        mDisconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDisconnectButtonActionPerformed(evt);
            }
        });

        mReceiveLedPanel.setBackground(new java.awt.Color(192, 57, 43));

        jLabel2.setBackground(new java.awt.Color(236, 240, 241));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Rx");

        javax.swing.GroupLayout mReceiveLedPanelLayout = new javax.swing.GroupLayout(mReceiveLedPanel);
        mReceiveLedPanel.setLayout(mReceiveLedPanelLayout);
        mReceiveLedPanelLayout.setHorizontalGroup(
            mReceiveLedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );
        mReceiveLedPanelLayout.setVerticalGroup(
            mReceiveLedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        mTransmitLedPanel.setBackground(new java.awt.Color(192, 57, 43));

        jLabel3.setBackground(new java.awt.Color(236, 240, 241));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tx");

        javax.swing.GroupLayout mTransmitLedPanelLayout = new javax.swing.GroupLayout(mTransmitLedPanel);
        mTransmitLedPanel.setLayout(mTransmitLedPanelLayout);
        mTransmitLedPanelLayout.setHorizontalGroup(
            mTransmitLedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );
        mTransmitLedPanelLayout.setVerticalGroup(
            mTransmitLedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        mBaudRateComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Baud Rate");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mConnectButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mDisconnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mReceiveLedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mTransmitLedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(mSerialPortComboBox, 0, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mBaudRateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mSerialPortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mBaudRateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mDisconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mReceiveLedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mTransmitLedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(236, 240, 241));
        jPanel4.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        jPanel5.setBackground(new java.awt.Color(236, 240, 241));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 165, 166)));

        mLeftBrakeLineChartPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mLeftBrakeLineChartPanelLayout = new javax.swing.GroupLayout(mLeftBrakeLineChartPanel);
        mLeftBrakeLineChartPanel.setLayout(mLeftBrakeLineChartPanelLayout);
        mLeftBrakeLineChartPanelLayout.setHorizontalGroup(
            mLeftBrakeLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        mLeftBrakeLineChartPanelLayout.setVerticalGroup(
            mLeftBrakeLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(236, 240, 241));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 165, 166)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Minimum");

        mMinLeftBrakeTextField.setEditable(false);
        mMinLeftBrakeTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mMinLeftBrakeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        mAvgLeftBrakeTextField.setEditable(false);
        mAvgLeftBrakeTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mAvgLeftBrakeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Average");

        mMaxLeftBrakeTextField.setEditable(false);
        mMaxLeftBrakeTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mMaxLeftBrakeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Maximum");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mMinLeftBrakeTextField)
                    .addComponent(mAvgLeftBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(mMaxLeftBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mMinLeftBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mAvgLeftBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mMaxLeftBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mLeftBrakeLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mLeftBrakeLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.add(jPanel5);

        jPanel8.setBackground(new java.awt.Color(236, 240, 241));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 165, 166)));

        mRightBrakeLineChartPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mRightBrakeLineChartPanelLayout = new javax.swing.GroupLayout(mRightBrakeLineChartPanel);
        mRightBrakeLineChartPanel.setLayout(mRightBrakeLineChartPanelLayout);
        mRightBrakeLineChartPanelLayout.setHorizontalGroup(
            mRightBrakeLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        mRightBrakeLineChartPanelLayout.setVerticalGroup(
            mRightBrakeLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(236, 240, 241));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 165, 166)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Minimum");

        mMinRightBrakeTextField.setEditable(false);
        mMinRightBrakeTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mMinRightBrakeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        mAvgRightBrakeTextField.setEditable(false);
        mAvgRightBrakeTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mAvgRightBrakeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Average");

        mMaxRightBrakeTextField.setEditable(false);
        mMaxRightBrakeTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mMaxRightBrakeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Maximum");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mMinRightBrakeTextField)
                    .addComponent(mAvgRightBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(mMaxRightBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mMinRightBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mAvgRightBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mMaxRightBrakeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mRightBrakeLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mRightBrakeLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.add(jPanel8);

        jPanel11.setBackground(new java.awt.Color(236, 240, 241));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 165, 166)));

        mSteeringAngleLineChartPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mSteeringAngleLineChartPanelLayout = new javax.swing.GroupLayout(mSteeringAngleLineChartPanel);
        mSteeringAngleLineChartPanel.setLayout(mSteeringAngleLineChartPanelLayout);
        mSteeringAngleLineChartPanelLayout.setHorizontalGroup(
            mSteeringAngleLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        mSteeringAngleLineChartPanelLayout.setVerticalGroup(
            mSteeringAngleLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(236, 240, 241));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(149, 165, 166)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Minimum");

        mMinSteeringAngleTextField.setEditable(false);
        mMinSteeringAngleTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mMinSteeringAngleTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        mAvgSteeringAngleTextField.setEditable(false);
        mAvgSteeringAngleTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mAvgSteeringAngleTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Average");

        mMaxSteeringAngleTextField.setEditable(false);
        mMaxSteeringAngleTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mMaxSteeringAngleTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Maximum");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mMinSteeringAngleTextField)
                    .addComponent(mAvgSteeringAngleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(mMaxSteeringAngleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mMinSteeringAngleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mAvgSteeringAngleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mMaxSteeringAngleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mSteeringAngleLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mSteeringAngleLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.add(jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(930, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConnectButtonActionPerformed
        int index = mBaudRateComboBox.getSelectedIndex();
        String port = (String) mSerialPortComboBox.getSelectedItem();

        if (mArduino.connect(port, BAUD_RATES[index])) {
            mConnectButton.setEnabled(false);
            mDisconnectButton.setEnabled(true);
            mLeftBrakeChart.clear();
            mRightBrakeChart.clear();
            mSteeringAngleChart.clear();
        }
    }//GEN-LAST:event_mConnectButtonActionPerformed

    private void mDisconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDisconnectButtonActionPerformed
        mArduino.disconnect();
        mConnectButton.setEnabled(true);
        mDisconnectButton.setEnabled(false);
    }//GEN-LAST:event_mDisconnectButtonActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
         try {
            while (!mArduino.isEmpty()) {
                GravityCarPackage gravityCar = mArduino.remove();
                
                updateChart(gravityCar.getmMillis() / 1000.0, 
                        gravityCar.getmLeftBrake(), 
                        mLeftBrakeChart, 
                        mMinLeftBrakeTextField, 
                        mMaxLeftBrakeTextField, 
                        mAvgLeftBrakeTextField);
                
                updateChart(gravityCar.getmMillis() / 1000.0,
                        gravityCar.getmRightBrake(), 
                        mRightBrakeChart, 
                        mMinRightBrakeTextField, 
                        mMaxRightBrakeTextField, 
                        mAvgRightBrakeTextField);
                
                updateChart(gravityCar.getmMillis() / 1000.0,
                        gravityCar.getmSteeringAngle(), 
                        mSteeringAngleChart, 
                        mMinSteeringAngleTextField, 
                        mMaxSteeringAngleTextField,
                        mAvgSteeringAngleTextField);
                
                //mLeftBrakeChart.addSeries(gravityCar.getmMillis() / 1000.0, gravityCar.getmLeftBrake(), MAX_ITEM_COUNTS);
                //mRightBrakeChart.addSeries(gravityCar.getmMillis() / 1000.0, gravityCar.getmRightBrake(), MAX_ITEM_COUNTS);
                //mSteeringAngleChart.addSeries(gravityCar.getmMillis() / 1000.0, gravityCar.getmSteeringAngle(), MAX_ITEM_COUNTS); 
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MonitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonitorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField mAvgLeftBrakeTextField;
    private javax.swing.JTextField mAvgRightBrakeTextField;
    private javax.swing.JTextField mAvgSteeringAngleTextField;
    private javax.swing.JComboBox<String> mBaudRateComboBox;
    private javax.swing.JButton mConnectButton;
    private javax.swing.JButton mDisconnectButton;
    private javax.swing.JPanel mLeftBrakeLineChartPanel;
    private javax.swing.JTextField mMaxLeftBrakeTextField;
    private javax.swing.JTextField mMaxRightBrakeTextField;
    private javax.swing.JTextField mMaxSteeringAngleTextField;
    private javax.swing.JTextField mMinLeftBrakeTextField;
    private javax.swing.JTextField mMinRightBrakeTextField;
    private javax.swing.JTextField mMinSteeringAngleTextField;
    private javax.swing.JPanel mReceiveLedPanel;
    private javax.swing.JPanel mRightBrakeLineChartPanel;
    private javax.swing.JComboBox<String> mSerialPortComboBox;
    private javax.swing.JPanel mSteeringAngleLineChartPanel;
    private javax.swing.JPanel mTransmitLedPanel;
    // End of variables declaration//GEN-END:variables
}
