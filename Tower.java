import java.util.*;

public class Tower
{
	private int m;
	private int n;
	private int h;
	private int hole;
	private int minH;
	private int weight;
	private int totalPrice;
	private HashMap<Material, Integer> materialsCount = new HashMap<Material, Integer>();
	private HashMap<String, Integer> categoriesRatios = new HashMap<String, Integer>();
	private HashMap<String, Integer> categoriesPercents = new HashMap<String, Integer>();
	private List<Material> materials = new ArrayList<Material>();

	public Tower()
	{
		this.m = 0;
		this.n = 0;
		this.h = 0;
		this.weight = 0;
		this.totalPrice = 0 ;
	}

	public Tower(int m, int n, HashMap<String, Integer> categoriesRatios, HashMap<String, Integer> categoriesPercents)
	{
		this.m = m;
		this.n = n;
		this.h = 0;
		this.hole = (this.m/2)*(this.n/2)*(this.m/5);
		this.weight = 0;
		this.totalPrice = 0 ;
		this.categoriesRatios = categoriesRatios;
		this.categoriesPercents = categoriesPercents;
	}

	public void setArea(int[] area)
	{
		this.m = area[0];
		this.n = area[1];
	}

	public void setMaterialsRatio(HashMap<String, Integer> percents)
	{
		this.categoriesPercents = percents;
		int[] arrayPercets = new int[percents.size()];
		int i = 0;	
		for (int n : percents.values()) {
			arrayPercets[i] = n;
			i++;
		}

		i = this.gcd(arrayPercets);

		for (String category : percents.keySet()) {
			this.categoriesRatios.put(category, percents.get(category)/i);
		}
	}

	public void setMinH()
	{
		int sum = 0;
		for (int ratio : this.categoriesRatios.values()) {
			sum += ratio;
		}
		int volume = sum;

		while(volume%(this.m * this.n) != 0){
			volume+=sum;
		}
		this.minH = volume/(this.m * this.n);
		this.h = this.minH;


		this.setMaterialsCount();
		this.setTotalPrice();
		this.setWeight();
	}

	public Boolean setMinHWithHole()
	{
		int sum = 0;
		List<Integer> leftovers = new ArrayList<Integer>();
		for (int ratio : this.categoriesRatios.values()) {
			sum += ratio;
		}
		int volume = sum+this.hole;

		while(volume%(this.m * this.n) != 0){
			if (leftovers.contains(volume%(this.m * this.n)) || this.hole == 0) {
				return false;
			} else {
				leftovers.add(volume%(this.m * this.n));
				volume+=sum;
			}
		}
		this.minH = volume/(this.m * this.n);
		this.h = this.minH;

		this.setMaterialsCount();
		this.setTotalPrice();
		this.setWeight();

		return true;
	}

	public void setMaterialsCount()
	{
		int volume = this.m * this.n * this.h;
		for (Material material : this.materials) {
			this.materialsCount.put(material, volume * this.categoriesPercents.get(material.getCategory())/100);
		}
	}

	public void setTotalPrice()
	{
		this.totalPrice = 0;
		for (Material material : this.materialsCount.keySet()) {
			this.totalPrice += this.materialsCount.get(material)* material.getPrice();
		}
	}

	public void setWeight()
	{
		this.weight = 0;
		for (Material material : this.materialsCount.keySet()) {
			this.weight += this.materialsCount.get(material)* material.getWeight();
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

	public int getHole(){
		return this.hole;
	}

	public int getTotalPrice()
	{
		return this.totalPrice;
	}

	public HashMap<String, Integer> getMaterialsRatio()
	{
		return this.categoriesRatios;
	}

	public HashMap<String, Integer> getMaterialsPercents()
	{
		return this.categoriesPercents;
	}

	public HashMap<Material, Integer> getMaterialsCount()
	{
		return this.materialsCount;
	}
	
	public int getWeight()
	{
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

	public void destroyFloor()
	{
		this.h -= this.minH;

		this.setMaterialsCount();
		this.setTotalPrice();
		this.setWeight();
	}

	public void buildFloors()
	{
		this.h += this.minH;

		this.setMaterialsCount();
		this.setTotalPrice();
		this.setWeight();
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
