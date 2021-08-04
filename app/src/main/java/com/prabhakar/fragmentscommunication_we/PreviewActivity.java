package com.prabhakar.fragmentscommunication_we;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {
    private TextView studentName, studentAge, studentGrade, studentPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        setData();
    }
    private void initViews() {
        studentName = findViewById(R.id.tvStudentName);
        studentAge = findViewById(R.id.tvStudentAge);
        studentGrade = findViewById(R.id.tvStudentGrade);
        studentPercentage = findViewById(R.id.tvStudentPercentage);
    }
    private void setData(){
        if (getIntent()!=null){
            Model model= (Model) getIntent().getSerializableExtra("model");
            studentName.setText(model.getName());
            studentAge.setText(model.getAge()+"");
            studentGrade.setText(model.getGrade());
            studentPercentage.setText(model.getPercentage());
        }
    }
}