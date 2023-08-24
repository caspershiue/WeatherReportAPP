package com.example.wheather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button button;
    String option;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinnerValue, android.R.layout.simple_list_item_1);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                option=parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button.setOnClickListener(v -> {
            switch (option) {
                case "嘉義縣":
                case "Chiayi County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E5%98%89%E7%BE%A9%E7%B8%A3";
                    break;
                case "新北市":
                case "New Taipei City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E6%96%B0%E5%8C%97%E5%B8%82";
                    break;
                case "嘉義市":
                case"Chiayi City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E5%98%89%E7%BE%A9%E5%B8%82";
                    break;
                case "新竹縣":
                case"Hsinchu County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E6%96%B0%E7%AB%B9%E7%B8%A3";
                    break;
                case "新竹市":
                case"Hsinchu City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E6%96%B0%E7%AB%B9%E5%B8%82";
                    break;
                case "台北市":
                case"Taipei City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E8%87%BA%E5%8C%97%E5%B8%82";
                    break;
                case "台南市":
                case"Tainan City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E8%87%BA%E5%8D%97%E5%B8%82";
                    break;
                case "宜蘭縣":
                case"Yilan County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E5%AE%9C%E8%98%AD%E7%B8%A3";
                    break;
                case "苗栗縣":
                case"Miaoli County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E8%8B%97%E6%A0%97%E7%B8%A3";
                    break;
                case "雲林縣":
                case"Yunlin County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E9%9B%B2%E6%9E%97%E7%B8%A3";
                    break;
                case "花蓮縣":
                case"Hualien County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E8%8A%B1%E8%93%AE%E7%B8%A3";
                    break;
                case "台中市":
                case"Taichung City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E8%87%BA%E4%B8%AD%E5%B8%82";
                    break;
                case "台東縣":
                case"Taitung County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E8%87%BA%E6%9D%B1%E7%B8%A3";
                    break;
                case "桃園市":
                case"Taoyuan City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E6%A1%83%E5%9C%92%E5%B8%82";
                    break;
                case "南投縣":
                case"Nantou County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E5%8D%97%E6%8A%95%E7%B8%A3";
                    break;
                case "高雄市":
                case"Kaohsiung City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E9%AB%98%E9%9B%84%E5%B8%82";
                    break;
                case "金門縣":
                case"Kinmen County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E9%87%91%E9%96%80%E7%B8%A3";
                    break;
                case "屏東縣":
                case"Pingtung County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E5%B1%8F%E6%9D%B1%E7%B8%A3";
                    break;
                case "基隆市":
                case"Keelung City":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E5%9F%BA%E9%9A%86%E5%B8%82";
                    break;
                case "澎湖縣":
                case"Penghu County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E6%BE%8E%E6%B9%96%E7%B8%A3";
                    break;
                case "彰化縣":
                case"Changhua County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E5%BD%B0%E5%8C%96%E7%B8%A3";
                    break;
                case "連江縣":
                case"Lienchiang County":
                    url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-09344F56-0996-464F-8A1F-AA68FEF68693&locationName=%E9%80%A3%E6%B1%9F%E7%B8%A3";
                    break;
            }
            Intent intent=new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("URL",url);
            startActivity(intent);
        });
    }
}