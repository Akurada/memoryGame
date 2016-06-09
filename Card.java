
import java.awt.Color;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Card extends JButton {
	private String cardValue;
	private boolean matched = false;

	public void setValue(String cardValue) {
		this.cardValue = cardValue;
	}

	public String getValueOnCard() {
		return this.cardValue;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
		if (matched)
			this.setBackground(Color.BLACK);
	}

	public boolean getMatched() {
		return this.matched;
	}

	public Card(String cardValue) {
		setValue(cardValue);

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (getMatched())
					return;

				change_button_text();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

	public void change_button_text() {
		this.setText(cardValue);
	}

	public void hideText() {
		this.setText("");
	}

	public void compare_cards(Card other) {
		if (other == null)
			return;
		if (this.getValueOnCard().equals(other.getValueOnCard())) {
			this.setMatched(true);
			other.setMatched(true);
		}
	}


}
