import java.util.ArrayList;


public class Factory {
	static int counter = -1;
	int id;
	public static double running_cost = 50;  // per cycle
	public static double construction_cost = 1500;   // one-off
	public static double startup_cost = 150;  // cost for restarting an idled factory
	boolean idle;
	
	ArrayList<Order> orders;
	
	public Factory() {
		idle = true;
		counter++;
		id = counter;
		
		orders = new ArrayList<Order>();
	}
	
	public int getId() {
		return this.id;
	}
	
	boolean isIdle() {
		return this.idle;
	}
	
	public void setIdle(boolean idle) {
		this.idle = idle;
	}

	public void updateIdel() {
		int aux = 0;
		for(Order order : orders)
		{
			if(order.getStatus() .equals("COMPLETED"))
				aux++;
		}
		if(aux == orders.size())
			setIdle(true);
	}
	
	public ArrayList<Order> getOrders() {
		return this.orders;
	}
	
	public int getNCompletedOrders() {
		int res = 0;
		for(Order order : orders)
		{
			if(order.status.equals("COMPLETED"))
				res++;
		}
		return res;
	}
	
	public void assignOrder(Order order) {
		orders.add(order);
	}
}
