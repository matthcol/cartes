package cartes;

import java.util.LinkedList;
import java.util.List;

public class JeuCarte {
	public static List<Carte> nouveauJeu() {
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
