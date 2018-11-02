package com.example.ninefourone.nutritionmaster.step;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.modules.MainActivity;
import com.orhanobut.logger.Logger;


public class StepStarter extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        NutritionMaster nutritionMaster = (NutritionMaster) context.getApplicationContext();
        if (!nutritionMaster.isForeground()) {
            Intent mainIntent = new Intent(context, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mainIntent);
        }else {
            Logger.d("已经在计步了");
        }
    }
}
