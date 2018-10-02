package com.example.ninefourone.nutritionmaster.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.bean.MyUser;

/**
 * Created by ScorpioMiku on 2018/10/1.
 */

public abstract class BaseDialog extends AlertDialog.Builder {

    protected AlertDialog dialog;

    public BaseDialog(@NonNull Context context) {
        super(context);
    }

    protected void upUser(MyUser user) {
        NutritionMaster.user = user;
    }

    public void showDialog() {
        dialog.show();
    }

}
