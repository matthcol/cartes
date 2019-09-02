package cartes.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.Signe;
import cartes.Valeur;

class TestCarte {
	private List<Carte> jeu;
	
	@BeforeEach
	void initJeu() {
		jeu = new LinkedList<>();
		for (Signe signe: Signe.values()) {
			for (Valeur valeur: Valeur.values()) {
				Carte carte = new Carte(valeur, signe);
				jeu.add(carte);
			}
		}
	}


	@Test
	void testRouge() {
		Carte carte = new Carte(Valeur.DAME, Signe.COEUR);
		System.out.println(carte);
		System.out.println(carte.getCouleur());
	}

	@Test
	void testNoir() {
		Carte carte = new Carte(Valeur.VALET, Signe.PIQUE);
		System.out.println(carte);
		System.out.println(carte.getCouleur());
	}

	@Test
	void testListeCarte() {
		List<Carte> jeu = new ArrayList<>();
		Carte carte1 = new Carte(Valeur.VALET, Signe.PIQUE);
		Carte carte2 = new Carte(Valeur.DAME, Signe.COEUR);
		jeu.add(carte1);
		jeu.add(carte2);
		System.out.println(jeu);
	}

	@Test
	void testJeuComplet() {
		System.out.println("Jeu : " + jeu);
		System.out.println("Nb cartes : " + jeu.size());
	}
	
	@Test
	void testBataille() {
		int nbJoueur = 2;
		List<Carte> main1 = new ArrayList<>();
		List<Carte> main2 = new ArrayList<>();
		Collections.shuffle(jeu);
		int numeroJoueur = 0;
		for (Carte carte: jeu) {
			if (numeroJoueur == 0) {
				main1.add(carte);
			} else {
				main2.add(carte);
			}
			numeroJoueur = (numeroJoueur + 1) % nbJoueur;
		}
		System.out.println("Joueur 1 : " + main1);
		System.out.println("Joueur 2 : " + main2);
	}
}
