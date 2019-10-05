package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt_name,edt_infomation;
    Button btn_reset,btn_save,btn_call_activity2;
    ListTitleBook lstbook=new ListTitleBook();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name=findViewById(R.id.edt_name);
        edt_infomation=findViewById(R.id.edt_info);
        btn_reset=findViewById(R.id.btn_reset);
        btn_save=findViewById(R.id.btn_save);
        btn_call_activity2=findViewById(R.id.btn_call_activity2);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_infomation.setText("");
                edt_name.setText("");
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edt_name.getText().toString();
                String info=edt_infomation.getText().toString();
                lstbook.getTittles().add(title);
                try {
                    FileOutputStream fout=openFileOutput(title,MODE_PRIVATE);
                    fout.write(info.getBytes());
                    fout.close();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error cannt write file", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_call_activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("data",lstbook);
                startActivity(intent);
            }
        });
    }
}
