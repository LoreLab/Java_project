import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class OptionVoyage {		
	private String nomVoyage;
	private double prixForfetaire;
	
	public OptionVoyage(String nomVoyage, double prixForfetaire) {
		this.nomVoyage = nomVoyage;
		this.prixForfetaire = prixForfetaire;
	}
	public String getNom() {
		return nomVoyage;
	}
	 public double prix() {
		return prixForfetaire;
	}
	 @Override
	public String toString() {
		return this.getNom() + " -> " + this.prix() + " CHF ";
	}
}
//===================================================================
class Sejour extends OptionVoyage {
	private int nbNuit;
	private double prixNuit;
	
	public Sejour(String nom, double tarif, int nbNuit, double prixNuit) {
		super(nom, tarif);
		this.nbNuit = nbNuit;
		this.prixNuit = prixNuit;
	}
	@Override
	public double prix() {
		return this.prixNuit * this.nbNuit + super.prix();
	}
	@Override
	public String toString() {
		String s = super.getNom() + " -> " + this.prix() + " CHF ";
		return s;
	}
	
}
//=======================================================
 class Transport extends OptionVoyage {
	public static final double TARIF_LONG = 1500.0;
	public static final double TARIF_BASE = 200.0;
	private final boolean trajetTarif;
	
	public Transport(String nom, double tarif, boolean trajetTarif) {
		super(nom,tarif);
		this.trajetTarif = trajetTarif ;
	}
	
	public Transport(String nom, double tarif) {
		super(nom, tarif);
		this.trajetTarif = false;
	}
	@Override
	public double prix() {
		double prixTransport = 0.0;
		if(this.trajetTarif) {
			prixTransport = Transport.TARIF_LONG;
		}else {
			prixTransport = Transport.TARIF_BASE;	
		}
		return super.prix() + prixTransport ;
	}
	@Override
	public String toString() {
		return super.getNom() + " -> " + this.prix() + " CHF ";
	}
}
//==============================================================
class KitVoyage {
	private ArrayList <OptionVoyage> listeOptionVoyage;
	private String depart;
	private String destination;
	
	public KitVoyage(String depart, String destination) {
		this.depart = depart;
		this.destination = destination;
		this.listeOptionVoyage = new ArrayList<OptionVoyage>();
	}
	
	public double prix() {
		
		double somme = 0.0;
		for(int i = 0; i < getNbOptions(); i++) {
			somme += listeOptionVoyage.get(i).prix() ;
		}
		return somme;
	}
	
	public String toString() {
		String s = "Voyage de " + depart + " à " + destination + ", avec pour options :\n";
		
		for(OptionVoyage liste : listeOptionVoyage) {			
			s += "  - " + liste.toString() + " \n";					  
		}
		
		return s += "Prix total : " + prix()+ " CHF \n ";
	}
	
	public void annuler() {
		listeOptionVoyage.clear();
	}
	
	public int getNbOptions() {
		return listeOptionVoyage.size();
	}
	
	public void ajouterOption(OptionVoyage uneOption) {
		if(uneOption == null) {
			return;
		}else {
			listeOptionVoyage.add(uneOption);
		}
	}
}

/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalites et
 * le jeu de test fourni.
 * Votre programme sera teste avec d'autres
 * donnees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2


         // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
	}

}