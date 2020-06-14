package labs.dadm.myshoppingapplicationexam2020;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ProductsViewModel extends ViewModel {

    ProductsRepository repository;

    public ProductsViewModel() {
        repository = ProductsRepository.getInstance();
    }

    LiveData<Products> getProduct() {
        return repository.getProduct();
    }

    public void updateProduct(String s) {
        repository.updateProduct(s);
    }
}
