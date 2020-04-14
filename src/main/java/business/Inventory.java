package business;

public class Inventory {
	
	private static Inventory instance;

	static Inventory getInstance() {
		if (instance == null) {
			instance = new Inventory();
		}
		return instance;
	}

	public boolean addStock(String string) {
		return true;
	}

}
