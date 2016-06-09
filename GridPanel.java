import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GridPanel extends JPanel {

	private int turn;
	private Card previous;
	private Card cards[];

	public GridPanel(int numPairs, String[] arrayInputed) {

		turn = 0;

		cards = new Card[arrayInputed.length];

		setLayout(new GridLayout(2, numPairs));
		setBackground(Color.BLUE);
		this.setPreferredSize(new Dimension(500, 500));

		for (int i = 0; i < arrayInputed.length; i++) {
			final Card xyz = new Card(arrayInputed[i]);
			add(xyz);
			cards[i] = xyz;
		}

	}

	private void hideAllExcept(Card c) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] != c)
				cards[i].hideText();
		}
	}

	public Component add(final Card c) {
		c.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (c.getMatched())
					return;

				if ((++turn) % 2 == 0 && previous != null) {
					c.compare_cards(previous);
					hideAllExcept(c);
				}
				if (previous != null)
					System.out.println(turn + " " + c.getValueOnCard() + " vs " + previous.getValueOnCard());
				previous = c;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		return super.add(c);
	}
}
