import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Vehicule {
	private String nomVehicule;
	private double vitesseMax;
	private int poids;
	private int niveauCarburant;
	
	public Vehicule(String nomVehicule, double vitesseMax, int poids, int niveauCarburant) {
		this.nomVehicule = nomVehicule;
		this.vitesseMax = vitesseMax;
		this.poids = poids;
		this.niveauCarburant = niveauCarburant;
	}
	public Vehicule() {
		nomVehicule = "Anonyme";
		niveauCarburant = 0;
		vitesseMax = 130.0;
		poids = 1000;
	}
	public String getNom() {
		return nomVehicule;
	}
	public double getvitesseMax() {
		return vitesseMax;
	}
	public int getPoids () {
		return poids;
	}
	public int getniveauCarburant() {
		return niveauCarburant;
	}
	public String toString() {
		return this.nomVehicule + " -> vitesse max = " + vitesseMax 
				+ " km/h, poids = " + poids + " kg";
	}
	
	public boolean meilleur(Vehicule autreVehicule) {
		if(autreVehicule == null) {
			return false;
	}else if (autreVehicule.getClass()!= getClass()) {
		return false;
	}else {
		Vehicule v = (Vehicule)autreVehicule;
		return this.poids < v.poids;
	}
}
	public double performance() {
		return this.vitesseMax/this.poids;
	}
	
}
//=====================================================================
class Voiture extends Vehicule{
	private String categorie;
	
	public Voiture (String nomVehicule, double vitesseMax, int poids,
			int niveauCarburant, String categorie) {
       		super(nomVehicule, vitesseMax, poids, niveauCarburant);
       		this.categorie = categorie;
	}
	@Override
	public String toString() {
		String srt = super.toString();
		return srt += ", voiture de "+ this.categorie;
	}
	public String getCategorie () {
		return this.categorie;
	}
	
}
//=====================================================================	
class Moto extends Vehicule{
	private boolean sidecar ;
	
	public Moto (String nomVehicule, double vitesseMax, int poids,
			int niveauCarburant, boolean sidecar) {
       		super(nomVehicule, vitesseMax, poids, niveauCarburant);
       		this.sidecar = sidecar;
	}
	public Moto (String nomVehicule, double vitesseMax, int poids,
			int niveauCarburant) {
       		super(nomVehicule, vitesseMax, poids, niveauCarburant);
       		this.sidecar = false;
	}
	@Override
	public String toString() {
		String srt = super.toString();
		if(sidecar==true) {
		srt += ", Moto, avec sidecar";
		}else {
			srt += ", Moto";
		}
		return srt;
	}
}
//=====================================================================	
class GrandPrix extends Rallye {
	private ArrayList<Vehicule>listeVehicule;
	public GrandPrix() {
		this.listeVehicule = new ArrayList<Vehicule>();
	}
	@Override
	public boolean check() {
		return true;
	}
	public void ajouter(Vehicule vehicule) {
		if(vehicule == null) {
			return;
		}else {
			listeVehicule.add(vehicule);
		}
	}
    public boolean estDeuxRoues() {
		Vehicule vehicule = new Vehicule();
	}
}
abstract class Rallye {
	abstract boolean check();
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class Course {

	public static void main(String[] args) {

        // PARTIE 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }
        // FIN PARTIE 1

        // PARTIE2
        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la presence d'un sidecar
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la categorie
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();
        // FIN PARTIE 2

        // PARTIE 3
        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());
        // FIN PARTIE 3

       /* // PARTIE 4
        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
        // FIN PARTIE 4*/
	}

}
