package com.prabhakar.fragmentscommunication_we;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentPerformanceDetailsFragment extends Fragment {
    private EditText studentGarde, studentPercentage;
    private Button previewButton;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_performance_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        previewButton = view.findViewById(R.id.btn_preview);
        studentGarde = view.findViewById(R.id.grade);
        studentPercentage = view.findViewById(R.id.percentage);
        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = studentGarde.getText().toString();
                String percentage = studentPercentage.getText().toString();
                Model model = new Model(getArguments().getString("name"), getArguments().getInt("age"), grade, percentage);
                Intent intent= new Intent(getContext(),PreviewActivity.class);
                intent.putExtra("model",model);
                startActivity(intent);
            }
        });
    }
}