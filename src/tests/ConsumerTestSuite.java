package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import app.Consumer;
import app.Producer;
import app.Product;

public class ConsumerTestSuite {

	@Test
	public void testGetCash() {
		Consumer c = new Consumer();
		assertTrue(c.getCash()>=135 && c.getCash()<=165);
	}
	
	@Test
	public void testSelectProdct() {
		ArrayList<Product> products = new ArrayList<Product>();
		for(int i=0; i<10; i++)
			products.add(new Product());
		Consumer consumer = new Consumer();
		consumer.selectProduct(products);
		assertTrue(consumer.getProduct().getType()>=0 && consumer.getProduct().getType()<=4);
	}
	
	@Test
	public void testSetCash() {
		Consumer consumer = new Consumer();
		consumer.setCash(100.0);
		assertEquals(100.0, consumer.getCash(), 0.0);
		
		consumer.setCash(350.0);
		assertEquals(350.0, consumer.getCash(), 0.0);
	}
	
	@Test
	public void testBuyOrSkip() {
		Consumer consumer = new Consumer();
		consumer.setCash(-1.0);
		assertTrue(!consumer.buyOrSkip());
	}
	
	@Test
	public void testSelectProducer() {
		ArrayList<Producer> producers = new ArrayList<Producer>();
		for(int i=0; i<10; i++)
			producers.add(new Producer());
		
		Consumer consumer = new Consumer();
		
		assertNotNull(consumer.selectProducer(producers));
	}
	
	@Test
	public void testPlaceOrder() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		int nOrders = producer.getNExecutionOrders();
		consumer.placeOrder(producer, 2);
		
		assertEquals(nOrders+1, producer.getNExecutionOrders());
	}

	@Test
	public void testPayForOrder() {
		Consumer consumer = new Consumer();
		Producer producer = new Producer();
		
		double cash = consumer.getCash();
		consumer.payForOrder(200.0, producer);
		
		assertEquals(cash-200.0, consumer.getCash(), 0.0);
	}
}
