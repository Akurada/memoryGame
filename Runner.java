import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Runner {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		// TODO Auto-generated method stub
		// This is where the game will be played
		intro();
		// Ask the user how many items they would like to match
		System.out.println("What is the name of your file: ");
		String fileName = console.next();
		System.out.println("How many pairs of items would you like to match?");
		// Done by GUI
		int numPairs = console.nextInt();

		if (numPairs <= 0) {

			System.out.println("Need to have more than 0 pairs");

			return;

		}

		ArrayList<String> listofElements = new ArrayList<String>();

		System.out.println(
				"\n Enter each pair name followed by an Enter(just once for each pair -- no pairs can be dublicated). ");

		String nextElement = null;

		for (int a = 0; a < numPairs; a++) {

			System.out.println("Print your next element: ");

			nextElement = console.next();
			listofElements.add(nextElement);
			listofElements.add(nextElement);

		}

		console.close();

		// ArrayInit firstFile= new ArrayInit(numPairs, listofElements);

		Collections.shuffle(listofElements);

		String[] arrayInputed = new String[listofElements.size()];

		for (int i = 0; i < listofElements.size(); i++) {
			arrayInputed[i] = listofElements.get(i);
		}


		playgame(numPairs, arrayInputed);
	}

	public static void intro() {
		System.out.print("Welcome!\nThis is a memory game. \nThe goal is to "
				+ "match one card with another card until the whole board is cleared.\n");
	}

	public static void playgame(int numPairs, String[] arrayInputed) {

		GridPanel gp = new GridPanel(numPairs, arrayInputed);
		JFrame jFram = new JFrame();

		jFram.add(gp);
		jFram.pack();
		jFram.setVisible(true);
		jFram.setTitle("Matching Game");

		jFram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}