package labs.dadm.myshoppingapplicationexam2020;

//This class is associated with the RecyclerView in the 'ProductList'-class
public class Items {

    private String text;
    private int productId;

    public Items(String text, int productId) {
        this.text = text;
        this.productId = productId;
    }

    public String getText() {
        return text;
    }

    public int getProductId() {
        return productId;
    }

}
