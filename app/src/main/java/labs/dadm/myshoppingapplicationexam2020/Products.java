package labs.dadm.myshoppingapplicationexam2020;

public class Products {

    private int number;
    private String name;
    private String imageUrl;

    public Products(int number, String name, String imageUrl){
        this.number = number;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Products(int id, String name) {
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return  imageUrl;
    }



}
