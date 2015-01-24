import java.util.Random;


public class Product {
	double price;   // increase by a small random value (<5%) every 10 cycles
	double proportion_per_cycle;
	int type;
	
	public Product()
	{

	}
	
	public void update_price()  // calls once every 10 cycles
	{
		Random random = new Random();
		double rand = random.nextDouble() * 0.05;

		price *= (1+rand);
	}

}
