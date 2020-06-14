package labs.dadm.myshoppingapplicationexam2020;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRepository {

    private static ProductsRepository instance;
    private MutableLiveData<Products> product;

    private ProductsRepository() {
        product = new MutableLiveData<>();
    }

    public static synchronized ProductsRepository getInstance() {
        if (instance == null) {
            instance = new ProductsRepository();
        }
        return instance;
    }

    public LiveData<Products> getProduct() {
        return product;
    }

    public void updateProduct(String productName) {
        ProductsApi productApi = ServiceGenerator.getProductApi();
        Call<ProductsResponse> call = productApi.getProduct(productName);
        call.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.code() == 200) {
                    product.setValue(response.body().getProduct());
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Log.i("Retrofit", "A error has occured :(");
            }
        });
    }
}
