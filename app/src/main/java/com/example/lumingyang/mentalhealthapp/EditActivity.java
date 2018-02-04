package com.example.lumingyang.mentalhealthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Button;
import android.view.View;



public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final LatLng latlng = (LatLng) getIntent().getParcelableExtra("location");

        final EditText title = (EditText) findViewById(R.id.title);
        final EditText number = (EditText) findViewById(R.id.number);
//            final EditText time = (EditText) findViewById(R.id.time);

        //final EditText description = (EditText) findViewById(R.id.);
        Button boton = (Button) findViewById(R.id.save);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                MarkerOptions marker = new MarkerOptions().position(latlng);
                if (title.getText() != null &&  number.getText() != null) {
                    marker.title(title.getText().toString()).snippet("Contact: " + number.getText() );
                }
//                    if (title.getText() != null && time.getText() != null && number.getText() != null) {
//                        marker.title(title.getText().toString()).snippet("Time: " + time.getText()
//                                + " Contact: " + number.getText() );
//                    }
                Intent resultIntent = new Intent();
                resultIntent.putExtra("marker", marker);
                setResult(AppCompatActivity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}

