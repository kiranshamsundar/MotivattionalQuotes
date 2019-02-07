package com.shamsuk.motivational.quotes.data;

import com.shamsuk.motivational.quotes.model.Quote;

import java.util.ArrayList;


public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
