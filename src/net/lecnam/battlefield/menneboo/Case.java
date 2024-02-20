package net.lecnam.battlefield.menneboo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Classe pour la gestion des cases et place les listes de pions 
 */
public class Case {

	private List<Pion>           pions;
    private Map<Direction, Case> voisins;
    private String               nom;
    private int                  colonne;
    private int                  ligne;

    public Case( String nom ) {
        this.pions = new ArrayList<Pion>();
        this.voisins = new HashMap<Direction, Case>();
        this.nom = nom;
    }

    public Case( String nom, int ligne, int colonne ) {
        this.pions = new ArrayList<Pion>();
        this.voisins = new HashMap<Direction, Case>();
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public List<Pion> getPions() {
        return pions;
    }

    public void setMechants( List<Pion> pions ) {
        this.pions = pions;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public Map<Direction, Case> getVoisins() {
        return voisins;
    }

    public void setVoisins( Map<Direction, Case> voisins ) {
        this.voisins = voisins;
    }

    public void ajouterPion( Pion pion ) {
        pions.add( pion );
    }

    public void supprimerPion( Pion pion ) {
        pions.remove( pion );

    }

    public String afficher() {
        String res = " ";
        for ( Pion pion : pions ) {
            res += pion.getNom() + " , ";
        }
        return res;
    }

    public void ajouterVoisin( Direction direction, Case c ) {
        this.voisins.put( direction, c );
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne( int colonne ) {
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne( int ligne ) {
        this.ligne = ligne;
    }
}
