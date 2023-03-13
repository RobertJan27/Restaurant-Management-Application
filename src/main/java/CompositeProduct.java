import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompositeProduct extends MenuItem  implements java.io.Serializable {
    List<MenuItem> Items=new ArrayList<MenuItem>();
private String title;

CompositeProduct()
{}

    public CompositeProduct(String title, double rating, int calories, int proteins, int fats, int sodium, int price, List<MenuItem> compositeProducts) {
        super(title, rating, calories, proteins, fats, sodium, price);
        this.Items = compositeProducts;
    }

    public double Rating()
    {
        double rat=0.0;
        for(MenuItem aux:Items)
        {
            rat=rat+aux.getRating();
        }
    return rat;
    }
    public int Calories()
    {
        int cal=0;
        for(MenuItem aux:Items)
        {
            cal=cal+aux.getCalories();
        }
        return cal;
    }

    public int Protein()
    {
        int cal=0;
        for(MenuItem aux:Items)
        {
            cal=cal+aux.getProtein();
        }
        return cal;
    }

    public int Fat()
    {
        int cal=0;
        for(MenuItem aux:Items)
        {
            cal=cal+aux.getFat();
        }
        return cal;
    }
    public int Sodium()
    {
        int cal=0;
        for(MenuItem aux:Items)
        {
            cal=cal+aux.getSodium();
        }
        return cal;
    }


    @Override
    public int computePrice() {
int suma=0;
for(MenuItem i:Items)
    suma=suma+i.getPrice();
        return suma;

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
