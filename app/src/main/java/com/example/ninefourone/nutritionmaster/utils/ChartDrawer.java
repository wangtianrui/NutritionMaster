package com.example.ninefourone.nutritionmaster.utils;

import android.content.Context;

import com.example.ninefourone.nutritionmaster.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/8/30.
 */

public class ChartDrawer {

    /**
     * 创建一条折线
     * @param index
     * @param datas
     * @param linename
     * @return
     */
    public LineData initSingleLineChart(String[] index, float[] datas, String linename) {
        if (index.length != datas.length) {
            MessageUtils.MakeToast("index长度与datas长度不符");
            return null;
        } else {
            ArrayList<String> xValues = new ArrayList<>();
            for (int i = 0; i < datas.length; i++) {
                xValues.add(index[i] + "");
            }
            ArrayList<Entry> yValues = new ArrayList<>();
            for (int i = 0; i < datas.length; i++) {
                yValues.add(new Entry(datas[i], i));
            }
            LineDataSet dataSet = new LineDataSet(yValues, linename);
            dataSet.setLineWidth(1.75f);
            dataSet.setColor(R.color.colorPrimary);

            ArrayList<ILineDataSet> dataSetArrayList = new ArrayList<>();
            dataSetArrayList.add(dataSet);

            LineData lineData = new LineData(dataSetArrayList);
            return lineData;
        }
    }
}
