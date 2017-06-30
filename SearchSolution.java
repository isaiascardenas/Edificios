import java.util.*;

public class SearchSolution
{
	private List<Tower> solutionsSet = new ArrayList<Tower>();

	public void setSolutionsSet(List<List<Material>> combineMaterials, Tower baseTower)
	{
		List<Tower> solutionsSet = new ArrayList<Tower>();
		for (List<Material> materials : combineMaterials) {
			Tower newTower = new Tower(baseTower.getArea()[0], baseTower.getArea()[1], baseTower.getMaterialsRatio());
			newTower.setMaterials(materials);
			newTower.setMinH();
			System.out.print("h: "+newTower.getH());
			System.out.println(" price: "+newTower.getTotalPrice());
		}
	}

	public void run()
	{		
		// FileManager file = new FileManager("ListaMateriales.txt");
		// Materials materials = new Materials();
		// Tower tower = new Tower();

		// file.readFile();
		// materials.setMaterials(file.getFileContent());
		
		// tower.setPercents(this.inputPercents(materials.getCategories()));
		// tower.setArea(this.inputArea());

		// System.out.println("Done!");
	}
}
