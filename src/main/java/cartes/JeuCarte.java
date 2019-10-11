package cartes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JeuCarte {
	private List<Carte> cartes;
	
	public JeuCarte() {
		this(false);
	}
	
	public JeuCarte(boolean random) {
		cartes = nouveauJeuAsList();
		if (random) {
			Collections.shuffle(cartes);
		}
	}
	
	public int taille() {
		return cartes.size();
	}
	
	public Carte retirer() {
		return cartes.remove(0);
	}
	
	public static List<Carte> nouveauJeuAsList() {
		List<Carte> jeu = new LinkedList<>();
		for (Signe signe: Signe.values()) {
			for (Valeur valeur: Valeur.values()) {
				Carte carte = new Carte(valeur, signe);
				jeu.add(carte);
			}
		}
		return jeu;
	}
}
