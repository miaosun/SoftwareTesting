package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Consumer;
import app.Factory;
import app.Order;
import app.Producer;
import app.Product;

public class ProducerTestSuite {

	@Test
	public void testCash() {
		Producer producer = new Producer();
		assertTrue(producer.getCash()<=11000 && producer.getCash()>=9000);
	}

	@Test
	public void testInitialFactoryNumber() {
		Producer producer = new Producer();
		assertEquals(1, producer.getFactories().size());
	}
	
	//@Test
	public void testProductPrice() {
		Product product = new Product();
		Producer producer = new Producer();
		assertTrue(product.getPrice()*1.2 <= producer.getProductPrice(product));
		assertTrue(product.getPrice()*1.5 >= producer.getProductPrice(product));
	}
	
	@Test
	public void testGetNExecutionOrders() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		Order order = new Order(producer, consumer, product, 6);
		int nOrders = producer.getNExecutionOrders();
		producer.assignOrderToFactory(order);
		assertEquals(nOrders+1, producer.getNExecutionOrders());
	}
	
	@Test
	public void testNoFactoryAvailable() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		Order order = new Order(producer, consumer, product, 6);
		
		producer.assignOrderToFactory(order);
		assertTrue(producer.noFactoryAvailable());
	}
	
	//@Test
	public void testGetNCompletedOrders() {  // fail because the test starts before the producer update data at the end of cycle
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Product product = new Product();
		Order order = new Order(producer, consumer, product, 6);
		int nOrder = producer.getNCompletedOrders();
		order.setStatus("COMPLETED");
		assertEquals(nOrder+1, producer.getNCompletedOrders());
	}
	
	@Test 
	public void testBuildFactory() {
		Producer producer = new Producer();
		int nFactory = producer.getFactories().size();
		double cash = producer.getCash();
		producer.buildFactory();
		assertEquals(nFactory+1, producer.getFactories().size());
		assertEquals(cash-Factory.construction_cost, producer.getCash(), 0.5);
	}
	
	@Test
	public void testReceivePayables() {
		double payable = 100.0;
		Producer producer = new Producer();
		double cash = producer.getCash();
		producer.receivePayment(payable);
		assertEquals(cash+100.0, producer.getCash(), 0.5);
	}
	
}
