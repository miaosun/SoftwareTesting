package app;

public class Order {
	String status;  //
	
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
		
		status = "IN_EXECUTION";
		id = counter++;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return this.product;
	}
	
	public double getPayable() {
		return product.getPrice() * quantity;
	}
}
