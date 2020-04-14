package business;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	
	private Inventory inventory;
	
	@Before
	public void setup() {
		this.inventory = Inventory.getInstance();
	}
	
	@After
	public void clearData() {
		this.inventory.clearStock();
	}

	@Test
	public void testUniqueInstanceOfInventory() {
		assertNotNull(this.inventory);
		assertSame(this.inventory, Inventory.getInstance());
		assertEquals(this.inventory, Inventory.getInstance());
	}

	@Test
	public void testCreateEmptyProductReturnFalseAndSizeNoChange() {
		assertEquals(0, this.inventory.productsInStock());
		assertFalse(this.inventory.addStock(null));
		assertFalse(this.inventory.addStock(""));
		assertFalse(this.inventory.addStock(null, 2));
		assertFalse(this.inventory.addStock("", 3));
		assertEquals(0, this.inventory.productsInStock());
	}

	@Test
	public void testCreateProductAndCheckStockSize() {
		assertEquals(0, this.inventory.productsInStock());
		assertTrue(this.inventory.addStock("Vaso Hulk"));
		assertEquals(1, this.inventory.productsInStock());
	}

	@Test
	public void testNewSingleItemArrayStock() {
		assertEquals(0, this.inventory.productsInStock());
		List<Object> products = Arrays.asList(new Object[] {"Vaso", "Camiseta", "Vaso", "Comic", "Vaso", "Vaso", "Juguete", "Juguete"});
		for (Object product : products) {
			assertTrue(this.inventory.addStock((String) product));
		}
		Set<Object> setOfProducts = new HashSet<Object>(products);
		assertEquals(setOfProducts.size(), this.inventory.productsInStock());
		assertArrayEquals(setOfProducts.toArray(), this.inventory.arrayOfProducts());
		assertEquals(4, this.inventory.productsInStockOf("Vaso"));
	}

	@Test
	public void testSupplyInventory() {
		assertEquals(0, this.inventory.productsInStock());
		List<Object[]> products = Arrays.asList(new Object[][] {
			{"Vaso", 40}, {"Camiseta", 2}, {"Comic", 1}, {"Juguete", 2}
			});
		for (Object[] product : products) {
			assertTrue(this.inventory.addStock((String) product[0], (int) product[1]));
		}
		assertEquals(2, this.inventory.productsInStockOf("Juguete"));
	}
}
