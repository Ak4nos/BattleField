package net.lecnam.battlefield.menneboo;

import java.util.ArrayList;
import java.util.List;

/*
 * Classe qui permet de jouer au jeu
 */
public class Main {

	 public static void main( String[] args ) {
	        // TODO Auto-generated method stub
	        Grille grille = new Grille( 4, 4 );

	        PionJoueur j1 = new PionJoueur( 10, 4, 6, "ge1", null );
	        PionJoueur j2 = new PionJoueur( 4, 3, 6, "ge2", null );
	        PionJoueur j3 = new PionJoueur( 8, 7, 6, "ge3", null );

	        PionMechant m1 = new PionMechant( 8, 4, 2, "me1", null );
	        PionMechant m2 = new PionMechant( 6, 4, 3, "me2", null );
	        PionMechant m3 = new PionMechant( 3, 3, 1, "me3", null );

	        List<PionJoueur> pionsJoueurs = new ArrayList<PionJoueur>();
	        pionsJoueurs.add( j1 );
	        pionsJoueurs.add( j2 );
	        pionsJoueurs.add( j3 );

	        List<PionMechant> pionsMechants = new ArrayList<PionMechant>();
	        pionsMechants.add( m1 );
	        pionsMechants.add( m2 );
	        pionsMechants.add( m3 );

	        List<Pion> pions = new ArrayList<Pion>();
	        pions.addAll( pionsMechants );
	        pions.addAll( pionsJoueurs );
	        grille.remplirGrille( pions );

	       
	        for ( int i = 0; i < grille.getCases().length; i++ ) {
	            for ( int j = 0; j < grille.getCases()[i].length; j++ ) {
	                if ( i == 0 && j == 0 ) {
	                    grille.getCase( i, j ).ajouterVoisin( Direction.DROITE, grille.getCase( i, j + 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.BAS, grille.getCase( i + 1, j ) );
	                }
	                if ( i == 0 && j == grille.getCases()[i].length - 1 ) {
	                    grille.getCase( i, j ).ajouterVoisin( Direction.BAS, grille.getCase( i + 1, j ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.GAUCHE, grille.getCase( 0, j - 1 ) );

	                }
	                if ( i == grille.getCases().length - 1 && j == 0 ) {
	                    grille.getCase( i, j ).ajouterVoisin( Direction.DROITE, grille.getCase( i, j + 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.HAUT, grille.getCase( i - 1, j ) );
	                }
	                if ( i == grille.getCases().length - 1 && j == grille.getCases()[i].length - 1 ) {
	                    grille.getCase( i, j ).ajouterVoisin( Direction.GAUCHE, grille.getCase( i, j - 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.HAUT, grille.getCase( i - 1, j ) );
	                }

	                // 1er ligne
	                if ( i == 0 && j < grille.getCases()[i].length - 1 && j > 0 ) {
	                    grille.getCase( i, j ).ajouterVoisin( Direction.GAUCHE, grille.getCase( i, j - 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.DROITE, grille.getCase( i, j + 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.BAS, grille.getCase( i + 1, j ) );
	                }

	                // derniere ligne
	                if ( i == grille.getCases().length - 1 && j > 0 && j < grille.getCases()[i].length - 1 ) {
	                    grille.getCase( i, j ).ajouterVoisin( Direction.GAUCHE, grille.getCase( i, j - 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.DROITE, grille.getCase( i, j + 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.HAUT, grille.getCase( i - 1, j ) );
	                }

	                if ( i > 0 && j > 0 && j < grille.getCases()[i].length - 1 && i < grille.getCases().length - 1 ) {
	                    grille.getCase( i, j ).ajouterVoisin( Direction.GAUCHE, grille.getCase( i, j - 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.DROITE, grille.getCase( i, j + 1 ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.HAUT, grille.getCase( i - 1, j ) );
	                    grille.getCase( i, j ).ajouterVoisin( Direction.BAS, grille.getCase( i + 1, j ) );
	                }
	            }
	        }

	        Player player = new Player( "Joueur 1", pionsJoueurs, grille );
	        // player.setPionCourant( joueur );
	        BattleField bf = new BattleField( player, grille, pionsJoueurs, pionsMechants );
	        bf.play();

	    }
	}
