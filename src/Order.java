
public class Order {
	int invoice_number;
	int status;  // 0:ordered placed; 1:order accepted; 2:order shipped; 3:order received; 4:order refused/failed;
	
	Producer producer;
	Consumer consumer;
	Product product;
	int quantity;
	
	public Order(Producer producer, Consumer consumer, Product product, int quantity) {
		this.producer = producer;
		this.consumer = consumer;
		this.product = product;
		this.quantity = quantity;
	}
	
	public int getStatus() {
		return status;
	}
	
	public double getPayable() {
		return product.getPrice() * quantity;
	}
}
