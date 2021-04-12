package com.anant.tasker.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utility {

    public static String readFromAssets(Context mContext) {
        StringBuilder sb = new StringBuilder();
        //reading from assets
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("sample.json")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                sb.append(mLine);
                ///...
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return sb.toString();
    }
}
