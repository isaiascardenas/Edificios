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

	public void setSolutionsSetWithHole(List<List<Material>> combineMaterials, Tower baseTower)
	{
		for (List<Material> materials : combineMaterials) {
			Tower newTower = new Tower(baseTower.getArea()[0], baseTower.getArea()[1], baseTower.getMaterialsRatio(), baseTower.getMaterialsPercents());
			newTower.setMaterials(materials);
			if (!newTower.setMinHWithHole()) {
				this.solutionsSet.clear();
				this.solutionsBackup.clear();
				return;
			}
			
			this.solutionsSet.add(newTower);
		}
	}

	public Tower findExpensiveTower()
	{	
		Tower expensiveTower;
		int towersVolume = 0;
		while(towersVolume != 100 && this.solutionsSet.size() > 0) {
			expensiveTower = this.solutionsSet.get(0);
			towersVolume = expensiveTower.getArea()[0] * expensiveTower.getArea()[1] * expensiveTower.getH();

			this.filterExpensiveTower();
		}

		expensiveTower = new Tower();
		if (this.solutionsSet.size() > 0) {
			for (Tower tower :  this.solutionsSet) {
				if (tower.getTotalPrice() > expensiveTower.getTotalPrice() ) {
					expensiveTower = tower;
				}
			}
		} else {
			return null;
		}

		return expensiveTower;
	}

	public void filterExpensiveTower()
	{
		this.solutionsBackup.clear();
		List<Tower> solutionsSetClone = new ArrayList<Tower>(this.solutionsSet);

		for (Tower tower : solutionsSetClone) {
			if (100 %(tower.getArea()[0]*tower.getArea()[1]) != 0) {
				this.solutionsSet.clear();
			}else if (tower.getTotalPrice() > this.budget || tower.getWeight() > this.maxWeight) {
				this.solutionsSet.remove(tower);
			}

			tower.buildFloors();
		}
	}

	public Tower findHighestTower()
	{
		if (this.solutionsSet.size() == 0) {
			return null;
		}
		
		while(this.solutionsSet.size() > 0) {
			this.filterHighestTower();
		}

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
	}

	public void clearSolutionsSpace()
	{
		this.solutionsSet =  new ArrayList<Tower>();
		this.solutionsBackup =  new ArrayList<Tower>();
	}
}
