package ihm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import cartes.Carte;
import cartes.JeuCarte;

public class ListModelCarte extends AbstractListModel<Carte> {
	
	private List<Carte> jeu;
	
	public ListModelCarte(Collection<? extends Carte> cartes) {
		jeu = new ArrayList<>(cartes);
	}
	
	@Override
	public int getSize() {
		return jeu.size();
	}
	
	@Override
	public Carte getElementAt(int index) {
		return jeu.get(index);
	}

	public Carte removeElementAt(int index) {
		Carte res = jeu.get(index);
		jeu.remove(index);
		this.fireIntervalRemoved(this, index, index);
		return res;
	}
	
	public void shuffle() {
		Collections.shuffle(jeu);
		this.fireContentsChanged(this, 0, jeu.size()-1);
	}
	
	public void reset() {
		jeu.clear();
		jeu.addAll(JeuCarte.nouveauJeu());
		this.fireContentsChanged(this, 0, jeu.size()-1);
	}

	
}
