package labs.dadm.myshoppingapplicationexam2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

/*This class is responsible for the Retrofit-search for products
Sources for some of the code for this theme:
https://docs.google.com/presentation/d/1vOdVifaz_icwWQ685-HDzzYtqVMkluJeKB3bJNXMfJE/edit#slide=id.g656c144e15_0_0
/It has been modified for the purpose of this project*/
public class Search extends AppCompatActivity {

    //Create variables
    EditText editTextSearch;
    ImageView imageView;
    ProductsViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Initialize variables
        editTextSearch = findViewById(R.id.editTxtSearch);
        imageView = findViewById(R.id.iv_search);
        viewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        viewModel.getProduct().observe(this, new Observer<Products>() {
            @Override
            public void onChanged(Products product) {
                Glide.with(Search.this).load(product.getImageUrl()).into(imageView);
            }
        });
    }
    public void updateProduct(View view) {
        viewModel.updateProduct(editTextSearch.getText().toString());
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
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}