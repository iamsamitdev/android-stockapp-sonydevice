package com.itgenius.ministockapp.fragment.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.itgenius.ministockapp.R;
import com.itgenius.ministockapp.adapter.SliderAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstockFragment extends Fragment {

    ViewPager viewPager;
    TabLayout indicator;

    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5};
    private ArrayList<Integer> ImgArray = new ArrayList<>();


    public InstockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_instock, container, false);


        for (int i = 0; i < img.length; i++) {

            ImgArray.add(img[i]);
            viewPager = rootView.findViewById(R.id.viewPagerStock);
            indicator = rootView.findViewById(R.id.indicator);

            viewPager.setAdapter(new SliderAdapter(getActivity(), ImgArray));
            indicator.setupWithViewPager(viewPager, true);

            // Run Slide Auto
            final Handler handler = new Handler();
            final Runnable Update = new Runnable() {
                @Override
                public void run() {
                    if (currentPage == img.length) {
                        currentPage = 0;
                    } else {
                        viewPager.setCurrentItem(currentPage++, true);
                    }

                }
            };

            //Auto start
            Timer swipeTimer = new Timer();
            swipeTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(Update);
                }
            }, 2500, 2500);


        }

        return rootView;
    }


}
