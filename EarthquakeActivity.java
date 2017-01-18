
package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<List<earthquakelist>> {
    private earthquakeadapter madapter;
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private static final String USGS_REQUEST_URL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson";
    public static final int Loader_id=1;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        // Get a reference to the LoaderManager, in order to interact with loaders.
        mEmptyStateTextView=(TextView)findViewById(R.id.empty_list);
        ConnectivityManager connMgr = (ConnectivityManager)
                   getSystemService(Context.CONNECTIVITY_SERVICE);
                // Get details on the currently active default data network
              NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            // If there is a network connection, fetch data
           if (networkInfo != null && networkInfo.isConnected()) {
              // Get a reference to the LoaderManager, in order to interact with loaders.
                  LoaderManager loaderManager = getLoaderManager();
                // Initialize the loader. Pass in the int ID constant defined above and pass in null for
             // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
         // because this activity implements the LoaderCallbacks interface).
                    loaderManager.initLoader(Loader_id, null, this);
               } else {
                // Otherwise, display error
               // First, hide loading indicator so error message will be visible
                View loadingIndicator = findViewById(R.id.loading_indicator);
              loadingIndicator.setVisibility(View.GONE);
          // Update empty state with no connection error message
                mEmptyStateTextView.setText("No Internet Connection");
           }

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).

      // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setEmptyView(mEmptyStateTextView);
        // Create a new {@link ArrayAdapter} of earthquakes
       madapter=new earthquakeadapter(this,R.layout.earth_list,new ArrayList<earthquakelist>());


        // Set the adapter on the {@link ListView}
        // so the list cprivate static final String SAMPLE_JSON_RESPONSE = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

        earthquakeListView.setAdapter(madapter);
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                earthquakelist currentEarthquake = madapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getMurl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

    }

    @Override
    public android.content.Loader<List<earthquakelist>> onCreateLoader(int id, Bundle args) {
        return new earthquakeloader(this,USGS_REQUEST_URL);

    }

    @Override
    public void onLoadFinished(android.content.Loader<List<earthquakelist>> loader, List<earthquakelist> data) {
// Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(":) NO EARTHQUAKE FOUND :)");


        madapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data!= null && !data.isEmpty()) {
            madapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<earthquakelist>> loader) {
        madapter.clear();
    }

}
