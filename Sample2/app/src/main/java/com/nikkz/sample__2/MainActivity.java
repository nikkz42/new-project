package com.nikkz.sample__2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String USGS_REQUEST_URL =
            "https://api.rootnet.in/covid19-in/unofficial/covid19india.org/statewise";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CovidAsyncTask task=new CovidAsyncTask();
        task.execute(USGS_REQUEST_URL);

        // Perform the HTTP request and process the response.


        // Update the information displayed to the user.

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.keralamenu,menu);
        return true;
    }

    /**
     * Update the UI with the given information.
     */
    private void updateUi(Event covid) {
        TextView confirmedTextView = (TextView) findViewById(R.id.confirmed);
        confirmedTextView.setText(covid.mConfirmed);

        TextView recoveredTextView = (TextView) findViewById(R.id.recovered);
        recoveredTextView.setText(covid.mRecovered);

        TextView deathTextView = (TextView) findViewById(R.id.deaths);
        deathTextView.setText(covid.mDeaths);

        TextView activeTextView = (TextView) findViewById(R.id.active);
        activeTextView.setText(covid.mActive);
    }

    private class  CovidAsyncTask extends AsyncTask<String,Void,Event>{

        @Override
        protected Event doInBackground(String... strings) {
            if (strings.length < 1 || strings[0] == null) {
                return null;
            }

            Event earthquake = Utils.fetchCovidData(USGS_REQUEST_URL);
            return earthquake;
        }

            protected void onPostExecute(Event earthquake){
                if (earthquake == null) {
                    return;
                }
            updateUi(earthquake);

            }
        }
    }

