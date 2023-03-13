import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService extends Observable implements java.io.Serializable,IDeliveryServiceProcessing {
    public Map<Order, ArrayList<MenuItem>> table= new HashMap();
   public ArrayList<MenuItem> meniu=new ArrayList<>();
   public ArrayList<Client> clients = new ArrayList<>();
    public List<Observer> obs=new ArrayList<>();
@Override
   public void afis()
   {
       for(Map.Entry<Order,ArrayList<MenuItem>>entry:table.entrySet())
   {
       Order key=entry.getKey();
       System.out.println(key.toString());
       List<MenuItem> list=entry.getValue();
   for(MenuItem aux:list)
   {
       BaseProduct b=(BaseProduct)aux;
       b.toString();
   }
   }
   }

   public DeliveryService()
   {
   }
@Override
   public void AddOrder(Order o,ArrayList<MenuItem>menu) {
       table.put(o,menu);
       notifyObservers(o);
       Employee_view v=new Employee_view();
       obs.add(v);
       obs.get(0).update(this,"Comanda " + o.getOrderid() +" a fost plasata");
       System.out.println(table);
   }
@Override
   public ArrayList<MenuItem> Search(String nume,double rating,int calories,int protein, int fat, int sodium,int price)
   {


       ArrayList<MenuItem>p=new ArrayList<>();
for(MenuItem m:meniu)
{if(m.getClass().getSimpleName().equals("BaseProduct"))
    p.add((BaseProduct) m);
if(m.getClass().getSimpleName().equals("CompositeProduct"))
    p.add((CompositeProduct)m);
}
       Stream<MenuItem> result=p.stream();
               if(nume!=null) {
               result=result.filter(q -> q.getTitle().contains(nume));
               }
       if(rating!=-2.0) {
           result=result .filter(q->q.getRating()==rating);
       }
       if(calories!=-2)
             result=result.filter(q->q.getCalories()==calories);
       if(protein!=-2)
           result=result.filter(q->q.getProtein()==protein);
       if(fat!=-2)
           result=result.filter(q->q.getFat()==fat);
       if(sodium!=-2)
           result=result.filter(q->q.getSodium()==sodium);
       if(price!=-2)
           result=result.filter(q->q.getPrice()==price);
       List<MenuItem>res=result
               . collect(Collectors.toList());
ArrayList<MenuItem> mm=new ArrayList<>();
       for(MenuItem b:res)
{mm.add(b);}
return mm;
   }




}
