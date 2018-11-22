package br.edu.fatec.gravitycar.chart;

import br.edu.fatec.gravitycarvr.utils.StatisticsTracker;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class RealTimeLineChart {

    private final XYSeries mSeries = new XYSeries("");
    
    private StatisticsTracker mStatisticsTracker = new StatisticsTracker();

    public RealTimeLineChart(final String title, final String xLabel, final String yLabel, JPanel panel) {

        XYDataset dataset = new XYSeriesCollection(mSeries);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);

        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate();
    }

    public void addSeries(double xValue, double yValue, int maxItemCounts) {
        mSeries.add(xValue, yValue);
        mStatisticsTracker.addNumber(yValue);
        
        if (mSeries.getItemCount() > maxItemCounts) {
            mSeries.delete(0, 1);
        }
    }
    
    public double getMinimum() {
        return mStatisticsTracker.getMinimum();
    }

    public double getMaximum() {
        return mStatisticsTracker.getMaximum();
    }

    public double getAverage() {
        return mStatisticsTracker.getAverage();
    }
    
    public void clear(){
        mSeries.clear();
        mStatisticsTracker.clear();
    }
}
