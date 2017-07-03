import java.util.*;

public class States
{
	private List<List<Material>> openStates = new ArrayList<>();
	private List<List<Material>> newOpenStates = new ArrayList<>();
	private HashMap<String, List<Material>> materials = new HashMap<String, List<Material>>();

	public void setMaterials(HashMap<String, List<Material>> materials)
	{
		this.materials = materials;
	}

	public void initOpenStates(HashMap<String, Integer> categories)
	{
		for (String category : categories.keySet()) {
			for (Material material : this.materials.get(category)) {
				ArrayList<Material> states = new ArrayList<Material>();
				states.add(material);
				this.openStates.add(states);
			}
			break;
		}
	}

	public List<List<Material>> combineMaterials(HashMap<String, Integer> categories)
	{
		int i = 0;
		List<Material> state = new ArrayList<Material>();
		for (String category : categories.keySet()) {
			if (i >0) {
				this.changeData(this.openStates, this.newOpenStates);

				while (this.newOpenStates.size() > 0){
					state = this.newOpenStates.remove(0);

					for (Material material : this.materials.get(category)) {
						List<Material> aux = new ArrayList<Material>(state);
						aux.add(material);
						this.openStates.add(aux);
					}
				}
			}
			i++;
		}
		return this.openStates;
	}

	private void changeData(List<List<Material>> fullList, List<List<Material>> emptyList)
	{
		while (fullList.size() != 0) {
			emptyList.add(fullList.remove(0));
		}
	}
}
