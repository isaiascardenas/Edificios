import java.util.*;

public class Tower
{
	private int m;
	private int n;
	private int h;
	private int weight;
	private int totalPrice;
	private Hashtable<Material, Integer> materialsCount;
	private List<Material> materials = new ArrayList<Material>();

	public Tower(int m, int n)
	{
		this.m = m;
		this.n = n;
		this.h = 0;
		this.weight = 0;
		this.totalPrice = 0 ;
	}

	public void setPercents(int[] percents){
		// this.externalPercent = percents[0];
		// this.internalPercent = percents[1];
		// this.structuralPercent = percents[2];
	}

	public int getTotalPrice(){
		return this.totalPrice;
	}

	public int getWeight(){
		return this.weight;
	}

	public void addToMaterials(Material material){
		this.materials.add(material);
	}

	// public Hashtable<String, Integer> getMaterals(){
	// 	return this.materials;
	// }

	public void setMaterialsCout(int bulk){
		
	}

	// public buildByHigh(int high){
	// 	int bulk = this.m*this.n*high;
	// }
}
