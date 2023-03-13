import java.util.List;

public class Order implements java.io.Serializable {
    private int Orderid;
    private int Clientid;
    private String OrderDate;
    private int hour;

    @Override
    public boolean equals(Object o)
    {if(o!=null && o instanceof Order)
    {
        int Ordid=((Order)o).getOrderid();
        int Cliid=((Order)o).getClientid();
        String Orddate=((Order)o).getOrderDate();
        int ora=((Order)o).getHour();

        if(Ordid==this.Orderid && Cliid==this.Clientid && Orddate.equals(this.OrderDate) && Orddate!=null && ora==this.hour)
            return true;
    }
    return false;

    }

    @Override
    public int hashCode()
    {
        return Orderid+Clientid+OrderDate.hashCode()+hour;
    }

    public int getOrderid() {
        return Orderid;
    }

    public void setOrderid(int orderid) {
        Orderid = orderid;
    }

    public int getClientid() {
        return Clientid;
    }

    public void setClientid(int clientid) {
        Clientid = clientid;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Orderid=" + Orderid +
                ", Clientid=" + Clientid +
                ", OrderDate='" + OrderDate + '\'' +
                ", hour=" + hour +
                '}';
    }
}
