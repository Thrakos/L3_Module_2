package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Encrypterator {
	public static void main(String[] args) {
				
		String hi = "";
		String bleh = JOptionPane.showInputDialog("Type in the box:");
		for (int i = 0; i < bleh.length(); i++) {
			char ble = bleh.charAt(i);
			ble += 1;
			hi += ble;
		}
		
		try {
			FileWriter writer = new FileWriter("src/intro_to_file_io/test3.txt");
			
			writer.write(hi);
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}


//Copyright © 2017 by Bill Jobs

//Copyright © 2017 by Bill Jobs