import java.util.*;

public class Application
{
	public void run()
	{
		Scanner sc = new Scanner(System.in);
		FileManager file = new FileManager("ListaMateriales.txt");
		file.readFile();

		System.out.println(file.getFileContent());

		// Entrada de usuario
		System.out.println("¿Cuáles son los porcentajes?");
		String soporte = sc.nextLine(); 
		String interior = sc.nextLine(); 
		String exterior = sc.nextLine(); 

		System.out.println("¿Cuál es el área que usará la torre?");
		String area = sc.nextLine(); 

		System.out.println("¿Cuál es el presupuesto?");
		int presupuesto = sc.nextInt();

		System.out.println("¿Cuál es el peso que aguanta el área donde se construirá?");
		int pesoMax = sc.nextInt();


		// System.out.println("Done!");
	}
}
