package com.prabhakar.fragmentscommunication_we;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class StudentPersonalDetailsFragment extends Fragment {
    private EditText studentName, studentAge;
    private Button nextButton;
    private CommunicationListener communicationListener;
    private FragmentManager fragmentManager;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_personal_details, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.communicationListener = (CommunicationListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        nextButton = view.findViewById(R.id.btn_next);
        studentName = view.findViewById(R.id.name);
        studentAge = view.findViewById(R.id.age);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emptyFormHandler()) {
                    String name = studentName.getText().toString();
                    int age = Integer.parseInt(studentAge.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putInt("age", age);
                    if (communicationListener != null) {
                        communicationListener.LaunchPerformanceFragment(bundle);
                    }
                }
            }
        });
    }

    private boolean emptyFormHandler() {
//        if (studentName.getText().equals("")  && studentAge.getText().equals("")){
        if (!studentName.getText().toString().isEmpty() && !studentAge.getText().toString().isEmpty()) {
            return true;
        } else {
            new AlertDialog.Builder(getContext()).setTitle("Error").setMessage("Please Enter both Details")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
            return false;
        }
    }
}