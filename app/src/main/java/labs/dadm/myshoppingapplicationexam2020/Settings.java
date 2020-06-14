package labs.dadm.myshoppingapplicationexam2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Settings extends AppCompatActivity {

    //Create variables
    EditText editTextChangeName, editTextChangePhone, editTextChangeAddress;
    Button btnSaveNewInfo;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Initialize variables to xml-resources
        editTextChangeName = findViewById(R.id.editTxtNewName);
        editTextChangePhone = findViewById(R.id.editTxtNewPhone);
        editTextChangeAddress = findViewById(R.id.editTxtNewAddress);
        btnSaveNewInfo = findViewById(R.id.btnSaveInfo);
        preferences = getSharedPreferences("prefs", MODE_PRIVATE);

        //Set onClick-method for saveInfo
        btnSaveNewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo();
            }
        });
    }

    //Save changed information when user exits application
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("editTextName", editTextChangeName.getText().toString());
        editor.putString("editTextPhone", editTextChangePhone.getText().toString());
        editor.putString("editTextAddress", editTextChangeAddress.getText().toString());
        editor.apply();
    }

    //Retrieve the saved information
    @Override
    protected void onResume() {
        super.onResume();
        editTextChangeName.setText(preferences.getString("editTextName", "Enter new name"));
        editTextChangePhone.setText(preferences.getString("editTextPhone", "Enter new phone number"));
        editTextChangeAddress.setText(preferences.getString("editTextAddress", "Enter new address"));
    }

    //Create saveInfo-method for button
    public void saveInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("editTextName", editTextChangeName.getText().toString());
        editor.putString("editTextPhone", editTextChangePhone.getText().toString());
        editor.putString("editTextAddress", editTextChangeAddress.getText().toString());
        editor.apply();
        Toast.makeText(this, "New information is saved", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), Navigation.class));
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

            case R.id.option_settings:
                startActivity(new Intent(getApplicationContext(), Settings.class));
                finish();
                return true;

            case R.id.option_logout:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Settings.this, "You are logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}