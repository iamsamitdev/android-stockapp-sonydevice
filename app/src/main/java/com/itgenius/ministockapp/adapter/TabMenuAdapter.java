package com.itgenius.ministockapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.itgenius.ministockapp.fragment.tab.InvoiceFragment;
import com.itgenius.ministockapp.fragment.tab.InstockFragment;
import com.itgenius.ministockapp.fragment.tab.OrderFragment;


public class TabMenuAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public TabMenuAdapter(@NonNull FragmentManager fm, int NumOfTabs) {
        super(fm, NumOfTabs);
        this.mNumOfTabs = NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new InstockFragment();
            case 1:
                return new OrderFragment();
            case 2:
                return new InvoiceFragment();
            default:
                return new InstockFragment();

        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
