package com.personal.cardviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout dotsLayout;
    SliderAdapter adapter;
    ViewPager2 pager2;
    int list[];

    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dotsLayout = findViewById(R.id.dots_container);
        pager2 = findViewById(R.id.view_pager2);

        list = new int[5];
        list[0] = getResources().getColor(R.color.black);
        list[1] = getResources().getColor(R.color.purple_200);
        list[2] = getResources().getColor(R.color.purple_500);
        list[3] = getResources().getColor(R.color.purple_700);
        list[4] = getResources().getColor(R.color.white);

        adapter = new SliderAdapter(list);
        pager2.setAdapter(adapter);


        dots = new TextView[5];
        dotsIndicator();

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                selectedIndicator(position);
                super.onPageSelected(position);
            }
        });
    }

    private void selectedIndicator(int position) {

        for (int i=0;i<dots.length;i++) {

            if(i==position) {
                dots[i].setTextColor(list[position]);
            } else {
                dots[i].setTextColor(getResources().getColor(R.color.black));
            }

        }

    }

    private void dotsIndicator() {

        for (int i=0; i<dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            dotsLayout.addView(dots[i]);
        }

    }
}