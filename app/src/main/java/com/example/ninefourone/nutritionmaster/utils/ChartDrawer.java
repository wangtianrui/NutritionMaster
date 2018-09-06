package com.example.ninefourone.nutritionmaster.utils;

import android.content.Context;
import android.graphics.Color;

import com.example.ninefourone.nutritionmaster.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ScorpioMiku on 2018/8/30.
 */

public class ChartDrawer {

    /**
     * 创建一条折线
     *
     * @param index
     * @param datas
     * @param linename
     * @return
     */
    public static void initSingleLineChart(LineChart mLineChart, ArrayList<Entry> pointValues, String linename) {
//        if (index.length != datas.length) {
//            MessageUtils.MakeToast("index长度与datas长度不符");
//            Logger.d("长度不符");
//            return;
//        } else {
//            ArrayList<String> xValues = new ArrayList<>();
//            for (int i = 0; i < datas.length; i++) {
//                xValues.add(index[i] + "");
//            }
//            ArrayList<Entry> pointValues = new ArrayList<>();
//            for (int i = 0; i < datas.length; i++) {
//                pointValues.add(new Entry(datas[i], i));
//            }
//            LineDataSet dataSet = new LineDataSet(pointValues, linename);
//            dataSet.setLineWidth(1.75f);
//            dataSet.setColor(R.color.colorPrimary);
//
//            ArrayList<ILineDataSet> dataSetArrayList = new ArrayList<>();
//            dataSetArrayList.add(dataSet);
//
//            LineData lineData = new LineData(dataSetArrayList);

        //表格属性
//            lineChart.setDrawBorders(false);
//            lineChart.setDrawGridBackground(false); //表格颜色
//            lineChart.setGridBackgroundColor(Color.GRAY & 0x70FFFFFF); //表格的颜色，设置一个透明度
//            lineChart.setTouchEnabled(true); //可点击
//            lineChart.setDragEnabled(true);  //可拖拽
//            lineChart.setScaleEnabled(true);  //可缩放
//            lineChart.setPinchZoom(false);
//            lineChart.setBackgroundColor(Color.WHITE); //设置背景颜色
//
//            lineChart.setData(lineData);
//
//            Legend mLegend = lineChart.getLegend(); //设置标示，就是那个一组y的value的
//            mLegend.setForm(Legend.LegendForm.SQUARE); //样式
//            mLegend.setFormSize(6f); //字体
//            mLegend.setTextColor(Color.GRAY); //颜色
//            lineChart.setVisibleXRange(0, 4);   //x轴可显示的坐标范围
//            XAxis xAxis = lineChart.getXAxis();  //x轴的标示
//            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //x轴位置
//            xAxis.setTextColor(Color.GRAY);    //字体的颜色
//            xAxis.setTextSize(10f); //字体大小
//            xAxis.setGridColor(Color.GRAY);//网格线颜色
//            xAxis.setDrawGridLines(false); //不显示网格线
//            YAxis axisLeft = lineChart.getAxisLeft(); //y轴左边标示
//            YAxis axisRight = lineChart.getAxisRight(); //y轴右边标示
//            axisLeft.setTextColor(Color.GRAY); //字体颜色
//            axisLeft.setTextSize(10f); //字体大小
//            //axisLeft.setAxisMaxValue(800f); //最大值
//            axisLeft.setLabelCount(5, true); //显示格数
//            axisLeft.setGridColor(Color.GRAY); //网格线颜色
//
//            axisRight.setDrawAxisLine(false);
//            axisRight.setDrawGridLines(false);
//            axisRight.setDrawLabels(false);
//
//            //设置动画效果
//            lineChart.animateY(2000, Easing.EasingOption.Linear);
//            lineChart.animateX(2000, Easing.EasingOption.Linear);
//            lineChart.invalidate();
        mLineChart.setNoDataText("没有数据喔~~");
        //设置是否绘制chart边框的线
        mLineChart.setDrawBorders(true);
        //设置chart边框线颜色
        mLineChart.setBorderColor(Color.GRAY);
        //设置chart边框线宽度
        mLineChart.setBorderWidth(1f);
        //设置chart是否可以触摸
        mLineChart.setTouchEnabled(true);
        //设置是否可以拖拽
        mLineChart.setDragEnabled(true);
        //设置是否可以缩放 x和y，默认true
        mLineChart.setScaleEnabled(false);
        //设置是否可以通过双击屏幕放大图表。默认是true
        mLineChart.setDoubleTapToZoomEnabled(false);
        //设置chart动画
        mLineChart.animateXY(1000, 1000);

        //=========================设置图例=========================
        // 像"□ xxx"就是图例
        Legend legend = mLineChart.getLegend();
        legend.setEnabled(false);


        //=======================设置X轴显示效果==================
        XAxis xAxis = mLineChart.getXAxis();
        //是否启用X轴
        xAxis.setEnabled(true);
        //是否绘制X轴线
        xAxis.setDrawAxisLine(true);
        //设置X轴上每个竖线是否显示
        xAxis.setDrawGridLines(true);
        //设置是否绘制X轴上的对应值(标签)
        xAxis.setDrawLabels(true);
        //设置X轴显示位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置竖线为虚线样式
        // xAxis.enableGridDashedLine(10f, 10f, 0f);
        //设置x轴标签数
        xAxis.setLabelCount(8,false);
        xAxis.setTextSize(5);
        //图表第一个和最后一个label数据不超出左边和右边的Y轴
        // xAxis.setAvoidFirstLastClipping(true);
        xAxis.setDrawGridLines(false);//设置x轴上每个点对应的线

        //修改横轴
        //准备好每个点对应的x轴数值
        List<String> list = new ArrayList<>();
        for (int i = 0; i < pointValues.size(); i++) {
            list.add(String.valueOf(i+1).concat("号"));
        }
        xAxis.setValueFormatter(new IndexAxisValueFormatter(list));


        YAxis rightAxis = mLineChart.getAxisRight();
        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setEnabled(false);
        YAxis leftAxis = mLineChart.getAxisLeft();
        leftAxis.setEnabled(false);
        leftAxis.setDrawAxisLine(false);

        //点构成的某条线
        LineDataSet lineDataSet = new LineDataSet(pointValues, "体重");
        //设置该线的颜色
        lineDataSet.setColor(R.color.color_bar_background);
        //设置每个点的颜色
        lineDataSet.setCircleColor(0xff0171c9);
        //设置该线的宽度
        lineDataSet.setLineWidth(0f);

        //设置每个坐标点的圆大小
        //lineDataSet.setCircleRadius(1f);
        //设置是否画圆
        lineDataSet.setDrawCircles(false);
        // 设置平滑曲线模式
        //  lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //设置线一面部分是否填充颜色
        lineDataSet.setDrawFilled(true);
        //设置填充的颜色
        lineDataSet.setFillColor(0x20A0FF);
        //设置是否显示点的坐标值
        lineDataSet.setDrawValues(false);


        //隐藏x轴描述
        Description description = new Description();
        description.setEnabled(false);
        mLineChart.setDescription(description);
        mLineChart.setDrawBorders(false);
        //线的集合（可单条或多条线）
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        //把要画的所有线(线的集合)添加到LineData里
        LineData lineData = new LineData(dataSets);
        //把最终的数据setData
        mLineChart.setData(lineData);
        mLineChart.invalidate();

    }


}
