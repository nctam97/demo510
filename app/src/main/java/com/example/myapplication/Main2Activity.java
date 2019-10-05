package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ArrayAdapter<String>adapter;
    ListTitleBook lst_titlebook ;
    ListView lstvw_data;
    TextView tv_result;
    Button btn_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lstvw_data=findViewById(R.id.lstvw_ds);
        tv_result=findViewById(R.id.tv_result);
        btn_close=findViewById(R.id.btn_close);
        loadData();
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lstvw_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String title= lst_titlebook.getTittles().get(position);
               if(title!=null){
                   try {
                       FileInputStream fin=openFileInput(title);
                       int length=0;
                       String data="";
                       while ((length=fin.read())>0){
                           data+=Character.toString((char)length);
                       }
                       fin.close();
                       tv_result.setText(data);
                   }
                   catch (Exception e){
                       Toast.makeText(Main2Activity.this, "Error to read file", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
    }
    private void loadData(){
        Intent intent=getIntent();
        lst_titlebook=(ListTitleBook)intent.getSerializableExtra("data");
        adapter=new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1, lst_titlebook.getTittles());
        lstvw_data.setAdapter(adapter);
    }
}
