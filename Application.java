import java.util.*;

public class Application
{
	private Scanner sc;

	public Application(){
		this.sc = new Scanner(System.in);
	}

	public void run()
	{
		
		FileManager file = new FileManager("ListaMateriales.txt");
		Materials materials = new Materials();
		Tower baseTower = new Tower();

		file.readFile();

		materials.setMaterials(file.getFileContent());
		
		baseTower.setMaterialsRatio(this.inputPercents(materials.getCategories()));
		baseTower.setArea(this.inputArea());

		//

		States s = new States();
		SearchSolution solver = new SearchSolution(this.inputBudget(), this.inputWeight());

		s.setMaterials(materials.getMaterials());
		s.initOpenStates(baseTower.getMaterialsRatio());
		
		solver.setSolutionsSet(s.combineMaterials(baseTower.getMaterialsRatio()), baseTower);
		Tower highestTower = solver.findHighestTower();

		System.out.println("Done!");
		System.out.print("Torre mas alta:"+highestTower.getH());
		System.out.println(" W:"+highestTower.getWeight()+" $:"+highestTower.getTotalPrice());
	}

	private int inputWeight(){
		// System.out.println("¿Cuál es el peso que aguanta el área donde se construirá?");
		// System.out.print(">> ");
		return this.sc.nextInt();
	}

	private int inputBudget(){
		// System.out.println("¿Cuál es el presupuesto?");
		// System.out.print(">> ");
		return this.sc.nextInt();
	}

	private int[] inputArea(){
		int[] area = new int[2];
		// System.out.println("¿Cuál es el área que usará la torre?");
		// System.out.print(">> ");
		String[] input = this.sc.nextLine().split(" ");
		area[0] = Integer.parseInt(input[0]);
		area[1] = Integer.parseInt(input[1]);

		return area;
	}

	private HashMap<String, Integer> inputPercents(List<String> categories){
		HashMap<String, Integer> percents = new HashMap<String, Integer>();
		int totalPercents = 0;

		// System.out.println("¿Cuáles son los porcentajes?");
		while(totalPercents != 100){
			// System.out.print(">> ");
			String[] input = this.sc.nextLine().split("=");

			if (categories.contains(input[0])) {
				totalPercents += Integer.parseInt(input[1].split("%")[0]);
				if (totalPercents > 100) {
					System.out.println("Los porcentajes ingresados deben sumar 100%.");
					System.out.println("Ingrese el último porcentaje nuevamente");
				} else {
					percents.put(input[0], Integer.parseInt(input[1].split("%")[0]));
				}
			} else {
				System.out.println("Categoría no encontrada.");
			}
		}

		return percents;
	}
}
