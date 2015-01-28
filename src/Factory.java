import java.util.ArrayList;


public class Factory {
	static int counter = -1;
	int id;
	public static double running_cost = 50;  // per cycle
	public static double construction_cost = 1500;   // one-off
	public static double startup_cost = 150;  // cost for restarting an idled factory
	double efficiency;   // qualify how much of the product is completed each cycle
	boolean idle;
	
	ArrayList<Order> orders;
	
	public Factory() {
		idle = true;
		efficiency = Utils.doubleInRange(0.5, 1.5);
		counter++;
		id = counter;
		
		orders = new ArrayList<Order>();
	}
	
	double getEfficiency() {
		return efficiency;
	}
	
	boolean isIdle() {
		return this.idle;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void assignOrders(Order order) {
		orders.add(order);
	}
	
	public void setIdle(boolean idle) {
		this.idle = idle;
	}
}
