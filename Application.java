import java.util.*;

public class Application
{
	public void run()
	{
		Scanner sc = new Scanner(System.in);
		FileManager file = new FileManager("ListaMateriales.txt");
		file.readFile();

		Materials materials = new Materials();

		materials.setMaterials(file.getFileContent());

		// System.out.println(file.getFileContent());

		// Entrada de usuario
		// System.out.println("¿Cuáles son los porcentajes?");
		// System.out.print(">> ");
		// String soporte = sc.nextLine();
		// System.out.print("\n>> ");
		// String interior = sc.nextLine();
		// System.out.print("\n>> ");
		// String exterior = sc.nextLine(); 

		// System.out.println("¿Cuál es el área que usará la torre?");
		// System.out.print(">> ");
		// String[] area = sc.nextLine().split(" ");
		// int m = Integer.parseInt(area[0]);
		// int n = Integer.parseInt(area[1]);

		// System.out.println("¿Cuál es el presupuesto?");
		// System.out.print(">> ");
		// int presupuesto = sc.nextInt();

		// System.out.println("¿Cuál es el peso que aguanta el área donde se construirá?");
		// System.out.print(">> ");
		// int pesoMax = sc.nextInt();

		// 
		// Tower higher = new Tower();
		// Tower expensive = new Tower();
		// Tower empty = new Tower();

		// System.out.println("Done!");
	}
}
