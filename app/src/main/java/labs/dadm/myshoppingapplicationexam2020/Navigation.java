package labs.dadm.myshoppingapplicationexam2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        //Reference to bottom navigation view
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navBarListener);

        //Makes sure the "Home"-fragment is default when launching app
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
              new HomeFragment()).commit();
    }

    //Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    //Create method for different options in 'options_menu' when clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_home:
                startActivity(new Intent(getApplicationContext(), Navigation.class));
                finish();
                return true;

            case R.id.option_products:
                startActivity(new Intent(getApplicationContext(), ProductList.class));
                finish();
                return true;

            case R.id.option_search:
                startActivity(new Intent(getApplicationContext(), Search.class));
                finish();
                return true;

            case R.id.option_settings:
                startActivity(new Intent(getApplicationContext(), Settings.class));
                finish();
                return true;

            case R.id.option_logout:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Navigation.this, "You are logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //To react on clicks on the items
    private BottomNavigationView.OnNavigationItemSelectedListener navBarListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    //Switch between fragments when clicking
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_job:
                            selectedFragment = new JobsFragment();
                            break;

                        case R.id.nav_info:
                            selectedFragment = new InfoFragment();
                            break;
                    }

                    //Show fragments
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    //True = wants to select the clicked item
                    return true;
                }
            };
}