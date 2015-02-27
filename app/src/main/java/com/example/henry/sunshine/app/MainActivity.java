package com.example.henry.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private ArrayAdapter<String> forecast_adapter;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Obtain start date of the week
            Calendar calendar = Calendar.getInstance();
            int start_day = calendar.get(Calendar.DAY_OF_WEEK);

            //Populate the week with days.
            String[] week_temp =
                    { "Monday - Cloudy - 200",
                      "Tuesday - Cloudy - 100",
                      "Wednesday - Cloudy - 100",
                      "Thursday - Cloudy - 100",
                      "Friday - Cloudy - 100",
                      "Saturday - Cloudy - 100",
                      "Sunday - Cloudy - 100" };

            //
            forecast_adapter = new ArrayAdapter<String>(
                    // This gets the current context
                    getActivity(),
                    // ID of list item layout
                    R.layout.list_item_forecast,
                    // ID of the text view to populate
                    R.id.list_item_forecast_textview,
                    // forecast data
                    week_temp);

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(forecast_adapter);

            return rootView;
        }
    }
}
