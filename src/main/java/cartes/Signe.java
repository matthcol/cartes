package cartes;

public enum Signe {
	COEUR(Couleur.ROUGE),
	CARREAU(Couleur.ROUGE), 
	PIQUE(Couleur.NOIR), 
	TREFLE(Couleur.NOIR);
	
	private final Couleur couleur;

	private Signe(Couleur couleur) {
		this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}
		
}
