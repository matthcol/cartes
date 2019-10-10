package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JLabel labelValeur;
	JLabel labelSigne;
	JLabel labelCouleur;
	JLabel labelImageCarte;
	
	
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
		JPanel panelAllIn = new JPanel(new GridLayout(0, 1));
		panelAllIn.setPreferredSize(new Dimension(400, 400));
		rootPane.add(panelAllIn, BorderLayout.CENTER);
		labelValeur = new JLabel();
		labelSigne = new JLabel();
		labelCouleur = new JLabel();
		labelImageCarte = new JLabel();
//		panelAllIn.add(labelValeur);
//		panelAllIn.add(labelSigne);
//		panelAllIn.add(labelCouleur);
		panelAllIn.add(labelImageCarte);
		// events
		buttonShuffle.addActionListener(e->jeu.shuffle());
		buttonReset.addActionListener(this::resetAction);
		buttonDraw.addActionListener(this::drawAction);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// finalisation
		this.pack();
	}
	
	private void resetAction(ActionEvent e) {
		jeu.reset();
		deckCheck();
	}
	
	private void drawAction(ActionEvent e) {
		Carte carte = jeu.removeElementAt(0);
		displayCarte(carte);
		deckCheck();
	}
	
	private void deckCheck( ) {
		buttonDraw.setEnabled(jeu.getSize()>0);
	}
	
	ImageIcon imagefileCarte(Carte carte) {
		String filename = carte.getValeur().toStringNumeric()
                + "_"
                + carte.getSigne().toString().toLowerCase()
                + ".png";
		System.out.println(filename);
		URL url = getClass().getResource(filename);
		System.out.println(url);
		return url==null?null:new ImageIcon(url);
	}
	
	private void displayCarte(Carte carte) {
//		labelValeur.setText(carte.getValeur().toString());
//		labelSigne.setText(carte.getSigne().getSymbol());
//		labelCouleur.setText(carte.getCouleur().toString());
		labelImageCarte.setIcon(imagefileCarte(carte));
	}
	
	public static void main(String[] args) {
		 javax.swing.SwingUtilities.invokeLater(() -> {
	                PokerWindow ihm = new PokerWindow();
	                ihm.setVisible(true);
	            });
	}
}
