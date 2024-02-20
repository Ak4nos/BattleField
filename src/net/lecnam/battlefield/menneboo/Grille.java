package net.lecnam.battlefield.menneboo;
/*
 * Classe qui créée le plateau de jeu et place des cases
 */

import java.util.List;
import java.util.Random;

public class Grille {

	private int      lignes;
    private int      colonnes;
    private Case[][] cases;

    public Grille( int li, int col ) {
        this.lignes = li;
        this.colonnes = col;
        this.cases = new Case[lignes][colonnes];

        for ( int i = 0; i < this.cases.length; i++ ) {
            for ( int j = 0; j < this.cases[i].length; j++ ) {
                this.cases[i][j] = new Case( " ", i, j );
            }
        }
    }

    public int getLignes() {
        return lignes;
    }

    public void setLignes( int lignes ) {
        this.lignes = lignes;
    }

    public int getColonnes() {
        return colonnes;
    }

    public void setColonnes( int colonnes ) {
        this.colonnes = colonnes;
    }

    public Case[][] getCases() {
        return cases;
    }

    public void setCases( Case[][] cases ) {
        this.cases = cases;
    }

    public Case getCase( int c, int l ) {
        return this.cases[c][l];
    }

    public void placer( int l, int c, Pion p ) {
        this.cases[l][c].ajouterPion( p );
        p.setCaseCourante( this.cases[l][c] );
    }

    public void afficher() {
        System.out.println();
        for ( int i = 0; i < this.cases.length; i++ ) {
            for ( int j = 0; j < this.cases[i].length; j++ ) {
                System.out.print( " | " );
                System.out.print( ( cases[i][j] ).afficher() );
            }

            System.out.println( " | " );
        }
        System.out.println();
    }

    public void remplirGrille( List<Pion> pions ) {
        Random rnd = new Random();
        for ( Pion pion : pions ) {
            int l = rnd.nextInt( this.lignes );
            int c = rnd.nextInt( this.colonnes );
            this.placer( l, c, pion );
        }
    }
}
