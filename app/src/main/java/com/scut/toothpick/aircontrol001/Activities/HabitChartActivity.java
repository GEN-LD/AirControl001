package com.scut.toothpick.aircontrol001.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.scut.toothpick.aircontrol001.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HabitChartActivity extends AppCompatActivity {
    LineChart lineChart0;
    BarChart barChart0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_chart);
        //初始化linechart
        lineChart0 = getLineChart();
        lineChart0.invalidate();
        //初始化barchart
        barChart0 = getBarChart();
        barChart0.invalidate();

        Button changeChart = (Button)findViewById(R.id.changeChart);
        changeChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lineChart0.getVisibility() == View.VISIBLE) {
                    lineChart0.setVisibility(View.GONE);
                    barChart0.setVisibility(View.VISIBLE);
                } else {
                    lineChart0.setVisibility(View.VISIBLE);
                    barChart0.setVisibility(View.GONE);
                }
            }
        });
    }
    /*
    line chart setting 设置
     */
    private LineChart getLineChart(){
        LineChart lineChart = (LineChart)findViewById(R.id.lineChart);
        int[] mydata = {5,4,3,7,9,5,4,1};
        List<Entry> entries = new ArrayList<Entry>();
        for(int i=0;i<8;i++) {
            entries.add(new Entry(mydata[i],i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries,"测试图表");
        lineDataSet.setColor(Color.parseColor("#d04ff4"));
        lineDataSet.setLineWidth(2.5f);//设置线条宽度
        lineDataSet.setCircleSize(4.5f);//设置原点直径
        lineDataSet.setValueTextSize(10f);

        String[] xval = {"一月","二月","三月","四月","五月","六月","七月","八月"};
        LineData lineData = new LineData(xval,lineDataSet);
        lineChart.setData(lineData);

        //设置图表外观
        lineChart.setDrawBorders(false);
        lineChart.setScaleEnabled(false);   //是否可以缩放XY轴
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴数据位置

        YAxis yAxis0 = lineChart.getAxisLeft();
        YAxis yAxis1 = lineChart.getAxisRight();
        yAxis0.setDrawGridLines(false);//绘制网格线
        yAxis1.setEnabled(false);
        return lineChart;
    }
    /*
    barchart setting 设置
     */

    private BarChart getBarChart(){
        BarChart barChart = (BarChart)findViewById(R.id.barchart);
        int[] mydata = {5,4,3,7,9,5,4,1};
        List<BarEntry> entries = new ArrayList<BarEntry>();
        for(int i=0;i<8;i++) {
            entries.add(new BarEntry(mydata[i],i));
        }
        BarDataSet barDataSet = new BarDataSet(entries,"测试图表");
        barDataSet.setColor(Color.parseColor("#d04ff4"));
        String[] xval = {"一月","二月","三月","四月","五月","六月","七月","八月"};
        BarData barData = new BarData(xval,barDataSet);
        barChart.setData(barData);
        //设置图表外观
        barChart.setDrawBorders(false);
        barChart.setScaleEnabled(false);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        YAxis yAxis0 = barChart.getAxisLeft();
        YAxis yAxis1 = barChart.getAxisRight();
        yAxis0.setDrawAxisLine(false);
        yAxis1.setDrawGridLines(false);
        yAxis1.setDrawGridLines(false);
        return barChart;
    }

}
