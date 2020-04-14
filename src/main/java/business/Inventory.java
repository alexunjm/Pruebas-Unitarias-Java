package business;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	
	private static Inventory instance;

	static Inventory getInstance() {
		if (instance == null) {
			instance = new Inventory();
		}
		return instance;
	}
	
	private Map<String, Integer> items;
	
	public Inventory() {
		this.items = new HashMap<String, Integer>();
		this.clearStock();
	}
	
	private void add(String product, int newQuantity) {
		if (this.items.containsKey(product)) {
			Integer quantity = this.items.get(product);
			this.items.put(product, quantity + newQuantity);
		} else {
			this.items.put(product, newQuantity);
		}
	}

	public void clearStock() {
		this.items.clear();
	}

	public int productsInStock() {
		return this.items.size();
	}

	public boolean addStock(String name) {
		return this.addStock(name, 1);
	}

	public boolean addStock(String name, int quantity) {
		if (name == null || name.trim().equals("")) {
			return false;
		}
		add(name, quantity);
		return true;
	}

	public int productsInStockOf(String productName) {
		return this.items.get(productName);
	}

	public Object[] arrayOfProducts() {
		return this.items.keySet().toArray();
	}

}
