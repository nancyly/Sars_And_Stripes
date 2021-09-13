package net.androidbootcamp.sars_and_stripes;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import net.androidbootcamp.sars_and_stripes.databinding.ActivityLocationsBinding;

public class Locations extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityLocationsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLocationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng kroger = new LatLng(36.852299, -76.028050);
        mMap.addMarker(new MarkerOptions().position(kroger).title("Kroger Pharmacy"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kroger));

        LatLng harrisT = new LatLng(36.855811, -75.980977);
        mMap.addMarker(new MarkerOptions().position(harrisT).title("Harris Teeter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(harrisT));

        LatLng velocity = new LatLng(36.765166, -76.014245);
        mMap.addMarker(new MarkerOptions().position(velocity).title("Velocity Urgent Care "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(velocity));

        LatLng patient = new LatLng(36.785194, -76.000440);
        mMap.addMarker(new MarkerOptions().position(patient).title("Patient First "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(patient));

        LatLng cvs = new LatLng(36.851435, -76.021402);
        mMap.addMarker(new MarkerOptions().position(cvs).title("Patient First "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cvs));







    }
}