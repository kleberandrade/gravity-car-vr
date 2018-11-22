/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fatec.gravitycarvr.view;

import br.edu.fatec.gravitycar.chart.RealTimeLineChart;
import br.edu.fatec.gravitycar.communication.Arduino;
import br.edu.fatec.gravitycarvr.models.GravityCarPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PrincipalMonitorFrame extends javax.swing.JFrame implements ActionListener {

    private static final int SPEED_TIME = 10;
    
    private static final int MAX_ITEM_COUNTS = 100;

    private Arduino mArduino;

    private RealTimeLineChart mLeftBrakeChart;
    private RealTimeLineChart mRightBrakeChart;
    private RealTimeLineChart mSteeringAngleChart;

    private Timer mTimer;

    public PrincipalMonitorFrame() {
        initComponents();
        initialize();
    }

    private void initialize() {
        mArduino = new Arduino("COM3", 9600);
        mLeftBrakeChart = new RealTimeLineChart("Left Brake", "Time", "Values", mLeftBrakeLineChartPanel);
        mRightBrakeChart = new RealTimeLineChart("Right Brake", "Time", "Values", mRightBrakeLineChartPanel);
        mSteeringAngleChart = new RealTimeLineChart("Steering Angle", "Time", "Values", mSteeringAngleLineChartPanel);

        mTimer = new Timer(SPEED_TIME, this);
        mTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            while (!mArduino.isEmpty()) {
                GravityCarPackage gravityCar = mArduino.remove();
                mLeftBrakeChart.addSeries(gravityCar.getmMillis() / 1000.0, gravityCar.getmLeftBrake(), MAX_ITEM_COUNTS);
                mRightBrakeChart.addSeries(gravityCar.getmMillis() / 1000.0, gravityCar.getmRightBrake(), MAX_ITEM_COUNTS);
                mSteeringAngleChart.addSeries(gravityCar.getmMillis() / 1000.0, gravityCar.getmSteeringAngle(), MAX_ITEM_COUNTS);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mLeftBrakePanel = new javax.swing.JPanel();
        mLeftBrakeLineChartPanel = new javax.swing.JPanel();
        mLeftBrakeStatisticsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        mRightBrakePanel = new javax.swing.JPanel();
        mRightBrakeLineChartPanel = new javax.swing.JPanel();
        mRightBrakeStatisticsPanel = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        mSteeringAnglePanel = new javax.swing.JPanel();
        mSteeringAngleLineChartPanel = new javax.swing.JPanel();
        mSteeringAngleStatisticsPanel = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        javax.swing.GroupLayout mLeftBrakeLineChartPanelLayout = new javax.swing.GroupLayout(mLeftBrakeLineChartPanel);
        mLeftBrakeLineChartPanel.setLayout(mLeftBrakeLineChartPanelLayout);
        mLeftBrakeLineChartPanelLayout.setHorizontalGroup(
            mLeftBrakeLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        mLeftBrakeLineChartPanelLayout.setVerticalGroup(
            mLeftBrakeLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Minimum ");

        jLabel2.setText("Average");

        jLabel3.setText("Maximum");

        javax.swing.GroupLayout mLeftBrakeStatisticsPanelLayout = new javax.swing.GroupLayout(mLeftBrakeStatisticsPanel);
        mLeftBrakeStatisticsPanel.setLayout(mLeftBrakeStatisticsPanelLayout);
        mLeftBrakeStatisticsPanelLayout.setHorizontalGroup(
            mLeftBrakeStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mLeftBrakeStatisticsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mLeftBrakeStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addGroup(mLeftBrakeStatisticsPanelLayout.createSequentialGroup()
                        .addGroup(mLeftBrakeStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 149, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mLeftBrakeStatisticsPanelLayout.setVerticalGroup(
            mLeftBrakeStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mLeftBrakeStatisticsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mLeftBrakePanelLayout = new javax.swing.GroupLayout(mLeftBrakePanel);
        mLeftBrakePanel.setLayout(mLeftBrakePanelLayout);
        mLeftBrakePanelLayout.setHorizontalGroup(
            mLeftBrakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mLeftBrakePanelLayout.createSequentialGroup()
                .addComponent(mLeftBrakeLineChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mLeftBrakeStatisticsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mLeftBrakePanelLayout.setVerticalGroup(
            mLeftBrakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mLeftBrakeStatisticsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mLeftBrakeLineChartPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(mLeftBrakePanel);

        javax.swing.GroupLayout mRightBrakeLineChartPanelLayout = new javax.swing.GroupLayout(mRightBrakeLineChartPanel);
        mRightBrakeLineChartPanel.setLayout(mRightBrakeLineChartPanelLayout);
        mRightBrakeLineChartPanelLayout.setHorizontalGroup(
            mRightBrakeLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        mRightBrakeLineChartPanelLayout.setVerticalGroup(
            mRightBrakeLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        jLabel13.setText("Maximum");

        jLabel14.setText("Average");

        jLabel15.setText("Minimum ");

        javax.swing.GroupLayout mRightBrakeStatisticsPanelLayout = new javax.swing.GroupLayout(mRightBrakeStatisticsPanel);
        mRightBrakeStatisticsPanel.setLayout(mRightBrakeStatisticsPanelLayout);
        mRightBrakeStatisticsPanelLayout.setHorizontalGroup(
            mRightBrakeStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mRightBrakeStatisticsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mRightBrakeStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField15)
                    .addComponent(jTextField14)
                    .addComponent(jTextField13)
                    .addGroup(mRightBrakeStatisticsPanelLayout.createSequentialGroup()
                        .addGroup(mRightBrakeStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(0, 149, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mRightBrakeStatisticsPanelLayout.setVerticalGroup(
            mRightBrakeStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mRightBrakeStatisticsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mRightBrakePanelLayout = new javax.swing.GroupLayout(mRightBrakePanel);
        mRightBrakePanel.setLayout(mRightBrakePanelLayout);
        mRightBrakePanelLayout.setHorizontalGroup(
            mRightBrakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mRightBrakePanelLayout.createSequentialGroup()
                .addComponent(mRightBrakeLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mRightBrakeStatisticsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mRightBrakePanelLayout.setVerticalGroup(
            mRightBrakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mRightBrakeLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mRightBrakeStatisticsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(mRightBrakePanel);

        javax.swing.GroupLayout mSteeringAngleLineChartPanelLayout = new javax.swing.GroupLayout(mSteeringAngleLineChartPanel);
        mSteeringAngleLineChartPanel.setLayout(mSteeringAngleLineChartPanelLayout);
        mSteeringAngleLineChartPanelLayout.setHorizontalGroup(
            mSteeringAngleLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        mSteeringAngleLineChartPanelLayout.setVerticalGroup(
            mSteeringAngleLineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        jLabel10.setText("Maximum");

        jLabel11.setText("Average");

        jLabel12.setText("Minimum ");

        javax.swing.GroupLayout mSteeringAngleStatisticsPanelLayout = new javax.swing.GroupLayout(mSteeringAngleStatisticsPanel);
        mSteeringAngleStatisticsPanel.setLayout(mSteeringAngleStatisticsPanelLayout);
        mSteeringAngleStatisticsPanelLayout.setHorizontalGroup(
            mSteeringAngleStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSteeringAngleStatisticsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mSteeringAngleStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField12)
                    .addComponent(jTextField11)
                    .addComponent(jTextField10)
                    .addGroup(mSteeringAngleStatisticsPanelLayout.createSequentialGroup()
                        .addGroup(mSteeringAngleStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(0, 149, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mSteeringAngleStatisticsPanelLayout.setVerticalGroup(
            mSteeringAngleStatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSteeringAngleStatisticsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mSteeringAnglePanelLayout = new javax.swing.GroupLayout(mSteeringAnglePanel);
        mSteeringAnglePanel.setLayout(mSteeringAnglePanelLayout);
        mSteeringAnglePanelLayout.setHorizontalGroup(
            mSteeringAnglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mSteeringAnglePanelLayout.createSequentialGroup()
                .addComponent(mSteeringAngleLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mSteeringAngleStatisticsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mSteeringAnglePanelLayout.setVerticalGroup(
            mSteeringAnglePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mSteeringAngleLineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mSteeringAngleStatisticsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(mSteeringAnglePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PrincipalMonitorFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalMonitorFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalMonitorFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalMonitorFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalMonitorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel mLeftBrakeLineChartPanel;
    private javax.swing.JPanel mLeftBrakePanel;
    private javax.swing.JPanel mLeftBrakeStatisticsPanel;
    private javax.swing.JPanel mRightBrakeLineChartPanel;
    private javax.swing.JPanel mRightBrakePanel;
    private javax.swing.JPanel mRightBrakeStatisticsPanel;
    private javax.swing.JPanel mSteeringAngleLineChartPanel;
    private javax.swing.JPanel mSteeringAnglePanel;
    private javax.swing.JPanel mSteeringAngleStatisticsPanel;
    // End of variables declaration//GEN-END:variables
}
