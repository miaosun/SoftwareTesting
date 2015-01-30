package app;
import java.util.Random;


public class Product {
	double price;   // increase by a small random value (<5%) every 10 cycles
	double cost;
	int nCycles;
	int type;

	public Product()
	{
		price = Utils.doubleInRange(10, 25);
		type = Utils.intInRange(0, 4);
		if(type == 0 || type == 1 || type == 2)
		{
			nCycles = 5;
			cost = 5;
		}
		else
		{
			nCycles = 7;
			cost = 7;
		}
	}

	public double getPrice() {
		return this.price;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public int getType() {
		return this.type;
	}

	public int getNCycles() {
		return this.nCycles;
	}

	public void updatePrice() {
		// only calls after each 10 cycles
		Random random = new Random();
		double rand = random.nextDouble() * 0.05;

		price *= (1+rand);
	}
}
