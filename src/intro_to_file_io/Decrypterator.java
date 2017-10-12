package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decrypterator {
	public static void main(String[] args) {
		
		try {
			FileReader reader = new FileReader("src/intro_to_file_io/test3.txt");
			
			int c = reader.read();
			while(c != -1){
				char meh = (char)c;
				meh -= 1;
				System.out.print(meh);
				c = reader.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


//Copyright © 2017 by Bill Jobs