package business;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InventoryTest {

	@Test
	public void testSingleton() {
		Inventory inventory = Inventory.getInstance();
		assertSame(inventory, Inventory.getInstance());
	}

	@Test
	public void testCreateProduct() {
		Inventory inventory = Inventory.getInstance();
		assertTrue(inventory.addStock("Vaso Hulk"));
	}

}
