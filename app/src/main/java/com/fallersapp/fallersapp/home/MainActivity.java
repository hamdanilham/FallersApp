package com.fallersapp.fallersapp.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.fallersapp.fallersapp.plan.PlanActivity;
import com.fallersapp.fallersapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.widget_toolbar)
    Toolbar widgetToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.rv_list_home)
    RecyclerView recyclerViewListHome;

    @BindView(R.id.text_toolbar_title)
    TextView tvToolbarTitle;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(widgetToolbar);
        tvToolbarTitle.setText("Home");

        //recycle view
        recyclerViewListHome.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerViewListHome.setLayoutManager(mLinearLayoutManager);

        mAdapter = new com.fallersapp.fallersapp.home.MainAdapter();
        recyclerViewListHome.setAdapter(mAdapter);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, widgetToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
//        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

//        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                Intent intent;

                switch(id){
                    case R.id.nav_home:
                        break;
                    case R.id.nav_plan:

                        intent = new Intent(MainActivity.this, PlanActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Inbox Selected", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.nav_map:
                        break;
                    case R.id.nav_history:
                        break;
                    case R.id.nav_profile:
                        break;
                    case R.id.nav_about:
                        break;
                }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent;

        switch(id) {
            case R.id.nav_home:
                break;
            case R.id.nav_plan:

                intent = new Intent(MainActivity.this, PlanActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Inbox Selected", Toast.LENGTH_SHORT).show();

                break;
            case R.id.nav_map:
                break;
            case R.id.nav_history:
                break;
            case R.id.nav_profile:
                break;
            case R.id.nav_about:
                break;
        }
//        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
