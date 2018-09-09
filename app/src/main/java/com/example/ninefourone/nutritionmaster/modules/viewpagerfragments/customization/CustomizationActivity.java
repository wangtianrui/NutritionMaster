package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomizationActivity extends AppCompatActivity {

    @BindView(R.id.index_text)
    TextView indexText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization);
        ButterKnife.bind(this);
        String text = getIntent().getStringExtra("SEND_CODE");
        indexText.setText(text);
    }
}
