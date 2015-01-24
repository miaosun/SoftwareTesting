
public class Factory {
	double running_cost;  // per cycle
	double construction_cost;   // one-off
	double startup_cost;  // cost for restarting an idled factory
	double efficiency;   // qualify how much of the product is completed each cycle
	boolean idle;
	
	public Factory() {
		running_cost = 50;
		construction_cost = 1500;
		startup_cost = 150;
		idle = true;
		efficiency = Utils.doubleInRange(0.5, 1.5);
	}
	
	double getEfficiency() {
		return efficiency;
	}
}
