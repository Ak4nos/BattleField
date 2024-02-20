package net.lecnam.battlefield.menneboo;

/*
 * Classe qui créée le pion méchant et gère ses actions
 */
public class PionMechant extends Pion {

    public PionMechant( int vitalite, int forceDeFrappe, int heritage, String nom, Case caseCourante ) {
        super( vitalite, forceDeFrappe, heritage, nom, caseCourante );
        // TODO Auto-generated constructor stub
    }

    @Override
    public void deplacer( Direction d ) {
        // TODO Auto-generated method stub
    }
/*
 * Méthode qui permet l'attaque riposte du méchant et renvoi à l'attaque pion joueur
 */
    public void attaquer( Pion pionJoueur ) {
        pionJoueur.perdreVitalite( this.getForceDeFrappe() );
        System.out.println(
                this.getNom() + " riposte. " + pionJoueur.getNom() + " Vous perdez " + pionJoueur.getVitalite()+" point de vie !" );
        pionJoueur.attaquer( this );
    }
}
