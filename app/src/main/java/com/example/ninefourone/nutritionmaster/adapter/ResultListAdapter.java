package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.ClassifyResult;

import java.util.ArrayList;

import travel.ithaka.android.horizontalpickerlib.PickerLayoutManager;

/**
 * Created by ScorpioMiku on 2018/10/5.
 */

public class ResultListAdapter extends RecyclerView.Adapter<ResultListHolder> {
    private ArrayList<ClassifyResult> mList;
    private Context context;
    private PickerLayoutManager pickerLayoutManager;

    public ResultListAdapter(ArrayList<ClassifyResult> list, Context context) {
        super();
        mList = list;
        this.context = context;
    }

    @Override
    public ResultListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dish_result_item, parent, false);
        pickerLayoutManager = new PickerLayoutManager(context, PickerLayoutManager.HORIZONTAL, false);
        return new ResultListHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultListHolder holder, int position) {
        holder.bindView(mList.get(position), pickerLayoutManager);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
