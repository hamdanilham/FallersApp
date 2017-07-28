package com.fallersapp.fallersapp.plan;

import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Double2;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;
import com.fallersapp.fallersapp.login.LoginActivity;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.text.Spanned;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hamda on 17/07/2017.
 */

public class PickLocation extends BaseActivity implements OnMapReadyCallback, PlaceSelectionListener{
    @BindView(R.id.place_attribution)
    TextView place_att;

    @BindView(R.id.place_details)
    TextView place_details;
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    MapView mapView;
    GoogleMap map;

    final double latitude = 0,longitude = 0;

    LatLng latlong;
    String name;
    List<Address> address;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_pick_location);
        ButterKnife.bind(this);
        setToolbar(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteFragment.setHint("Tujuan Anda");
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                Log.i("WTF", "Place: " + place.getName());
//                latlong = place.getLatLng();
//                Log.v("Latitude is", "" + queriedLocation.latitude);
//                Log.v("Longitude is", "" + queriedLocation.longitude);

//                latlong = Double.parseDouble(place.getLatLng().toString());
                Toast.makeText(PickLocation.this, place.getLatLng().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Status status) {
                Log.i("WTF", "An error occurred: " + status);
            }
        });

        try {
            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }

    }

    @Override
    public void onBackPressed() {
        super.finish();
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_pick_loc;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        final double Lat = latitude;
        final double Long = longitude;

        // Add a marker in Sydney, Australia, and move the camera

        final CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(0, 0))
                .zoom(15)
                .build();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i("WTF", "Place: " + place.getName());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.i("WTF", status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }

    @Override
    public void onPlaceSelected(Place place) {

    }

    @Override
    public void onError(Status status) {

    }

//    @Override
//    public void onPlaceSelected(Place place) {
////        Log.i(TAG, "Place Selected: " + place.getName());
//
//        // Format the returned place's details and display them in the TextView.
//        place_details.setText(formatPlaceDetails(getResources(), place.getName(), place.getId(),
//                place.getAddress(), place.getPhoneNumber(), place.getWebsiteUri()));
//
//        CharSequence attributions = place.getAttributions();
//        if (!TextUtils.isEmpty(attributions)) {
//            place_att.setText(Html.fromHtml(attributions.toString()));
//        } else {
//            place_att.setText("");
//        }
//    }
//
//    @Override
//    public void onError(Status status) {
////        Log.e(TAG, "onError: Status = " + status.toString());
//
//        Toast.makeText(this, "Place selection failed: " + status.getStatusMessage(),
//                Toast.LENGTH_SHORT).show();
//    }
//
//    private static Spanned formatPlaceDetails(Resources res, CharSequence name, String id,
//                                              CharSequence address, CharSequence phoneNumber, Uri websiteUri) {
////        Log.e(TAG, res.getString(R.string.app_name, name, id, address, phoneNumber,
////                websiteUri));
//        return Html.fromHtml(res.getString(R.string.app_name, name, id, address, phoneNumber,
//                websiteUri));
//
//    }
}
