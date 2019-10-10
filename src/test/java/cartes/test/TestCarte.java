package cartes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.Couleur;
import cartes.Signe;
import cartes.Valeur;

class TestCarte {

	@Test
	void testConstructeur() {
		// given
		Signe signe = Signe.CARREAU;
		Valeur valeur = Valeur.DAME;
		// when
		Carte carte = new Carte(valeur, signe);
		// then
		assertAll(
			()->assertEquals(signe, carte.getSigne()),
			()->assertEquals(valeur, carte.getValeur()),
			()->assertEquals(Couleur.ROUGE, carte.getCouleur())
		);
	}
	
	@Test
	void testEqualsNull() {
		// given
		Carte c = new Carte(Valeur.DAME, Signe.COEUR);
		// when
		boolean res = c.equals(null);
		// then
		assertFalse(res);
	}
	
	@Test
	void testEqualsFieldsEquals() {
		// given
		Carte c1 = new Carte(Valeur.DAME, Signe.COEUR);
		Carte c2 = new Carte(Valeur.DAME, Signe.COEUR);
		// when
		boolean res = c1.equals(c2);
		// then
		assertTrue(res);
	}

}
