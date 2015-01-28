
public class Order {
	int status;  // 0:ordered placed; 1:order accepted; 2:order shipped; 3:order received; 4:order refused/failed;
	
	Producer producer;
	Consumer consumer;
	Product product;
	int quantity;
	
	static int counter = -1;
	int id;
	
	public Order(Producer producer, Consumer consumer, Product product, int quantity) {
		this.producer = producer;
		this.consumer = consumer;
		this.product = product;
		this.quantity = quantity;
		
		id = counter++;
	}
	
	public int getStatus() {
		return status;
	}
	
	public double getPayable() {
		return product.getPrice() * quantity;
	}
	
	public int getId() {
		return this.id;
	}
}
