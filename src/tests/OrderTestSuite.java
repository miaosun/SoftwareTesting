package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Consumer;
import app.Order;
import app.Producer;
import app.Product;

public class OrderTestSuite {
	
	@Test
	public void testGetStatus() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		int quantity = 5;
		Order order = new Order(producer, consumer, product, quantity);
		assertEquals("IN_EXECUTION", order.getStatus());
	}

	@Test
	public void testGetPayable() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		int quantity = 5;
		Order order = new Order(producer, consumer, product, quantity);
		assertEquals(product.getPrice() * quantity, order.getPayable(), 0.1);
	}
	
	@Test
	public void testSetStatus() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		int quantity = 5;
		Order order = new Order(producer, consumer, product, quantity);
		order.setStatus("COMPLETED");
		assertEquals("COMPLETED", order.getStatus());
	}
	
	@Test
	public void testGetProduct() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		int quantity = 5;
		Order order = new Order(producer, consumer, product, quantity);
		assertEquals(product, order.getProduct());
	}
}
