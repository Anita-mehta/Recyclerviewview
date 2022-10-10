package com.bhanguz.amitdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.bhanguz.amitdesign.fragment.Newsfragment;
import com.bhanguz.amitdesign.fragment.Oilfragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView navView;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navGas:
                loadFragment(new Oilfragment());
                return true;

            case R.id.navNews:
                loadFragment(new Newsfragment());

                return true;
            case R.id.navInvest:

                return true;
            case R.id.navContact:

                return true;

        }
        return false;



    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.navView);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new Oilfragment());
    }
    private void loadFragment(Fragment fragment) {
//// load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, "frag 1");
        //  transaction.addToBackStack("frag 1");
        transaction.commit();
    }

}
