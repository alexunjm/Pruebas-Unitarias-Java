package business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	
	private Inventory inventory;
	
	@Before
	public void setup() {
		this.inventory = Inventory.getInstance();
	}

	@Test
	public void testSingleton() {
		assertNotNull(this.inventory);
		assertSame(this.inventory, Inventory.getInstance());
	}

	@Test
	public void testProductsInStockIsZero() {
		assertEquals(0, this.inventory.productsInStock());
	}

	@Test
	public void testCreateEmptyProductReturnFalse() {
		assertFalse(this.inventory.addStock(null));
		assertFalse(this.inventory.addStock(""));
	}

	@Test
	public void testCreateProductReturnTrue() {
		assertTrue(this.inventory.addStock("Vaso Hulk"));
	}

	@Test
	public void testProductsInStockIsOne() {
		assertEquals(1, this.inventory.productsInStock());
	}

}
