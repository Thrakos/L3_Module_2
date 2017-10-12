package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

public class Copywriter /*hahahahahahahaha I'm a genius*/ {
	public static void main(String[] args) {
		
		try {
			
			FileWriter writer = new FileWriter("src/intro_to_file_io/Encrypterator.java", true);
			
			writer.write("\n\n//Copyright © 2017 by Bill Jobs");
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
