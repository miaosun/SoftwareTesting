package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Consumer;
import app.Factory;
import app.Order;
import app.Producer;
import app.Product;

public class FactoryTestSuite {

	@Test
	public void testIsIdle() {
		Factory factory = new Factory();
		assertTrue(factory.isIdle());
	}
	
	@Test
	public void testSetIdel() {
		Factory factory = new Factory();
		factory.setIdle(false);
		assertEquals(false, factory.isIdle());
	}
	
	@Test
	public void testGetOrders() {
		Factory factory = new Factory();
		assertEquals(0, factory.getOrders().size());
	}
	
	@Test
	public void testAssignOrder() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		Order order = new Order(producer, consumer, product, 3);
		
		Factory factory = new Factory();
		int nOrders = factory.getOrders().size();
		assertEquals(nOrders, factory.getOrders().size());
		
		factory.assignOrder(order);
		assertEquals(nOrders+1, factory.getOrders().size());
	}
	
	@Test
	public void testGetNCompletedOrders() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		Order order = new Order(producer, consumer, product, 2);
		
		Factory factory = new Factory();
		int nCompOrders = factory.getNCompletedOrders();
		assertEquals(nCompOrders, factory.getNCompletedOrders());
		
		order.setStatus("COMPLETED");
		factory.assignOrder(order);
		assertEquals(nCompOrders+1, factory.getNCompletedOrders());
	}

}
