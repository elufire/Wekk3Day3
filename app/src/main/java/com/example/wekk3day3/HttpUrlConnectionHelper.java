package com.example.wekk3day3;

import android.util.Log;

import com.example.wekk3day3.user.UserResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.wekk3day3.Constants.BASE_URL;

public class HttpUrlConnectionHelper {

        public static  void makeAPICallWithHttpConn(){
            HttpURLConnection httpURLConnection = null;
            URL apiUrl;
            String jsonResponse = "";

            try {
                apiUrl = new URL(BASE_URL);
                httpURLConnection = (HttpURLConnection)apiUrl.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int currentReadChar = inputStreamReader.read();
                while(currentReadChar != -1){
                    char currentChar = (char)currentReadChar;
                    currentReadChar = inputStreamReader.read();
                    jsonResponse = jsonResponse + currentChar;
                }
                System.out.println(jsonResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(httpURLConnection != null){
                    Log.d("TAG", "WE ARE GETTING TO THE URL DISCONNECT");
                    httpURLConnection.disconnect();
                    Gson gson = new Gson();
                    UserResponse userResponse = gson.fromJson(jsonResponse, UserResponse.class);
                    EventBus.getDefault().post(new UserEvent(userResponse));
                }
            }
        }
}
