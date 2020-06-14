package labs.dadm.myshoppingapplicationexam2020;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductsApi {

    @GET("api/shopstyle/{name}")//Resource path (end-point)
    Call<ProductsResponse> getProduct(@Path("name") String name);
}
