import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IDeliveryServiceProcessing {
    public void afis();
    public void AddOrder(Order o,ArrayList<MenuItem>menu);
    public ArrayList<MenuItem> Search(String nume,double rating,int calories,int protein, int fat, int sodium,int price);
}
