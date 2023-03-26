package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    private String filename;
    String line1;

    public MyFileReader(String filename) {
        this.filename = filename;
    }

    public void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/" +filename));
            String line;
            while ((line = reader.readLine()) != null) {
            	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println(line);
                line1=line;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String theString() {	
		return line1;
    }
    
}

