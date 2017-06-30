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
	private HashMap<String, Integer> materialsPercents = new HashMap<String, Integer>();
	private List<Material> materials = new ArrayList<Material>();

	public Tower()
	{
		this.m = 0;
		this.n = 0;
		this.h = 0;
		this.weight = 0;
		this.totalPrice = 0 ;
	}

	public Tower(int m, int n, HashMap<String, Integer> materialsRatio)
	{
		this.m = m;
		this.n = n;
		this.h = 0;
		this.weight = 0;
		this.totalPrice = 0 ;
		this.materialsRatio = materialsRatio;
	}

	public void setArea(int[] area)
	{
		this.m = area[0];
		this.n = area[1];
	}

	public void setMaterialsRatio(HashMap<String, Integer> percents)
	{
		this.materialsPercents = percents;
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

	public void setMinH()
	{
		int sum = 0;
		for (int ratio : this.materialsRatio.values()) {
			sum += ratio;
		}

		if ((this.m * this.n) % sum == 0) {
			this.minH = 1;
		} else if (sum % (this.m * this.n) == 0){
			this.minH = sum / (this.m * this.n);
		} 

		this.h = this.minH;
		this.setMaterialsCount();
		this.setTotalPrice();
	}

	public void setMaterialsCount()
	{
		int volume = this.m * this.n * this.h;
		System.out.println("vol: "+volume);
		for (String materialName : this.materialsPercents.keySet()) {
			this.materialsCount.put(this.getMaterialByName(materialName), volume * this.materialsPercents.get(materialName)/100);
		}
	}

	public void setTotalPrice()
	{
		int sum = 0;
		for (Material material : this.materialsCount.keySet()) {
			sum += this.materialsCount.get(material);
			System.out.println(sum);
			this.materialsCount.put(material, material.getPrice() * this.materialsCount.get(material));
		}

	}

	public void setMaterials(List<Material> materials)
	{
		this.materials = materials;
	}

	public int[] getArea()
	{
		int[] area = new int[2];
		area[0] = this.m;
		area[1] = this.n;
		return area;
	}

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

	public Material getMaterialByName(String materialName)
	{
		for (Material material : this.materials) {
			if (material.getName() == materialName) {
				return material;
			}
		}

		return null;
	}

	public int getH()
	{
		return this.h;
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
