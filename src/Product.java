import java.util.Random;


public class Product {
	double price;   // increase by a small random value (<5%) every 10 cycles
	int nCycles;
	int type;
	
	static int count = 0;
	int id;
	
	public Product()
	{
		price = Utils.doubleInRange(15, 25);
		type = Utils.intInRange(0, 4);
		if(type == 0 || type == 1 || type == 2)
			nCycles = 5;
		else
			nCycles = 7;
		
		count++;
		id = count;
	}
	
	public void updatePrice()  // calls once every 10 cycles
	{
		Random random = new Random();
		double rand = random.nextDouble() * 0.05;

		price *= (1+rand);
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getNCycles() {
		return this.nCycles;
	}

}
