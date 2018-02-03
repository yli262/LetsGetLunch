package com.example.lumingyang.mentalhealthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleList extends AppCompatActivity {

    ListView lv;
    String[] strings = {"1", "2", "3", "4", "5", "6"};
    ArrayAdapter adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        lv = (ListView) findViewById(R.id.listView);

        adaptor = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strings);

        lv.setAdapter(adaptor);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SimpleList.this, "" + strings[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
