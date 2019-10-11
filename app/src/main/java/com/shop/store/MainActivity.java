package com.shop.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.shop.store.utils.Density;
import com.shop.store.view.login.cart.CartFragment;
import com.shop.store.view.login.group.GroupFragment;
import com.shop.store.view.login.home.HomeFragment;
import com.shop.store.view.login.mine.MineFragment;
import com.shop.store.view.login.subject.SubjectFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrame;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.frame,homeFragment).commit();
                    return true;
                case R.id.navigation_subject:
                    transaction.replace(R.id.frame,subjectFragment).commit();
                    return true;
                case R.id.navigation_group:
                    transaction.replace(R.id.frame,groupFragment).commit();
                    return true;
                case R.id.navigation_cart:
                    transaction.replace(R.id.frame,cartFragment).commit();
                    return true;
                case R.id.navigation_mine:
                    transaction.replace(R.id.frame,mineFragment).commit();
                    return true;
            }
            return false;
        }
    };
    private HomeFragment homeFragment;
    private SubjectFragment subjectFragment;
    private GroupFragment groupFragment;
    private CartFragment cartFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Density.setDensity(this);
//        Density.setDefault(this);
        setContentView(R.layout.activity_main);



        mFrame = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        homeFragment = new HomeFragment();
        subjectFragment = new SubjectFragment();
        groupFragment = new GroupFragment();
        cartFragment = new CartFragment();
        mineFragment = new MineFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,homeFragment).commit();

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        if (id==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,cartFragment).commit();
        }
    }

}
