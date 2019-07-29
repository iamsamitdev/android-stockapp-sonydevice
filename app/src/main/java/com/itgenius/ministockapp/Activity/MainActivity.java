package com.itgenius.ministockapp.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itgenius.ministockapp.R;
import com.itgenius.ministockapp.fragment.nav.AccountFragment;
import com.itgenius.ministockapp.fragment.nav.HomeFragment;
import com.itgenius.ministockapp.fragment.nav.NotificationFragment;
import com.itgenius.ministockapp.fragment.nav.ReportFragment;


public class MainActivity extends AppCompatActivity {

    // Toolbar
    Toolbar toolbar;
    BottomNavigationView navigationView;

    // Fragment
    final Fragment homeFragment = new HomeFragment();
    final Fragment reportFragment = new ReportFragment();
    final Fragment notificationFragment = new NotificationFragment();
    final Fragment accountFragment = new AccountFragment();

    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_title);

        // BottomNavigationView
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.main_container, homeFragment, "1").commit();
        fm.beginTransaction().add(R.id.main_container, reportFragment, "2").hide(reportFragment).commit();
        fm.beginTransaction().add(R.id.main_container, notificationFragment, "3").hide(notificationFragment).commit();
        fm.beginTransaction().add(R.id.main_container, accountFragment, "4").hide(accountFragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.navhome:
                    fm.beginTransaction().hide(active).show(homeFragment).commit();
                    active = homeFragment;
                    getSupportActionBar().setTitle(R.string.app_title);
                    return true;

                case R.id.navreport:
                    fm.beginTransaction().hide(active).show(reportFragment).commit();
                    active = reportFragment;
                    getSupportActionBar().setTitle(R.string.nav_report);
                    return true;

                case R.id.navnotification:
                    fm.beginTransaction().hide(active).show(notificationFragment).commit();
                    active = notificationFragment;
                    getSupportActionBar().setTitle(R.string.nav_notification);
                    return true;

                case R.id.navaccount:
                    fm.beginTransaction().hide(active).show(accountFragment).commit();
                    active = accountFragment;
                    getSupportActionBar().setTitle(R.string.nav_account);
                    return true;

            }

            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.menuSetting:
                Toast.makeText(getApplicationContext(), "Setting Click", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuProfile:
                Toast.makeText(getApplicationContext(), "Profile Click", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuLogout:
                Toast.makeText(getApplicationContext(), "Logout Click", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
