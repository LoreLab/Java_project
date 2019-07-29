import java.util.ArrayList;
/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Piece {
	private String nom;
    
	public Piece(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	public String toString() {
		return getNom();
	}
}
class Composant{
	private Piece piece;
	private int quantite;
	
	public Composant(Piece piece, int quantite) {
		this.piece = piece;
		this.quantite = quantite;	
	}
	public Piece getPiece() {
		return piece;
	}
	public int getQuantite() {
		return quantite;
	}			 
}
class Simple extends Piece{
	private String orientation = "aucune";
	
	 public Simple(String nomPiece) {
		 super(nomPiece);
	  }
	 public Simple(String nomPiece, String orientation) {
		 super(nomPiece);
		 this.orientation = orientation;
	 }
	 public String getOrientation() {
			return orientation;
		 }
		 public String toString() {
			 String s = super.toString() ;
			 if(!orientation.equals("aucune")) {
				 s += " "+ getOrientation();
			 }
			 return s;
		 }
}class Composee extends Piece{
	private ArrayList<Piece> listePiece;
	private int nbMaxPiece;
	
	public Composee(String nom, int nbMaxPiece) {
		super(nom);
		this.nbMaxPiece = nbMaxPiece;
		listePiece = new ArrayList<Piece>(nbMaxPiece);
	}
	public int taille() {
		return listePiece.size();
	}
	public int tailleMax() {
		return nbMaxPiece;
	}
	public void construire(Piece nbPiece) {
		if(listePiece.size() >= nbMaxPiece) {
			System.out.println("Construction impossible");
		}else {
			listePiece.add(nbPiece);
		}
	}
	public String toString() {
		String s = super.toString()+ "(";
		for(Piece totalPiece : listePiece) {
			s += " " + totalPiece.toString() + ",";
		}
		s += ")";
		return s; 
	}
}
class Construction {
	private ArrayList <Piece> listePiece;
	private int nbMax; 
	
	public Construction(int nbMax) {		
		this.nbMax = nbMax;
		this.listePiece = new ArrayList <Piece>();
	}
	public int getNbMax() {
		return this.nbMax;
	}
	public int taille() {
		return listePiece.size();
	}
	public int tailleMax() {
		return nbMax;
	}
    
	public void ajouterComposant(Piece pieceConstruit,int nbMaxPiece) {
		Piece composant = new Composee(pieceConstruit.getNom(), nbMaxPiece);
		if(listePiece.size() >= nbMax) {
			System.out.println("Ajout de composant impossible");
		}else {
			
			listePiece.add(composant);
			
		}
	}
	public String toString() {
		//int nbMaxPiece ;
		//Composant nb = new Composant(super.toString(), nbMaxPiece);
		String s = "";
		for(Piece lesPieces: listePiece) {
			s+= lesPieces.toString() + " (quantite " + nbMax+ ")\n";
			
		}
		return s;
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * test e' avec d'autres donnees.
 *******************************************/
public class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
   }
}
