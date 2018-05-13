package com.scut.toothpick.aircontrol001.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.scut.toothpick.aircontrol001.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HabitChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_chart);

        LineChart lineChart = (LineChart)findViewById(R.id.lineChart);
        int[] mydata = {5,4,3,7,9,5,0,1};
        List<Entry> entries = new ArrayList<Entry>();
        for(int i=0;i<8;i++) {
            entries.add(new Entry(mydata[i],i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries,"测试图表");
        lineDataSet.setColor(1111111);
        String[] xval = {"一月","二月","三月","四月","五月","六月","七月","八月"};
        LineData lineData = new LineData(xval,lineDataSet);
        lineChart.setData(lineData);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setDrawGridLines(false);
        lineChart.invalidate();
    }


}
