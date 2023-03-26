package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {
	String text = "This is a string that will be written to a file.";
	
	private String filename;

    public FileUtility(String filename) {
        this.filename = filename;
    }

    public void writeToFile(String str) {
        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/main/resources/" +filename, true);
            writer.write(str + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


