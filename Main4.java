
public class Main4 {
    public static void main(String[] args) {
        OnlineOrder o = new OnlineOrder("srinag", "xxxx", 555);
        
    }
}

class CustomerOrder{
    private String name;
    

    public CustomerOrder(String name ) { 
        this.name = name;
    
        
    }
}

class OnlineOrder extends CustomerOrder{
    private String deliveryAddress;
    private long trackingNumber;
    public OnlineOrder(String name, String deliveryAddress, long trackingNumber) { 
        super(name);
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
        
    }

}

