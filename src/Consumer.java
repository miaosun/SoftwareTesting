import java.util.ArrayList;


public class Consumer {
	double wage;  //1. stay constant;  2. increase by a small random value (<5%)
	double cash;
	boolean change_wage;
	int product_to_buy;

	ArrayList<Order> orders;

	public Consumer() {
		double percentage = Utils.doubleInRange(-0.1, 0.1);

		cash = 150 * (1+percentage);
	}

	public void updateWage()  //calls once every 100 cycles
	{
		if(change_wage)
		{
			double rand = Utils.doubleInRange(0, 0.05);
			wage *= (1+rand);
		}
	}

	public void updateCash()
	{
		cash += wage;
	}

	public void selectProduct()
	{
		product_to_buy = Utils.intInRange(0,4);
	}

	public int getProductToBuy()
	{
		return product_to_buy;
	}

	public double getCash()
	{
		return cash;
	}

	public void placeOrder(Producer producer, Product product)
	{

	}

	public void payForOrder()
	{
		
	}
}
