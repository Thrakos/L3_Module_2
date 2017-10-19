package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ListTracker implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	JButton newTask = new JButton();

	ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {

		ListTracker ls = new ListTracker();
		ls.setup();

	}

	void setup() {
		frame.add(panel);
		panel.add(add);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		panel.add(newTask);
		add.setText("Add Task");
		remove.setText("Remove Task");
		save.setText("Save");
		load.setText("Load");
		newTask.setText("New Task List");
		add.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		newTask.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
		
		try {

			FileReader reader = new FileReader("src/intro_to_file_io/lastSaved.txt");
			
			String thing = "";

			int c = reader.read();
			while (c != -1) {
				thing += (char)c;
				System.out.print((char)c);
				c = reader.read();
			}
			
			FileReader reader2 = new FileReader(thing);
			
			thing = "";

			c = reader2.read();
			while (c != -1) {
				if ((char)c != '\n') {
					thing += (char)c;
				} else {
					list.add(thing);
					thing = "";
				}
				c = reader2.read();
			}
			
			reader.close();
			reader2.close();
		}

		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String newTask = JOptionPane.showInputDialog("New Task: ");
			if (!newTask.equals(null)) {
				list.add(newTask);
			}
		}

		if (e.getSource() == remove) {
			String display = "";
			for (int i = 0; i < list.size(); i++) {
				display += (i + 1) + ": " + list.get(i) + "\n";
			}
			String removeTask = JOptionPane.showInputDialog(display + "Task Number to Remove:");
			display = "";
			list.remove(Integer.parseInt(removeTask) - 1);

		}

		if (e.getSource() == save) {
			
			String fileName = JOptionPane.showInputDialog("File Name:");
			String lastSaved = "src/intro_to_file_io/" + fileName + ".txt";
			
			try {

				FileWriter writer = new FileWriter("src/intro_to_file_io/" + fileName + ".txt");
				FileWriter writer2 = new FileWriter("src/intro_to_file_io/lastSaved.txt");
				
				String display = "";
				for (int i = 0; i < list.size(); i++) {
					display += list.get(i) + "\n";
				}

				writer.write(display);	
				writer2.write(lastSaved);

				writer.close();
				writer2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

			if (e.getSource() == load) {
				list.removeAll(list);

				String file = "";

				JFileChooser chooser = new JFileChooser();

				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile().getAbsolutePath();
				}

				try {

					FileReader reader = new FileReader(file);
					
					String thing = "";

					int c = reader.read();
					while (c != -1) {
						if ((char)c != '\n') {
							thing += (char)c;
						} else {
							list.add(thing);
							thing = "";
						}
						c = reader.read();
					}
					reader.close();
				}

				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if (e.getSource() == newTask) {
				list.removeAll(list);
			}
		}

	}


