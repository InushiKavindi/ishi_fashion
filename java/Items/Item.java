package Items;

public class Item {
	
	private int id;
    private String i_name;
    private String category;
    private Double price;
    private String description;
    
    public Item() {
    	
    }
    
	public Item(int id, String i_name, String category, Double price, String description) {
		super();
		this.id = id;
		this.i_name = i_name;
		this.category = category;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    

}
