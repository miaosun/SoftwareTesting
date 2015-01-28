import java.util.ArrayList;


public class Producer {
	ArrayList<Factory> factories;
	double cash;
	
	double[] margins;
	int threshold;
	
	static int counter = -1;
	int id;
	
	ArrayList<Order> in_execution_orders;
	ArrayList<Order> completed_orders;
	
	public Producer() {
		cash = 10000 * (1+Utils.doubleInRange(-0.1, 0.1));
		threshold = Utils.intInRange(2, 5);
		margins = new double[5];
		
		setMargins();
		in_execution_orders = null;
		completed_orders = null;
		counter++;
		id = counter;
		
		in_execution_orders = new ArrayList<Order>();
		completed_orders = new ArrayList<Order>();
		
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
	
	public boolean canTakeMoreOrder() {
		return threshold > in_execution_orders.size();
	}
	
	public boolean canOpenNewFactory(Product product) {
		return (cash - Factory.construction_cost - product.getNCycles() > 0 ? true : false);
	}
	
	public void buildFactory() {
		factories.add(new Factory());
	}
	
	public void assignOrderToFactory(Order order) {
		for(Factory factory : factories)
		{
			if(factory.isIdle())
			{
				in_execution_orders.add(order);
				factory.assignOrders(order);
				factory.setIdle(false);
			}
		}
	}
	
	public int getNOrdersInExecution() {
		return in_execution_orders.size();
	}
	
	public int getNCompletedOrders() {
		return completed_orders.size();
	}
}
