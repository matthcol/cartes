package collection.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class TestCollection {

	@Test
	void testListe() {
		List<String> villes = 
				List.of("Toulouse", "Pau", "Lyon", "Bayonne", "Gaillac", "東京");
		for (String ville : villes) {
			System.out.println(ville);
		}
		// Collections.sort(villes);
		System.out.println(villes);
	}
	
	@Test
	void testSet() {
		Set<String> villes = 
				Set.of("Toulouse", "Pau", "Lyon", "Bayonne", "Gaillac", "東京");
		for (String ville : villes) {
			System.out.println(ville);
		}
		System.out.println(villes.getClass());
	}
	
	@Test
	void testNavigableSet() {
		NavigableSet<String> villes = new TreeSet<>(
				// Comparator.reverseOrder()
				// String::compareToIgnoreCase
				);  
		Collections.addAll(villes, "Toulouse", "Pau", "Lyon", "Bayonne", "Gaillac", "東京");
		for (var ville : villes) {
			System.out.println(ville);
		}
		String firstVille = villes.first();
		System.out.println("1ere ville : " + firstVille);
		var plusPetits = villes.headSet("J");
		System.out.println("Plus petites :" + plusPetits);
		villes.add("Orange");
		villes.add("london");
		System.out.println(villes);
	}

}
