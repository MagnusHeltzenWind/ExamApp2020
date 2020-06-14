package labs.dadm.myshoppingapplicationexam2020;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("http://api.shopstyle.com").addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static ProductsApi productApi = retrofit.create(ProductsApi.class);

    public static ProductsApi getProductApi() {
        return productApi;
    }
}
