package com.example.ninefourone.nutritionmaster.modules.addinformation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.utils.ConstantUtils;
import com.example.ninefourone.nutritionmaster.utils.MessageUtils;
import com.github.czy1121.view.TurnCardListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.card_list)
    TurnCardListView cardList;
    @BindView(R.id.bottom_content)
    RelativeLayout bottomContent;
    @BindView(R.id.back_button)
    ImageView backButton;
    @BindView(R.id.result_layout)
    CardView resultLayout;


    //    private int[] colors = {0xff3F51B5, 0xff673AB7, 0xff006064, 0xffC51162, 0xffFFEB3B, 0xff795548, 0xff9E9E9E};
    private int[] colors = {0xffdef6f9, 0xffd6eeec, 0xffB2EBF2, 0xffB2DFDB, 0xff8ed0ca, 0xff80CBC4, 0xff4DB6AC, 0xff3c948b};
    private Button[] firstButtons = new Button[ConstantUtils.questionList.length];
    private Button[] secondButtons = new Button[ConstantUtils.questionList.length];
    private Button[] thirdButtons = new Button[ConstantUtils.questionList.length];
    private TextView[] titleViews = new TextView[ConstantUtils.questionList.length];

    private Button[][] buttonList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        buttonList = new Button[][]{
                firstButtons,
                secondButtons,
                thirdButtons
        };
        initAddView();
    }

    private void initAddView() {
        BaseAdapter adapter = new BaseAdapter() {


            @Override
            public int getCount() {
                return colors.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(final int position, View child, ViewGroup parent) {

                child = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_item, parent, false);
                child.findViewById(R.id.image).setBackgroundColor(colors[position]);
                titleViews[position] = child.findViewById(R.id.title_view);
                titleViews[position].setText(ConstantUtils.questionList[position]);

                firstButtons[position] = child.findViewById(R.id.choose_first);
                firstButtons[position].setBackgroundColor(colors[position] + 30);


                secondButtons[position] = child.findViewById(R.id.choose_second);
                secondButtons[position].setBackgroundColor(colors[position] + 30);


                thirdButtons[position] = child.findViewById(R.id.choose_third);
                thirdButtons[position].setBackgroundColor(colors[position] + 30);


                if (position != ConstantUtils.questionList.length - 1) {
                    firstButtons[position].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            firstButtons[position].setBackgroundColor(colors[position] - 60);
                            secondButtons[position].setBackgroundColor(colors[position] + 30);
                            thirdButtons[position].setBackgroundColor(colors[position] + 30);
                            cardList.turnTo(position + 1);
                        }
                    });
                } else {
                    firstButtons[position].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            resultLayout.setVisibility(View.VISIBLE);
                        }
                    });
                }
                secondButtons[position].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        firstButtons[position].setBackgroundColor(colors[position] + 30);
                        thirdButtons[position].setBackgroundColor(colors[position] + 30);
                        secondButtons[position].setBackgroundColor(colors[position] - 60);
                        cardList.turnTo(position + 1);
                    }
                });
                thirdButtons[position].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        firstButtons[position].setBackgroundColor(colors[position] + 30);
                        secondButtons[position].setBackgroundColor(colors[position] + 30);
                        thirdButtons[position].setBackgroundColor(colors[position] - 60);
                        cardList.turnTo(position + 1);
                    }
                });

                for (int i = 0; i < ConstantUtils.answerList[position].length; i++) {
                    buttonList[i][position].setText(ConstantUtils.answerList[position][i]);
                    buttonList[i][position].setVisibility(View.VISIBLE);
                }
                return child;
            }

        };

        cardList.setAdapter(adapter);
        cardList.setOnTurnListener(new TurnCardListView.OnTurnListener() {
            @Override
            public void onTurned(int position) {
                bottomContent.setBackgroundColor(colors[position] - 60);
            }
        });


    }

    @OnClick(R.id.back_button)
    public void onViewClicked() {
        finish();
    }
}
