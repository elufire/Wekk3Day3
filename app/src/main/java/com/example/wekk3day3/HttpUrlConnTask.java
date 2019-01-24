package com.example.wekk3day3;

import android.os.AsyncTask;

public class HttpUrlConnTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... strings) {
        HttpUrlConnectionHelper.makeAPICallWithHttpConn();
        return null;
    }
}