package collection.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
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
		NavigableSet<String> villes = new TreeSet<>();  
		Collections.addAll(villes, "Toulouse", "Pau", "Lyon", "Bayonne", "Gaillac", "東京");
		for (String ville : villes) {
			System.out.println(ville);
		}
		String firstVille = villes.first();
	}

}
