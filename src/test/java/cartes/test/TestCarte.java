package cartes.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.Couleur;
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
	
	@Test
	void testSuppressions() {
		// suppression avec index
		jeu.remove(11);
		System.out.println(jeu);
		// suppression avec objet 
		Carte carte = new Carte(Valeur.DIX, Signe.PIQUE);
		jeu.remove(carte);
		System.out.println(jeu);
		// suppression avec objet 
		Carte carte2 = jeu.get(1);
		jeu.remove(carte2);
		System.out.println(jeu);
		
	}
	
	@Test
	void testEqualsNotCarte() {
		Carte carte = new Carte(Valeur.CINQ, Signe.COEUR);
		String ville = "Toulouse";
		boolean res = ville.equals(carte);
		System.out.println(res);
		res = carte.equals(ville);
		System.out.println(res);
	}

	@Test
	void testDoublonEnsemble() {
		Set<Carte> set = new HashSet<>(jeu);
		System.out.println("Taille avant ajout : " + set.size());
		Carte carte = new Carte(Valeur.CINQ, Signe.COEUR);
		boolean res = set.add(carte);
		System.out.println("Ajout : " + res);
		System.out.println("Taille après ajout : " + set.size());
	}
	
	@Test
	void testDoublonEnsemble2() {
		Set<Carte> set = new HashSet<>();
		System.out.println("Taille avant ajout : " + set.size());
		Carte carte = new Carte(Valeur.CINQ, Signe.COEUR);
		boolean res = set.add(carte);
		System.out.println("Ajout : " + res);
		System.out.println("Taille après ajout : " + set.size());
	}
	
	@Test
	void testRechercheEnsemble() {
		Set<Carte> set = new HashSet<>(jeu);
		Carte carte = new Carte(Valeur.CINQ, Signe.COEUR);
		boolean res = set.contains(carte);
		//System.out.println(res);
		assertTrue(res);
	}
	
	@Test
	void testRechercheListe() {
		Carte carte = new Carte(Valeur.CINQ, Signe.COEUR);
		boolean res = jeu.contains(carte);
		//System.out.println(res);
		assertTrue(res);
	}
	
	
	@Test
	void testSortJeu() {
		Collections.sort(jeu, 
				Comparator.comparing(Carte::getValeur)
						.thenComparing(Carte::getSigne));
		System.out.println(jeu);
		Collections.sort(jeu, 
				Comparator.comparing(Carte::getSigne)
						.thenComparing(Carte::getValeur));
		System.out.println(jeu);
		//NavigableSet<Carte> set = new TreeSet<>(jeu);
		Collections.sort(jeu, 
				Comparator.comparing(Carte::getSigne)
						.thenComparing(Carte::getValeur, Comparator.reverseOrder()));
		System.out.println(jeu);
		Collections.sort(jeu, 
				Comparator.comparing(Carte::getSigne)
						.thenComparing(Carte::getValeur, 
								(v1,v2)->(v1.ordinal() + 12)%13 
											- (v2.ordinal() + 12)%13)); 
		System.out.println(jeu);
		Collections.sort(jeu, 
				Comparator.comparing(Carte::getSigne)
						.thenComparing(Carte::getValeur, 
								Comparator.comparing(Valeur::orderAsGreatest)));
		System.out.println(jeu);
	}

	@Test
	void testMapReduce() {
		var res = jeu.stream()
			.map(Carte::getValeur)
			.min(Comparator.naturalOrder());
		System.out.println(res);
		
		var res2 = jeu.stream()
				.filter(c -> c.getSigne() == Signe.COEUR)
				.map(Carte::getValeur)
				.mapToInt(Valeur::ordinal)
				.sum();
		System.out.println(res2);
	}
	
	@Test
	void testPipeline1() {
		jeu.stream()
			.filter(c -> c.getCouleur() == Couleur.ROUGE)
			.forEach(System.out::println);
	}
	
	@Test
	void testPipeline2() {
		var res = jeu.stream()
			.filter(c -> c.getCouleur() == Couleur.ROUGE)
			.collect(Collectors.groupingBy(Carte::getSigne));
		System.out.println(res);
	}
	
	@Test
	void testPipeline3() {
		var res = jeu.stream()
			.filter(c -> c.getSigne() != Signe.PIQUE)
			.collect(Collectors.groupingBy(Carte::getSigne, Collectors.counting()));
		System.out.println(res);
	}
	
	
	@Test
	void testPipeline0() {
		Collections.shuffle(jeu);
		var res = jeu.stream()
			.filter(c -> c.getSigne() != Signe.PIQUE)
			.limit(10)
			.collect(Collectors.toCollection(
					()->new TreeSet<>(Comparator.comparing(Carte::getValeur))));
			//.collect(Collectors.toCollection(TreeSet::new));
			//.collect(Collectors.toList());
			//.forEach(System.out::println);		
		System.out.println(res);
	}
	
	@Test
	void testPipeline0101() {
		Collections.shuffle(jeu);
		// NavigableSet<Carte> main
		var res = jeu.stream()
			.limit(10)
			.filter(c -> c.getSigne() != Signe.PIQUE)		
			//.map(Carte::getValeur)
			//.collect(Collectors.toList());
			//.collect(Collectors.toCollection(ArrayList::new));
			//.collect(Collectors.toCollection(TreeSet::new));
			.collect(Collectors.toCollection(
					() -> new TreeSet<>(Comparator.comparing(Carte::getValeur))
			));
//		    .map(Carte::getSigne)
//			.map(Signe::getCouleur)
//			.map(Object::toString)
			//.map(Signe::getSymbol)
			//.collect(Collectors.joining(", "));
			//.collect(Collectors.toCollection(
			//		()->new TreeSet<>(Comparator.comparing(Carte::getValeur))));
			//.collect(Collectors.toCollection(TreeSet::new));
			//.forEach(System.out::println);		
		System.out.println(res);
	}	
	
}
