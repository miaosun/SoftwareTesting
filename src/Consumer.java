import java.util.ArrayList;


public class Consumer {
	double wage;  //1. stay constant;  2. increase by a small random value (<5%)
	double cash;
	boolean change_wage;

	Product product;
	ArrayList<Order> orders;

	public Consumer(boolean change_wage) {
		double percentage = Utils.doubleInRange(-0.1, 0.1);
		cash = 150 * (1+percentage);
		this.change_wage = change_wage;

		product = null;
	}

	public void start(ArrayList<Producer> producers, ArrayList<Product> products) {

		if(buyOrSkip())
		{
			//1. decide to buy or not, if yes, select randomly the product and the quantity to buy
			selectProduct(products);
			int quantity = Utils.intInRange(1, 10);

			//2. select the first producer with lowest price to place an order
			Producer producer = selectProducer(producers);


			placeOrder(producer, product, quantity);


		}
		else
			System.out.println("Not going to buy anything in this cycle");

	}

	public void updateWage()  //calls once every 100 cycles
	{
		if(change_wage)
		{
			double rand = Utils.doubleInRange(0, 0.05);
			wage *= (1+rand);
		}
	}

	public Producer selectProducer(ArrayList<Producer> producers) {

		double min_price = producers.get(0).getProductPrice(product);

		Producer res = null;
		for(Producer producer : producers)
		{
			if(producer.getProductPrice(product) < min_price)
			{
				min_price = producer.getProductPrice(product);
				if(!producer.noFactoryAvailable())
				{
					res = producer;	
				}
				else if(producer.canTakeMoreOrder() && producer.canOpenNewFactory(product))
				{
					res = producer;
				}
			}
		}
		
		System.out.println("Selected producer: " + res.getId());
		return res;
	}

	public void updateCash()
	{
		cash += wage;
	}

	public void selectProduct(ArrayList<Product> products)
	{
		int idProduct = Utils.intInRange(0,4);
		product = products.get(idProduct);
		System.out.println("Going to buy product number: " + idProduct);
	}

	public double getCash()
	{
		return cash;
	}

	public void placeOrder(Producer producer, Product product, int quantity)
	{
		double order_payable = producer.getProductPrice(product) * quantity;

	}

	public void payForOrder()
	{

	}

	public boolean buyOrSkip() {
		return (Utils.intInRange(0, 1) == 1 ? true : false);
	}
}
