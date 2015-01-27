import java.util.ArrayList;


public class Producer {
	ArrayList<Factory> factories;
	double cash;
	
	double[] margins;
	int threshold;
	
	static int counter = 0;
	int id;
	
	ArrayList<Order> orders;
	
	public Producer() {
		cash = 10000 * (1+Utils.doubleInRange(-0.1, 0.1));
		threshold = Utils.intInRange(2, 10);
		margins = new double[5];
		factories = new ArrayList<Factory>();
		factories.add(new Factory());
		setMargins();
		orders = null;
		counter++;
		id = counter;
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
		return margins[product.getId()-1] * product.getPrice();
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
		return threshold > orders.size();
	}
	
	public boolean canOpenNewFactory(Product product) {
		return (cash - Factory.construction_cost - product.getNCycles() > 0 ? true : false);
	}
}
