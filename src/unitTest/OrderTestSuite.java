package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Consumer;
import app.Order;
import app.Producer;
import app.Product;

public class OrderTestSuite {

	Producer producer = new Producer();
	Consumer consumer = new Consumer();
	Product product = new Product();
	int quantity = 5;
	Order order = new Order(producer, consumer, product, quantity);
	
	@Test
	public void testGetStatus() {
		assertEquals("IN_EXECUTION", order.getStatus());
	}

	@Test
	public void testGetPayable() {
		assertEquals(product.getPrice() * quantity, order.getPayable(), 0.1);
	}
	
	@Test
	public void testSetStatus() {
		order.setStatus("COMPLETED");
		assertEquals("COMPLETED", order.getStatus());
	}
	
	@Test
	public void testGetProduct() {
		assertEquals(product, order.getProduct());
	}
}
