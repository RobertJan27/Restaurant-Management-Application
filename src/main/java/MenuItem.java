public abstract class MenuItem implements java.io.Serializable{
    private String title;
    private double Rating;
    private int Calories;
    private int protein;
    private int fat;
    private int sodium;
    private int Price;

    public MenuItem()
    {}
    public MenuItem(String title, double rating, int calories, int protein, int fat, int sodium, int price) {
        this.title = title;
        Rating = rating;
        Calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        Price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int calories) {
        Calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public abstract int computePrice();

}
