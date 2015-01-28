import java.util.ArrayList;


public class Consumer {
	double wage;  //1. stay constant;  2. increase by a small random value (<5%)
	double cash;

	Product product;
	ArrayList<Order> orders;

	public Consumer() {
		double percentage = Utils.doubleInRange(-0.1, 0.1);
		cash = 150 * (1+percentage);

		wage = 200;

		product = null;

		orders = new ArrayList<Order>();
	}

	public void start(ArrayList<Producer> producers, ArrayList<Product> products) {

		if(buyOrSkip())
		{
			//1. decide to buy or not, if yes, select randomly the product and the quantity to buy
			selectProduct(products);
			int quantity = Utils.intInRange(1, 10);
			//System.out.println("Going to buy product number: " + product.getId() + " | quantity: " + quantity);

			//2. select the first producer with lowest price to place an order
			Producer producer = selectProducer(producers);

			if(producer != null)
			{
				//3. Place order and pay for order
				placeOrder(producer, quantity);
				payForOrder(product.getPrice() * quantity, producer);
			}
			//else
			//System.out.println("Can't make order");
		}
		//else
		//System.out.println("Not going to buy anything in this cycle");

	}

	public void updateWage(int n, boolean change_wage)  //calls once every 100 cycles
	{
		if(change_wage)
		{
			if(n % 100 == 0)
			{
				double rand = Utils.doubleInRange(0, 0.05);
				wage *= (1+rand);
			}
		}
	}

	public Producer selectProducer(ArrayList<Producer> producers) {

		int index = Utils.intInRange(0, producers.size()-1);
		Producer res = producers.get(index);

		if(!res.noFactoryAvailable())
		{
			//System.out.println("Selected producer: " + res.getId());
			return res;
		}
		if(res.canTakeMoreOrder() && res.orderSameProduct(product))
		{
			//System.out.println("New factory opened for: " + res.getId());
			//producers.get(res.getId()).buildFactory();
			return res;
		}
		else if(res.canTakeMoreOrder() && res.canOpenNewFactory(product))
		{
			producers.get(res.getId()).buildFactory();
			return res;
		}
		else
			return null;
	}

	public void updateCash() // end of each cycle
	{
		cash += wage;
	}

	public void selectProduct(ArrayList<Product> products)
	{
		product = products.get(Utils.intInRange(0,4));
	}

	public double getCash()
	{
		return cash;
	}

	public void placeOrder(Producer producer, int quantity) 
	{
		Order order = new Order(producer, this, product, quantity);
		producer.assignOrderToFactory(order);
		orders.add(order);
		//System.out.println("++ Order made with producer: " + producer.getId());
	}

	public void payForOrder(double payable, Producer producer)
	{
		cash -= payable;
		producer.receivePayment(payable);
	}

	public boolean buyOrSkip() {
		return (Utils.intInRange(0, 1) == 1 ? true : false);
	}
}
