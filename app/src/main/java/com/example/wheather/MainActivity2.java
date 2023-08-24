package com.example.wheather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

@SuppressWarnings("deprecation")
public class MainActivity2 extends AppCompatActivity {
    @SuppressLint("StaticFieldLeak")
    public static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Locale currentLocale = getResources().getConfiguration().locale;
        String languageCode = currentLocale.getLanguage();
        String countryCode = currentLocale.getCountry();
        Intent intent=getIntent();
        String url=intent.getStringExtra("URL");
        textView = findViewById(R.id.textView);
        Thread t1 = new otherThread(url,languageCode,countryCode);
        t1.start();
    }

    // 使用Handler處理從otherThread取得的訊息，並更新TextView
    @SuppressLint("HandlerLeak")
    public static Handler mHandler= new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            // 使用Bundle將資料從otherThread傳到MainActivity
            Bundle gotMsg = msg.getData();
            String weatherStr = gotMsg.getString("output");
            String languageCode= gotMsg.getString("language");
            String countryCode= gotMsg.getString("country");
            textView.setText(weatherStr);
            try {
                // 解析天氣資料JSON字串
                JSONObject weatherData = new JSONObject(weatherStr);
                JSONObject records = weatherData.getJSONObject("records");
                JSONArray location = records.getJSONArray("location");
                // 取得該位置的天氣資料
                JSONObject tempLocation = location.getJSONObject(0);
                String Location= tempLocation.getString("locationName");
                // 取得該位置的天氣元素資料，例如溫度、天氣描述、降雨機率等
                JSONArray weatherElements = tempLocation.getJSONArray("weatherElement");

                // 取得天氣描述
                JSONObject elementWx = weatherElements.getJSONObject(0);
                JSONArray timeWx = elementWx.getJSONArray("time");
                JSONObject firstTimeWx = timeWx.getJSONObject(0);
                String weatherDescription = firstTimeWx.getJSONObject("parameter").getString("parameterName");

                // 取得降雨機率
                JSONObject elementPoP=weatherElements.getJSONObject(1);
                JSONArray timePoP=elementPoP.getJSONArray("time");
                JSONObject firstTimePoP= timePoP.getJSONObject(0);
                String humidity=firstTimePoP.getJSONObject("parameter").getString("parameterName");

                // 取得最低溫度
                JSONObject elementMinT=weatherElements.getJSONObject(2);
                JSONArray timeMinT=elementMinT.getJSONArray("time");
                JSONObject firstTimeMinT= timeMinT.getJSONObject(0);
                String minT=firstTimeMinT.getJSONObject("parameter").getString("parameterName");

                // 取得最高溫度
                JSONObject elementMaxT=weatherElements.getJSONObject(4);
                JSONArray timeMaxT=elementMaxT.getJSONArray("time");
                JSONObject firstTimeMaxT= timeMaxT.getJSONObject(0);
                String maxT=firstTimeMaxT.getJSONObject("parameter").getString("parameterName");

                // 構造該位置的天氣資訊字串
                if ("zh".equals(languageCode) && "TW".equals(countryCode)){
                    String result ="十二小時天氣預報\n\n城市：" + Location + "\n最低溫度：" + minT + "°C" + "\n最高溫度：" + maxT + "°C" + "\n天氣描述：" + weatherDescription + "\n降雨機率：" + humidity + "%";
                    textView.setText(result);
                }
                else{
                    switch (Location){
                        case "宜蘭縣":
                            Location="Yilan County";
                            break;
                        case"花蓮縣":
                            Location="Hualien County";
                            break;
                        case"臺東縣":
                            Location="Taitung County";
                            break;
                        case"澎湖縣":
                            Location="Penghu County";
                            break;
                        case"金門縣":
                            Location="Kinmen County";
                            break;
                        case"連江縣":
                            Location="Lienchiang County";
                            break;
                        case"臺北市":
                            Location="Taipei City";
                            break;
                        case"新北市":
                            Location="New Taipei City";
                            break;
                        case"桃園市":
                            Location="Taoyuan City";
                            break;
                        case"臺中市":
                            Location="Taichung City";
                            break;
                        case"臺南市":
                            Location="Tainan City";
                            break;
                        case"高雄市":
                            Location="Kaohsiung City";
                            break;
                        case"基隆市":
                            Location="Keelung City";
                            break;
                        case"新竹縣":
                            Location="Hsinchu County";
                            break;
                        case"新竹市":
                            Location="Hsinchu City";
                            break;
                        case"苗栗縣":
                            Location="Miaoli County";
                            break;
                        case"彰化縣":
                            Location="Changhua County";
                            break;
                        case"南投縣":
                            Location="Nantou County";
                            break;
                        case"雲林縣":
                            Location="Yunlin County";
                            break;
                        case"嘉義縣":
                            Location="Chiayi County";
                            break;
                        case"嘉義市":
                            Location="Chiayi City";
                            break;
                        case"屏東縣":
                            Location="Pingtung County";
                            break;
                    }
                    switch (weatherDescription){
                        case"晴天":
                            weatherDescription="Clear";
                            break;
                        case"晴時多雲":
                            weatherDescription=" Mostly Clear";
                            break;
                        case"多雲時晴":
                            weatherDescription="Partly Clear";
                            break;
                        case"多雲":
                            weatherDescription="Partly Cloudy";
                            break;
                        case"多雲時陰":
                        case"陰時多雲":
                            weatherDescription="Mostly Cloudy";
                            break;
                        case"陰天":
                            weatherDescription="Cloudy";
                            break;
                        case"多雲陣雨 ":
                            weatherDescription="Partly Cloudy With Showers";
                            break;
                        case"多雲短暫雨":
                            weatherDescription="Partly Cloudy With Occasional Rain";
                            break;
                        case"多雲短暫陣雨":
                            weatherDescription="Partly Cloudy With Occasional Showers";
                            break;
                        case"午後短暫陣雨":
                            weatherDescription="Occasional Afternoon Showers";
                            break;
                        case"短暫陣雨":
                            weatherDescription="Occasional Showers";
                            break;
                        case"多雲時晴短暫陣雨":
                            weatherDescription="Partly Clear With Occasional Showers";
                            break;
                        case"多雲時晴短暫雨":
                            weatherDescription="Partly Clear With Occasional Rain";
                            break;
                        case"晴時多雲短暫陣雨":
                            weatherDescription="Mostly Clear With Occasional Showers";
                            break;
                        case"晴短暫陣雨":
                            weatherDescription="Clear With Occasional Showers";
                            break;
                        case"短暫雨":
                            weatherDescription="Occasional Rain";
                            break;
                        case"多雲時陰短暫雨":
                        case"陰時多雲短暫雨":
                            weatherDescription="Mostly Cloudy With Occasional Rain";
                            break;
                        case"多雲時陰短暫陣雨":
                        case"陰時多雲短暫陣雨":
                            weatherDescription="Mostly Cloudy With Occasional Showers";
                            break;
                        case"雨天":
                            weatherDescription="Rainy";
                            break;
                        case"多雲午後短暫雷陣雨":
                            weatherDescription="Partly Cloudy With Occasional Afternoon Thundershowers";
                            break;
                    }
                    String result ="Weather Report For Next Twelve Hours\n\nCity：" + Location + "\nMinimum Temperature：" + minT + "°C" + "\nMaximum Temperature：" + maxT + "°C" + "\nWeather Description：" + weatherDescription + "\nHumidity：" + humidity + "%";
                    textView.setText(result);
                }
                // 將該位置的天氣資訊顯示在TextView中
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}