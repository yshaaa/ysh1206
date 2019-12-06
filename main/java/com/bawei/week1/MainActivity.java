package com.bawei.week1;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.week1.fragment.Guanlifragment;
import com.bawei.week1.fragment.HomeFragment;
import com.bawei.week1.fragment.TWOfragment;
import com.bawei.week1.fragment.Threefragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private ArrayList<Fragment> list;
    private HomeFragment homeFragment;
    private TWOfragment twOfragment;
    private Threefragment threefragment;
    private Guanlifragment guanlifragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        homeFragment = new HomeFragment();
        twOfragment = new TWOfragment();
        threefragment = new Threefragment();
        guanlifragment = new Guanlifragment();
        list.add(homeFragment);
        list.add(twOfragment);
        list.add(threefragment);
        list.add(guanlifragment);

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.one:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.two:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.three:
                        viewpager.setCurrentItem(2);
                        break;
                    case R.id.four:
                        viewpager.setCurrentItem(3);
                        break;

                }
            }
        });

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                group.check(group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
