package com.example.ninefourone.nutritionmaster.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.Element;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization.CustomizationActivity;
import com.orhanobut.logger.Logger;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/9/24.
 */

public class CustomizationHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.customization_item_image)
    ImageView customizationItemImage;
    @BindView(R.id.food_name)
    TextView foodName;
    @BindView(R.id.food_quantity)
    TextView foodQuantity;
    @BindView(R.id.arch)
    ImageView arch;
    @BindView(R.id.food_energy)
    TextView foodEnergy;

    public CustomizationHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(FoodMenu foodMenu) {
        Glide.with(itemView.getContext()).load(foodMenu.getImage_url()).into(customizationItemImage);
        foodName.setText(foodMenu.getName());
        try {
            Element element = NutritionMaster.element.calculateData(NutritionMaster.user);
            double calorieQuantity = element.getCalorie() - NutritionMaster.user.getEaten_elements().getCalorie();
            double quantity = calorieQuantity / foodMenu.getCalorie();
            Random random = new Random((int) foodMenu.getElements().getCalorie());
            if (quantity > 200) {
                quantity = 150 + random.nextInt(50);
            } else if (quantity < 50) {
                quantity = 50 + random.nextInt(50);
            }
//            Logger.d(foodMenu.getCalorie());
            int energy = (int) (foodMenu.getElements().getCalorie() * quantity / 100);
            energy = checkEnergy(energy);
            foodEnergy.setText(energy + "千卡");
            foodQuantity.setText((int) quantity + "克");

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }

    private int checkEnergy(int energy) {
        if (energy < 30) {
            return checkEnergy(energy * 2);
        } else if (energy > 250) {
            return checkEnergy(energy - 50);
        } else {
            return energy;
        }
    }
}
