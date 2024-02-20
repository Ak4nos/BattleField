package net.lecnam.battlefield.menneboo;

import java.util.Map;

/*
 * Classe qui cr��e le pion joueur et g�re ses actions
 */
public class PionJoueur extends Pion {

    private Menu menu = new Menu();
    private Map<String, Action> actions;

    public PionJoueur( int vitalite, int forceDeFrappe, int heritage, String nom, Case caseCourante ) {
        super( vitalite, forceDeFrappe, heritage, nom, caseCourante );
    }
/*
 * M�thode qui permet le d�placement des pions joueurs
 */
    public void deplacer( Direction direction ) {
        // TODO Auto-generated method stub
        Map<Direction, Case> voisins = this.getCaseCourante().getVoisins();
        if ( voisins.get( direction ) != null ) {
            this.getCaseCourante().supprimerPion( this );
            this.setCaseCourante( voisins.get( direction ) );
        }

        System.out.println(
                "Vous �tes dans la  case " + getCaseCourante().getLigne() + " " + getCaseCourante().getColonne() );
        // agir();
    }    
/*
 * M�thode qui g�re l'attaque entre les pions
 */
    @Override
    public void attaquer( Pion pionAattaquer ) {
        // TODO Auto-generated method stub
        if ( this.estVivant() ) {
            pionAattaquer.perdreVitalite( this.getForceDeFrappe() );
            System.out.println( pionAattaquer.getNom() + " est attaqu�;  Sa Vie = " + pionAattaquer.getVitalite() );
            this.mortMechant( pionAattaquer );
        } else {
            System.out.println( this.getNom() + " est mort " );
            this.getCaseCourante().supprimerPion( this );
            pionAattaquer.gagnerVitalite( this.getHeritage() );
        }

    }

/*
 * M�thode qui test si le m�chant est mort, si non, permet l'attaque du pion m�chant.
 */
    public void mortMechant( Pion mechant ) {
        if ( !mechant.estVivant() ) {
            System.out.println( mechant.getNom() + "est mort" );
            this.gagnerVitalite( mechant.getHeritage() );
            this.getCaseCourante().supprimerPion( mechant );
        } else {
            System.out.println( mechant.getNom() + " est encore en vie " + mechant.getVitalite() );
            mechant.attaquer( this );
        }
    }

}
