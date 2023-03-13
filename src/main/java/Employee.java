import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Employee implements Observer {
        public List<Order> orderList=new ArrayList<>();

    @Override
    public void update(Observable o, Object arg) {
this.orderList.add((Order)arg);
    }
}
