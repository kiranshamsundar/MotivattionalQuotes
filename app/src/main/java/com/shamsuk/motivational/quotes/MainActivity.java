package com.shamsuk.motivational.quotes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.shamsuk.motivational.quotes.data.QuoteData;
import com.shamsuk.motivational.quotes.data.QuoteListAsyncResponse;
import com.shamsuk.motivational.quotes.data.QuoteViewPagerAdpater;
import com.shamsuk.motivational.quotes.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private QuoteViewPagerAdpater quoteViewPagerAdpater;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteViewPagerAdpater = new QuoteViewPagerAdpater(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdpater);


    }


    private List<Fragment> getFragments() {
        final List<Fragment> fragmentList = new ArrayList<>();
        new QuoteData().getQuotes(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                             quotes.get(i).getQuote(),
                             quotes.get(i).getAuthor()
                    );
                    fragmentList.add(quoteFragment);
                }
                quoteViewPagerAdpater.notifyDataSetChanged();/// very important!!

            }
        });




        return fragmentList;
    }
}
