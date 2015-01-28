import java.util.ArrayList;


public class Producer {
	ArrayList<Factory> factories;
	double cash;
	
	double[] margins;
	int threshold;
	
	static int counter = -1;
	int id;
	
	ArrayList<Order> orders;
	
	public Producer() {
		cash = 10000 * (1+Utils.doubleInRange(-0.1, 0.1));
		threshold = Utils.intInRange(2, 5);
		margins = new double[5];
		
		setMargins();
		counter++;
		id = counter;
		
		orders = new ArrayList<Order>();
		
		factories = new ArrayList<Factory>();
		factories.add(new Factory());
	}
	
	public void start() {
		
	}
	
	public boolean bankrupted() {
		return (cash <= 0 ? true : false);
	}
	
	public void setMargins() {
		for(int i=0; i<5; i++)
			margins[i] = Utils.doubleInRange(1.2, 1.5);
	}

	public double getProductPrice(Product product) {		
		return margins[product.getId()] * product.getPrice();
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getCash() {
		return this.cash;
	}
	
	public boolean noFactoryAvailable() {
		for(Factory f : factories)
		{
			if(f.isIdle())
				return false;
		}
		return true;
	}
	
	public int getNExecutionOrders() {
		int res = 0;
		for(Order order : orders)
		{
			if(order.getStatus().equals("IN_EXECUTION"))
				res++;
		}
		return res;
	}
	
	public int getNCompletedOrders() {
		int res = 0;
		for(Order order : orders)
		{
			if(order.getStatus().equals("COMPLETED"))
				res++;
		}
		return res;
	}
	
	public boolean orderSameProduct(Product product) {
		for(Factory factory : factories)
		{
			ArrayList<Order> orders = factory.getOrders();
			for(Order order : orders)
			{
				if(product.getId() == order.getProduct().getId())
					return true;
			}
		}
		return false;
	}
	
	public boolean canTakeMoreOrder() {
		return threshold > getNExecutionOrders();
	}
	
	public boolean canOpenNewFactory(Product product) {
		return (cash - Factory.construction_cost - product.getNCycles() > 0 ? true : false);
	}
	
	public void buildFactory() {
		factories.add(new Factory());
		this.cash -= Factory.construction_cost;
	}
	
	public void assignOrderToFactory(Order order) {
		for(Factory factory : factories)
		{
			if(factory.isIdle())
			{
				orders.add(order);
				factory.assignOrders(order);
				factory.setIdle(false);
			}
		}
	}
	
	public ArrayList<Factory> getFactories() {
		return this.factories;
	}
	
	public void receivePayment(double payable) {
		this.cash += payable;
	}
	
	public void updateData(int n) {
		for(Order order : orders)
		{
			if(n % order.getProduct().nCycles == 0)
			{
				order.setStatus("COMPLETED");
			}
		}
		
		for(Factory factory : factories)
		{
			ArrayList<Order> orders = factory.getOrders();
			for(Order order : orders)
			{
				if(n % order.getProduct().nCycles == 0)
					order.setStatus("COMPLETED");
			}
			factory.updateIdel();
		}
		cash -= Factory.running_cost;
	}
}
