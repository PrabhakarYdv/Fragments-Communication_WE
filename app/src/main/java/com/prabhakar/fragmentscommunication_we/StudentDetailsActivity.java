package com.prabhakar.fragmentscommunication_we;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class StudentDetailsActivity extends AppCompatActivity implements CommunicationListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPersonalDetailsFragment studentPersonalDetailsFragment = new StudentPersonalDetailsFragment();
        fragmentTransaction.add(R.id.custom_fragment, studentPersonalDetailsFragment, "studentPersonalDetailsFragment").commit();
    }

    @Override
    public void LaunchPerformanceFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment detailsFragment = new StudentPerformanceDetailsFragment();
        detailsFragment.setArguments(bundle);
        transaction.replace(R.id.custom_fragment, detailsFragment, "personalDetailFragment").addToBackStack("detailsFragment").commit();
    }
}