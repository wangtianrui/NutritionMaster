package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.DailyCard;
import com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization.CustomizationActivity;
import com.example.ninefourone.nutritionmaster.utils.MessageUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/9/2.
 */

public class CardHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sign)
    TextView tvSign;

    private View itemView;
    private Intent i;

    public CardHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.itemView = itemView;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void bindView(int picId, DailyCard dailyCard, final Context context) {
        tvName.setText(dailyCard.getTitle());
        tvSign.setText(dailyCard.getDescription());
        Glide.with(context).load(picId).into(ivPhoto);
        i = new Intent(context, CustomizationActivity.class);
        i.putExtra("SEND_CODE", dailyCard.getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NutritionMaster.physique == null || NutritionMaster.occupation == null) {
                    MessageUtils.MakeToast("填写信息才能使用哦~");
                } else {
                    context.startActivity(i);
                }
            }
        });
    }


}
