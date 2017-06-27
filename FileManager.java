import java.util.*;
import java.io.*;

public class FileManager
{
	private String fileName;
	private List<String[]> fileContent;

	public FileManager(String fileName)
	{
		this.fileName = fileName;
		this.fileContent = null;
	}

	public List<String[]> getFileContent()
	{
		return this.fileContent;
	}

	public void readFile()
	{
		try {
			this.fileContent = new ArrayList<String[]>();

			File file = new File (this.fileName);
			FileReader fr = new FileReader (file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
    		while ((line = br.readLine()) != null) {
        		this.fileContent.add(line.split(";"));
    		}
    		fr.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void writeFile(List<String> findingWords)
	{
		try {
	        File file = new File(this.fileName);
	        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.write("Palabras en ambas sopas:\n");
            for (String word: findingWords) {
            	bw.write(word + "\n");
            }

	        bw.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
