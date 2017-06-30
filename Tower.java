import java.util.*;

public class Tower
{
	private int m;
	private int n;
	private int h;
	private int minH;
	private int weight;
	private int totalPrice;
	private HashMap<Material, Integer> materialsCount = new HashMap<Material, Integer>();
	private HashMap<String, Integer> materialsRatio = new HashMap<String, Integer>();
	private List<Material> materials = new ArrayList<Material>();

	public Tower()
	{
		this.m = 0;
		this.n = 0;
		this.h = 0;
		this.weight = 0;
		this.totalPrice = 0 ;
	}

	public void setArea(int[] area)
	{
		this.m = area[0];
		this.n = area[1];
	}

	public void setMaterialsRatio(HashMap<String, Integer> percents)
	{
		int[] arrayPercets = new int[percents.size()];
		int i = 0;	
		for (int n : percents.values()) {
			arrayPercets[i] = n;
			i++;
		}

		i = this.gcd(arrayPercets);

		for (String category : percents.keySet()) {
			this.materialsRatio.put(category, percents.get(category)/i);
		}
	}

	// public int setMinH()
	// {
	// 	//
	// }

	public int getTotalPrice()
	{
		return this.totalPrice;
	}

	public HashMap<String, Integer> getMaterialsRatio()
	{
		return this.materialsRatio;
	}

	public int getWeight(){
		return this.weight;
	}

	public void addToMaterials(Material material)
	{
		this.materials.add(material);
	}

	private int gcd(int a, int b)
	{
	    while (b > 0){
	        int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}

	private int gcd(int[] input)
	{
	    int result = input[0];
	    for(int i = 1; i < input.length; i++){
	    	result = gcd(result, input[i]);
	    }
	    return result;
	}
}
