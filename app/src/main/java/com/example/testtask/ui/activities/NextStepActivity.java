package com.example.testtask.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.testtask.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class NextStepActivity extends BaseActivity {
    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, NextStepActivity.class));
    }

    @BindView(R.id.text_congratulations)
    TextView mCongratulationText;

    @BindString(R.string.text_clicked_congratulate_btn)
    String mTapBtnText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_step);
    }

    @OnClick(R.id.button_congratulation)
    void clickBtn() {
        mCongratulationText.setText(mTapBtnText);
    }
}
