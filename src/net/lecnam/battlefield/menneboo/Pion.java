package net.lecnam.battlefield.menneboo;


/*
 * Classe qui créée les pions
 */

public abstract class Pion implements Choisissable {

	private int    vitalite;
    private int    forceDeFrappe;
    private int    heritage;
    private Case   caseCourante;
    private String nom;

    public Pion( int vitalite, int forceDeFrappe, int heritage, String nom, Case caseCourante ) {
        this.vitalite = vitalite;
        this.forceDeFrappe = forceDeFrappe;
        this.heritage = heritage;
        this.nom = nom;
        this.caseCourante = caseCourante;
    }

    public int getVitalite() {
        return vitalite;
    }

    public void setVitalite( int vitalite ) {
        this.vitalite = vitalite;
    }

    public int getForceDeFrappe() {
        return forceDeFrappe;
    }

    public void setForceDeFrappe( int forceDeFrappe ) {
        this.forceDeFrappe = forceDeFrappe;
    }

    public int getHeritage() {
        return heritage;
    }

    public void setHeritage( int heritage ) {
        this.heritage = heritage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public Case getCaseCourante() {
        return caseCourante;
    }

    public void setCaseCourante( Case caseCourante ) {
        this.caseCourante = caseCourante;
    }

    public abstract void attaquer( Pion pionAattaquer );

    public void perdreVitalite( int force ) {
        this.vitalite -= force;
    }

    public void gagnerVitalite( int heritage ) {
        this.vitalite += heritage;
    }

    public abstract void deplacer( Direction d );

    public boolean estVivant() {
        // TODO Auto-generated method stub
        if ( this.getVitalite() <= 0 )
            return false;
        return true;
    }

    public String getDescription() {
        // TODO Auto-generated method stub
        return this.getNom() + "- Vie : " + this.getVitalite() + ", Force : " + this.getForceDeFrappe()
                + ", Heritage : "
                + this.getHeritage();
    }
}
