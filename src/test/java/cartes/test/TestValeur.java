package cartes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartes.Valeur;

class TestValeur {

	@Test
	void test() {
		Valeur valeur = Valeur.ROI;
		System.out.println(valeur);
	}

}
