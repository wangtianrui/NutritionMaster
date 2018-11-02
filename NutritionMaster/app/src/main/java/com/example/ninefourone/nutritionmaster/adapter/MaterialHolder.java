package com.example.ninefourone.nutritionmaster.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.FoodMaterial;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/9/9.
 */

public class MaterialHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.weight_number)
    TextView weightNumber;
    @BindView(R.id.name)
    TextView name;

    public MaterialHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(FoodMenu.CookQuantityBean cookQuantityBean) {
        name.setText(cookQuantityBean.getMaterial());
        String weight = cookQuantityBean.getQuantity();
        weightNumber.setText(weight);
    }
}
