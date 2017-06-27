
public class Material
{
	private String name;
	private int weight;
	private int price;
	private String category;

	public Material(String[] data)
	{
		this.name = data[0];
		this.weight = Integer.parseInt(data[3]);
		this.price = Integer.parseInt(data[2]);
		this.category = data[1];
	}

	public String getName(){
		return this.name;
	}

	public int getWeight(){
		return this.weight;
	}

	public int getPrice(){
		return this.price;
	}
	
	public String getCategory(){
		return this.category;
	}
}
