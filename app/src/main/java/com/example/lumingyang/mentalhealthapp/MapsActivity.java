package com.example.lumingyang.mentalhealthapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //private GoogleApiClient mGoogleApiClient;
    private static final int EDIT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng philly = new LatLng(39.952335, -75.163789);
//        mMap.addMarker(new MarkerOptions().position(philly).title("Open Lunch"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(philly));
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f ));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.953637, -75.163789)).title("White Dog - Brunch time!").snippet("User: 2153015828"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.953810, -75.197886)).title("Sweetgreen - expensive but delicious").snippet("User: 2153015828"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.954236, -75.201192)).title("Honeygrow - healthy salad").snippet("User: 2153015828"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.955606, -75.198616)).title("Koreana - yum yum!").snippet("User: 2153015828"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.955459, -75.198562)).title("Sitar - delicious Indian food").snippet("User: 2153015828"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.954236, -75.201192), 16.0f));
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(final LatLng latLng) {
                Intent edit = new Intent(MapsActivity.this, EditActivity.class);
                edit.putExtra("location", latLng);
                MapsActivity.this.startActivityForResult(edit, EDIT_REQUEST);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (EDIT_REQUEST) : {
                if (resultCode == FragmentActivity.RESULT_OK) {
                    MarkerOptions markerOptions = data.getParcelableExtra("marker");
                    mMap.addMarker(markerOptions);
                }
                break;
            }
        }
    }

    public void activity_simple_list(View view) {
        Button button = (Button) findViewById(R.id.History);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MapsActivity.this, SimpleList.class));
            }
        });
    }






}
