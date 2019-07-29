import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private int annee = ANNEE_COURANTE;
    private String pays = PAYS_DEFAUT;
    private String code = CODE_DEFAUT;
    private double valeurFaciale = VALEUR_TIMBRE_DEFAUT;
   
    public Timbre(String code, int annee, String pays, double valeurFaciale) {
    	this.annee = annee;
    	this.valeurFaciale = valeurFaciale;
    	this.pays = pays;
    	this.code = code;
    }
    public Timbre(String code, int annee, String pays) {
    	this.code = code;
    	this.annee = annee;
    	this.pays = pays;
    }
    public Timbre(String code, int annee) {
    	this.code = code;
    	this.annee = annee;
    }
    public Timbre(String code) {
    	this.code = code;
    }
    public Timbre() {}
       
    public double vente() {    	
    	if(age() < 5) {
    		return valeurFaciale;
    	}else {
    		return valeurFaciale * age() * 2.5;
    	}    	
    }
    public String toString() {
    	return "Timbre de code "
    	+ code + " datant de "
    	+ annee+ " (provenance "+ pays + ")"
    	+ " ayant pour valeur faciale " + valeurFaciale + " francs";
    	
    }
    public int age() {
    	return ANNEE_COURANTE - annee;
    }
    public String getCode() {
    	return code;
    }
    public int getAnnee() {
    	return annee;
    }
    public String getPays() {
    	return pays;
    }
    public double getValeurFaciale() {
    	return valeurFaciale;
    }
}
class Rare extends Timbre {
	private int exemplaires;
	
	public Rare(String code, int annee, String pays, double valeurFaciale, int exemplaires) {
		super(code,annee, pays, valeurFaciale);
		this.exemplaires = exemplaires;
	}
	public Rare(String code, int annee, String pays, int exemplaires ) {
		super(code, annee, pays);
		this.exemplaires = exemplaires;
	}
	public Rare(String code, int annee, int exemplaires) {
		super(code, annee);
		this.exemplaires = exemplaires;
	}
	public Rare(String code, int exemplaires) {
		super(code);
		this.exemplaires = exemplaires;
	}
	public Rare(int exemplaires) {
		super();
		this.exemplaires = exemplaires;
	}
	public int getExemplaires() {
		return exemplaires;
	}
	public String toStirng() {
		return super.toString() + "\n" + "Nombre d'exemplaires -> " + this.exemplaires;
	}
	public double vente() {
		double prix_base = 0.0;
		if(exemplaires < 100) {
			prix_base += PRIX_BASE_1;
		}else if(exemplaires > 100 && exemplaires < 1000) {
			prix_base += PRIX_BASE_2;
		}else {
			prix_base += PRIX_BASE_3;
		}
		return prix_base * (this.age() / 10.0);
	}
}
class Commemoratif extends Timbre {
	public Commemoratif(String code, int annee, String pays, double valeurFaciale) {
    	super(code, annee, pays, valeurFaciale);
    }
    public Commemoratif(String code, int annee, String pays) {
    	super(code, annee, pays);
    }
    public Commemoratif(String code, int annee) {
    	super(code, annee);
    }
    public Commemoratif(String code) {
    	super(code);
    }
    public Commemoratif() {
    	super();
    }
    public String toString() {
    	return super.toString() + "\n " 
    			+ "Timbre celebrant un evenement";
    }
    public double vente() {
    	return super.vente() * 2;
    }
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

