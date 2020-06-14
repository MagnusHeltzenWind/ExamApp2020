package labs.dadm.myshoppingapplicationexam2020;

//Mapping data for product
public class ProductsResponse {

    private int id;
    private String name;

    public ProductsResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Products getProduct() {
        return new Products(id, name);
    }

}
