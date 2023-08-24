package com.example.wheather;

import android.os.Bundle;
import android.os.Message;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class otherThread extends Thread{
    String url;
    String languageCode;
    String countryCode;
    public otherThread(String url, String languageCode, String countryCode) {
        this.url = url;
        this.languageCode=languageCode;
        this.countryCode=countryCode;
    }
    public void run() {
        try {

            //使用 URL 進行網路連線並取得輸入串流
            InputStream is = new URL(url).openStream();

            // 使用 BufferedReader 讀取網路串流中的資料，並以 UTF-8 編碼方式解碼
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            // 使用 StringBuilder 以 ASCII Code儲存從網路串流中讀取的資料
            StringBuilder sb = new StringBuilder();
            int cp;
            //將sb中的ASCII Code依序轉換為對應的char
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }

            // 將 StringBuilder 轉換成字串，即為取得的天氣資料 JSON 字串
            String weatherStr = sb.toString();

            // 建立一個 Bundle 來儲存天氣資料，使用 key "output" 存入天氣資料 JSON 字串
            Bundle carrier = new Bundle();
            carrier.putString("output", weatherStr);
            carrier.putString("language",languageCode);
            carrier.putString("country",countryCode);
            // 建立一個 Message 並設定其資料為上面建立的 Bundle
            Message msg = new Message();
            msg.setData(carrier);

            // 使用 MainActivity2 中的 mHandler 將 Message 傳遞給主執行緒，以供處理和更新 UI
            MainActivity2.mHandler.sendMessage(msg);
        } catch (Exception e) {
            // 若發生例外錯誤，在控制台上印出錯誤訊息
            e.printStackTrace();
        }
    }
}