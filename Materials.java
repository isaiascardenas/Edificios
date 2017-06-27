import java.util.*;

public class Materials
{
	private List<Material> structural =  new ArrayList<Material>();
	private List<Material> internal =  new ArrayList<Material>();
	private List<Material> external =  new ArrayList<Material>();

	public Materials()
	{

	}

	public void setMaterials(List<String[]> data){
		for (String[] element: data) {
			Material material = new Material(element);
			if (element[1] == "MaterialExterior") {
				this.external.add(material);
			} else if (element[1] == "MaterialInterior") {
				this.internal.add(material);
			} else {
				this.structural.add(material);
			}
		}
	}

	public List<Material> getStructural(){
		return this.structural;
	}

	public List<Material> getInternal(){
		return this.internal;
	}
	
	public List<Material> getExternal(){
		return this.external;
	}
}
