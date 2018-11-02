package com.example.ninefourone.nutritionmaster.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.Illness;
import com.example.ninefourone.nutritionmaster.utils.ConstantUtils;
import com.orhanobut.logger.Logger;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/10/6.
 */

public class IllnessHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text)
    TextView text;

    private IllAdapter adapter;

    public IllnessHolder(View itemView, IllAdapter adapter) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.adapter = adapter;
    }

    public void bindView(final String illness, final int position) {
        text.setText(illness);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext())
                        .setTitle("删除").setMessage("确定删除该项？");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.deleteItem(position);
                        if (ConstantUtils.getFlavour().contains(illness)) {
                            NutritionMaster.flavourCount -= (ConstantUtils.getFlavour().indexOf(illness) + 1);
//                            Logger.d(NutritionMaster.flavourCount);
                        }
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }
}
