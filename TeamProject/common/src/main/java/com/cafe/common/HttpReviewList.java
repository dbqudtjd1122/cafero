package com.cafe.common;

import com.cafe.common.Http.HttpRequest;
import com.cafe.common.Model.ModelCafeReview;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;


public class HttpReviewList {

    public List<ModelCafeReview> reviewlist(Integer cafeno) {
        String weburl = "http://192.168.0.52:8080/review/getReviewList";

        HttpRequest request = null;
        JSONArray response = null;
        List<ModelCafeReview> list = null;

        int httpCode = 0;
        try {

            request = new HttpRequest(weburl).addHeader("charset", "utf-8");
            request.addParameter("cafeno", String.valueOf(cafeno));

            httpCode = request.post();

            if (httpCode == HttpURLConnection.HTTP_OK) { // HttpURLConnection.HTTP_OK == 200
                try {
                    response = request.getJSONArrayResponse(); // 서버값이 리턴된다
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
            }
            // JSONArray를 List<ModelReview> 객체로 변환
            String jsonInString = response.toString();
            list = new Gson().fromJson(jsonInString, new TypeToken<List<ModelCafeReview>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
        return list;
    }
}
