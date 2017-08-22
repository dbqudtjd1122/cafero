package com.cafe.common;


import com.cafe.common.Http.HttpRequest;
import com.cafe.common.Model.ModelCafeReview;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

public class HttpReviewInsert {

    public ModelCafeReview reviewinsert(Object cafeReview1) {
        String weburl = "http://192.168.0.52:8080/review/insertReview";

        HttpRequest request = null;
        JSONObject response = null;
        ModelCafeReview cafeReview = (ModelCafeReview) cafeReview1;

        int httpCode = 0;
        try {

            String data = new Gson().toJson(cafeReview);

            request = new HttpRequest(weburl).addHeader("charset", "utf-8")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json");
            httpCode = request.post(data);

            if (httpCode == HttpURLConnection.HTTP_OK) { // HttpURLConnection.HTTP_OK == 200
                try {
                    response = request.getJSONObjectResponse(); // 서버값이 리턴된다
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
        return null;
    }
}
