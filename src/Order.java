
public class Order {
	int invoice_number;
	double payable;
	int status;  // 0:ordered placed; 1:order accepted; 2:order shipped; 3:order received; 4:order refused/failed;
	
	Producer producer;
	Consumer consumer;
	Product product;
	
	public Order(Producer producer, Consumer consumer, Product product) {
		this.producer = producer;
		this.consumer = consumer;
		this.product = product;
	}
}
