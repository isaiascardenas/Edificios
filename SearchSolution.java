import java.util.*;

public class SearchSolution
{
	private List<Tower> solutionsSet = new ArrayList<Tower>();
	private List<Tower> solutionsBackup = new ArrayList<Tower>();
	private int budget;
	private int maxWeight;

	public SearchSolution(int budget, int maxWeight)
	{
		this.budget = budget;
		this.maxWeight = maxWeight;
	}

	public void setSolutionsSet(List<List<Material>> combineMaterials, Tower baseTower)
	{
		for (List<Material> materials : combineMaterials) {
			Tower newTower = new Tower(baseTower.getArea()[0], baseTower.getArea()[1], baseTower.getMaterialsRatio(), baseTower.getMaterialsPercents());
			newTower.setMaterials(materials);
			newTower.setMinH();
			
			this.solutionsSet.add(newTower);
		}
	}

	public Tower findHighestTower()
	{
		while(this.solutionsSet.size() > 0) {
			this.filterHighestTower();
		}
		System.out.println("sb.size: "+this.solutionsBackup.size());
		return this.solutionsBackup.get(0);
	}

	public void filterHighestTower()
	{	
		this.solutionsBackup.clear();
		List<Tower> solutionsSetClone = new ArrayList<Tower>(this.solutionsSet);

		for (Tower tower : solutionsSetClone) {
			if (tower.getTotalPrice() > this.budget || tower.getWeight() > this.maxWeight) {
				this.solutionsBackup.add(this.solutionsSet.remove(this.solutionsSet.indexOf(tower)));
			}

			tower.buildFloors();
		}
		this.showTowers(this.solutionsBackup);
	}

	//
	public void showTowers(List<Tower> list)
	{
		for (Tower t : list) {
			System.out.print("h: "+t.getH());
			System.out.print(" w: "+t.getWeight());
			System.out.println(" price: "+t.getTotalPrice());
		}
	}
}
