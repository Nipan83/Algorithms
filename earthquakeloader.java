package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by abhicool on 10/14/2016.
 */

public class earthquakeloader extends AsyncTaskLoader<List<earthquakelist>> {
    private String mUrl;
    public earthquakeloader(Context context,String Url) {
        super(context);
        mUrl=Url;
    }

    @Override
    protected void onStartLoading() {
      forceLoad();
    }



    @Override
    public List<earthquakelist> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<earthquakelist> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }

}


