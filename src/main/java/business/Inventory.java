package business;

public class Inventory {
	
	private static Inventory instance;
	
	private int size;
	
	public Inventory() {
		this.size = 0;
	}

	static Inventory getInstance() {
		if (instance == null) {
			instance = new Inventory();
		}
		return instance;
	}

	public Object productsInStock() {
		return size;
	}

	public boolean addStock(String name) {
		if (name == null || name.trim().equals("")) {
			return false;
		}
		this.size++;
		return true;
	}

}
