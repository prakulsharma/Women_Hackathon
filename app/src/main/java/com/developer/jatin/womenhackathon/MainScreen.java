package com.developer.jatin.womenhackathon;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.developer.jatin.womenhackathon.Fragments.Feedback;
import com.developer.jatin.womenhackathon.Fragments.Recent_chats;
import com.developer.jatin.womenhackathon.Fragments.SuggestTopic;
import com.developer.jatin.womenhackathon.Fragments.UpcomingSessions;
import com.developer.jatin.womenhackathon.Fragments.find_counselors;
import com.developer.jatin.womenhackathon.Fragments.find_pro_women;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Toolbar toolbar;
CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.ap)

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

//        int id = item.getItemId();
        int id = item.getItemId();

        if (id == R.id.find_professional_women) {
            find_pro_women blankFragment=new find_pro_women();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.app_bar,blankFragment,blankFragment.getTag()).commit();
        }
        else if (id == R.id.find_counselors) {
            toolbar.setTitle("Schemes");
            toolbar.setBackgroundColor(Color.parseColor("#0084a8"));
            find_counselors blankFragment=new find_counselors();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.app_bar,blankFragment,blankFragment.getTag()).commit();
        }
        else if (id == R.id.recent_chats) {
            Recent_chats blankFragment=new Recent_chats();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.app_bar,blankFragment,blankFragment.getTag()).commit();
        }
        else if (id == R.id.upcoming_sessions) {
            UpcomingSessions blankFragment=new UpcomingSessions();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.app_bar,blankFragment,blankFragment.getTag()).commit();
        }
        else if (id== R.id.suggest_topic) {
            SuggestTopic blankFragment=new SuggestTopic();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.app_bar,blankFragment,blankFragment.getTag()).commit();
        } 
        else if (id == R.id.share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.send));
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, getString(R.string.send)));
        }
        else if (id == R.id.feedback) {
            Feedback blankFragment=new Feedback();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.app_bar,blankFragment,blankFragment.getTag()).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
