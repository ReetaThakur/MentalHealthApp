package com.application.mentalhealth.justforPractice;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.application.mentalhealth.fragments.MyHabitsFragment;
import com.application.mentalhealth.fragments.TodayGoalsFragment;

public class PracticePager extends FragmentPagerAdapter {


    public PracticePager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TodayGoalsFragment();
            case 1: return new MyHabitsFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
