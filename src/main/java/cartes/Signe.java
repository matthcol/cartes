package cartes;

public enum Signe {
	COEUR(Couleur.ROUGE, "\u2661"),
	CARREAU(Couleur.ROUGE, "\u2662"), 
	PIQUE(Couleur.NOIR, "\u2660"), 
	TREFLE(Couleur.NOIR, "\u2663");
	
	private final Couleur couleur;
	private final String symbol;
	
	private Signe(Couleur couleur, String symbol) {
		this.couleur = couleur;
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public Couleur getCouleur() {
		return couleur;
	}
		
	
}
