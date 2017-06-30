import java.util.*;

public class Materials
{
	// private HashMap<String, Integer> percents = new HashMap<String, Integer>();
	private HashMap<String, List<Material>> materials = new HashMap<String, List<Material>>();

	public void setMaterials(List<String[]> data){
		for (String[] element: data) {
			Material material = new Material(element);

			if (this.materials.get(element[1]) == null) {
				List<Material> newCategory = new ArrayList<Material>();
				newCategory.add(material);

				this.materials.put(element[1], newCategory);
			} else {
				this.materials.get(element[1]).add(material);
			}
		}
	}

	public List<Material> getMaterialCategory(String category){
		return this.materials.get(category);
	}

	public int getMaterialsSize(){
		return this.materials.size();
	}
}
