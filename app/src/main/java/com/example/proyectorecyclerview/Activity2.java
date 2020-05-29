package com.example.proyectorecyclerview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    TextView mTitleView, mDescriptionView, mTeacherView, mDayView, mTimeView, mDateView;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        ActionBar actionBar=getSupportActionBar();
        mTitleView=findViewById(R.id.titleView);
        mDescriptionView=findViewById(R.id.descriptionView);
        mTeacherView=findViewById(R.id.teacherView);
        mDayView=findViewById(R.id.dayView);
        mTimeView=findViewById(R.id.timeView);
        mDateView=findViewById(R.id.dateView);
        mImageView=findViewById(R.id.imageView);

        Intent intent=getIntent();
        String mTitle=intent.getStringExtra("iTitle");
        String mDescription=intent.getStringExtra("iDescription");
        String mTeacher=intent.getStringExtra("iTeacher");
        String mDay=intent.getStringExtra("iDay");
        String mTime=intent.getStringExtra("iTime");
        String mDate=intent.getStringExtra("iDate");

        byte[] mBytes=getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        actionBar.setTitle(mTitle);
        mTitleView.setText(mTitle);
        mDescriptionView.setText(mDescription);
        mTeacherView.setText(mTeacher);
        mDayView.setText(mDay);
        mTimeView.setText(mTime);
        mDateView.setText(mDate);
        mImageView.setImageBitmap(bitmap);
    }
}
