package com.example.matthew.componentsandroid;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.matthew.componentsandroid.Controller.Persistency;
import com.example.matthew.componentsandroid.View.ViewUtils.IntentsProvider;
import com.github.florent37.materialviewpager.MaterialViewPager;

/**
 * Created by gonde on 30/07/2016.
 */
public class MainActivity extends AppCompatActivity {
    private IntentsProvider provider;
    private ActionBarDrawerToggle toggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private Toolbar toolbar;
    /**
     * Instancia del drawer
     */
    private DrawerLayout drawerLayout;
    private MaterialViewPager viewPager;

    public MaterialViewPager getViewPager() {
        return viewPager;
    }


    /**
     * Titulo inicial del drawer
     */
    private String drawerTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        provider = new IntentsProvider(getSupportFragmentManager(), this);
        setTab();
        provider.openMain();
    }

    private void setTab() {
        setToolbar(); // Setear Toolbar como action bar

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        drawerLayout.setDrawerListener(toggle);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.home);


    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_drawer);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento

                        String title = menuItem.getTitle().toString();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_list_view:
                                provider.switchMenuFragment(0);
                                break;
                            case R.id.nav_viewPager:
                                provider.switchMenuFragment(1);
                                break;
                            case R.id.nav_log_out:
                                System.exit(1);
                                break;
                            case R.id.nav_home:
                                provider.openMain();
                                break;
                        }
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        return true;
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.nav_menu, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ImageView iv;
    private ListView tv;
}
