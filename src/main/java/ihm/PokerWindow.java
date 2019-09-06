package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import cartes.Carte;
import cartes.JeuCarte;

public class PokerWindow extends JFrame {
	private JButton buttonDraw;
	private JButton buttonShuffle;
	private JButton buttonReset;
	
	private JList<Carte> listCards;
	private ListModelCarte jeu;
	
	public PokerWindow() {
		super("Java Poke");
		// data model
		jeu = new ListModelCarte(JeuCarte.nouveauJeu());
		// init components
		var rootPane = this.getRootPane();
		rootPane.setLayout(new BorderLayout());
		// panneau pioche
		JPanel panelDraw = new JPanel();
		panelDraw.setLayout(new BoxLayout(panelDraw,BoxLayout.Y_AXIS ));
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(Color.RED);
		buttonDraw = new JButton("Draw");
		panelButtons.add(buttonDraw);
		buttonShuffle = new JButton("Shuffle");
		panelButtons.add(buttonShuffle);
		buttonReset = new JButton("Reset");
		panelButtons.add(buttonReset);
		panelDraw.add(panelButtons);
		listCards = new JList<Carte>(jeu);
		panelDraw.add(new JScrollPane(listCards));
		rootPane.add(panelDraw, BorderLayout.WEST);
		// all-in
		JPanel panelAllIn = new JPanel();
		panelAllIn.setPreferredSize(new Dimension(400, 400));
		rootPane.add(panelAllIn, BorderLayout.CENTER);
		// events
		buttonShuffle.addActionListener(e->jeu.shuffle());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// finalisation
		this.pack();
	}
	
	public static void main(String[] args) {
		 javax.swing.SwingUtilities.invokeLater(() -> {
	                PokerWindow ihm = new PokerWindow();
	                ihm.setVisible(true);
	            });
	}
}
