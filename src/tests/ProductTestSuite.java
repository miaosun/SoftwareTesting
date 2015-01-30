package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import app.Product;

public class ProductTestSuite {
	@Test
	public void testPruductPrice() {
		Product p = new Product();
		assertTrue(p.getPrice()>=10 && p.getPrice()<=25);
	}
	
	@Test
	public void testPruductNCycles() {
		Product p = new Product();
		assertTrue(p.getNCycles()==5 || p.getNCycles()==7);
	}
	
	@Test
	public void testPruductCost() {
		Product p = new Product();
		assertTrue(p.getCost()==5 || p.getCost()==7);
	}
	
	@Test
	public void testUpdatePrice() {
		Product p = new Product();
		double price = p.getPrice();
		p.updatePrice();
		assertTrue(price*1.05 > p.getPrice());
	}
	
	@Test 
	public void testGetType() {
		Product product = new Product();
		int type = product.getType();
		assertTrue(type <= 4 && type >=0);
	}
}
