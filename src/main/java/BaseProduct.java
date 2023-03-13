public class BaseProduct  extends MenuItem implements java.io.Serializable{
    public BaseProduct(String title, double rating, int calories, int proteins, int fats, int sodium, int price) {
        super(title, rating, calories, proteins, fats, sodium, price);
    }

    @Override
    public int computePrice() {
        return getPrice();
    }

    public BaseProduct()
    {}

}
