package labs.dadm.myshoppingapplicationexam2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {

    //Create variables
    RecyclerView productsList;
    RecyclerView.Adapter productAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        //Initialize variables
        productsList = findViewById(R.id.rv_products);
        productsList.hasFixedSize();
        productsList.setLayoutManager(new GridLayoutManager(ProductList.this, 2));

        //ArrayList contain info of every product in GridView
        ArrayList<Items> products = new ArrayList<>();
        products.add(new Items("Shoes (42) - 299dkk          Tlf: 22091299", R.drawable.pic1));
        products.add(new Items("Shoes (41) - 150dkk          Tlf: 50112289", R.drawable.pic2));
        products.add(new Items("Shoes (42) - 499dkk          Tlf: 85091211", R.drawable.pic3));
        products.add(new Items("Shoes (39) - 299dkk          Tlf: 50091200", R.drawable.pic4));
        products.add(new Items("Shoes (44) - 499dkk          Tlf: 29581222", R.drawable.pic5));
        products.add(new Items("Shorts (M) - 299dkk          Tlf: 21415299", R.drawable.pic6));
        products.add(new Items("Shorts (M) - 150dkk          Tlf: 90158499", R.drawable.pic7));
        products.add(new Items("Shorts (L) - 99dkk           Tlf: 50415158", R.drawable.pic8));
        products.add(new Items("Dress (M) - 399dkk           Tlf: 74820563", R.drawable.pic9));
        products.add(new Items("Dress (S) - 250dkk           Tlf: 15899152", R.drawable.pic10));
        products.add(new Items("Shirt (XL) - 599dkk          Tlf: 22005299", R.drawable.pic11));
        products.add(new Items("Shirt (M) - 350dkk           Tlf: 99225299", R.drawable.pic12));
        products.add(new Items("Shirt (M) - 399dkk           Tlf: 22886150", R.drawable.pic13));
        products.add(new Items("Trousers (M) - 499dkk        Tlf: 22605011", R.drawable.pic14));
        products.add(new Items("Trousers (L) - 199dkk        Tlf: 88109292", R.drawable.pic15));
        products.add(new Items("Trousers (S) - 450dkk        Tlf: 88603111", R.drawable.pic16));
        products.add(new Items("Trousers (L) - 399dkk        Tlf: 21405022", R.drawable.pic17));
        products.add(new Items("Shirt (M) - 450dkk           Tlf: 29183011", R.drawable.pic18));
        products.add(new Items("Shirt (M) - 250dkk           Tlf: 25253022", R.drawable.pic19));
        products.add(new Items("Shirt (L) - 399dkk           Tlf: 59509422", R.drawable.pic20));
        products.add(new Items("Jacket (L) - 299dkk          Tlf: 22041422", R.drawable.pic21));
        products.add(new Items("Jacket (XL) - 599dkk         Tlf: 25374700", R.drawable.pic22));
        products.add(new Items("Jacket (L) - 450dkk          Tlf: 20998055", R.drawable.pic23));
        products.add(new Items("Jacket (M) - 399dkk          Tlf: 90112284", R.drawable.pic24));


        productAdaptor = new Products_Adapter(products, this);
        productsList.setAdapter(productAdaptor);

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
                Toast.makeText(ProductList.this, "You are logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}