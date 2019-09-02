package cartes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.Signe;
import cartes.Valeur;

class TestCarte {

	@Test
	void test() {
		Carte carte = new Carte(Valeur.DAME, Signe.COEUR);
		System.out.println(carte);
	}

}
