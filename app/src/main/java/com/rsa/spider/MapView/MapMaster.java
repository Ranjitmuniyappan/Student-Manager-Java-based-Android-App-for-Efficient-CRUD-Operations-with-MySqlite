package com.rsa.spider.MapView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rsa.spider.Pojo.StudentPojo;
import com.rsa.spider.R;

import java.util.ArrayList;

public class MapMaster extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    ArrayList<StudentPojo> al = new ArrayList<StudentPojo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_master);

        al.add(new StudentPojo("Green Park",28.558899,77.202805));
        al.add(new StudentPojo("Nilgiris District",11.416667,76.683334));
        al.add(new StudentPojo("Nage Layout",20.673210,77.012810));
        al.add(new StudentPojo("Dahigaon Ne",19.511562,75.198494));
        al.add(new StudentPojo("Ambedkar Nagar",26.407057,82.397972));
        al.add(new StudentPojo("Jothi Nagar",10.638598,77.018883));
        al.add(new StudentPojo("Janak Nagar",29.957846,77.554115));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        for (StudentPojo o : al)
        {
            LatLng latLng = new LatLng(o.getLat(), o.getLng());  //this is lattitude and longttitude of Sathuvachari waterfalls
            map.addMarker(new MarkerOptions().position(latLng).title(o.getName()));
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }
}