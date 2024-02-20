package net.lecnam.battlefield.menneboo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Class qui permet de proposer les action au joueur
 */
public class Player {
	private String              nom;
    private List<PionJoueur>    pionJoueurs;
    private PionJoueur          pionCourant;
    private Map<String, Action> actions;
    Menu                        menu = new Menu();
    Grille                      grille;

    public Player( String nom, List<PionJoueur> joueurs, Grille grille ) {
        this.nom = nom;
        this.pionJoueurs = joueurs;
        this.grille = grille;
        this.actions = new HashMap<String, Action>();
        this.actions.put( "Attaque", new ActionAttaque() );
        this.actions.put( "Deplacement", new ActionDeplacement() );
        this.actions.put( "Choix", new ActionChoixPion() );
    }

    public List<Action> actionsPossible() {
        List<Action> possibles = new LinkedList<Action>();
        Set<Map.Entry<String, Action>> setAction = actions.entrySet();
        Iterator<Map.Entry<String, Action>> iterator = setAction.iterator();
        while ( iterator.hasNext() ) {
            Map.Entry<String, Action> action = iterator.next();
            if ( action.getValue().estPossible( this ) ) {
                possibles.add( action.getValue() );
            }
        }
        return possibles;
    }

    public void agir() {
        // TODO Auto-generated method stub
        if ( this.getPionCourant() == null ) {
            Action a = new ActionChoixPion();
            a.executePar( this );
        } else {
            List<Action> actions = this.actionsPossible();
            Action a = menu.choose( this, actions, "Que voulez-vous faire ?" );
            a.executePar( this );
            this.actualiserPionsJoueurs();
        }
    }

    public void actualiserPionsJoueurs() {
        for ( Iterator<PionJoueur> iterator = pionJoueurs.iterator(); iterator.hasNext(); ) {
            PionJoueur pionJoueur = (PionJoueur) iterator.next();
            if ( !pionJoueur.estVivant() ) {
                iterator.remove();
            }
        }
    }

    public List<PionJoueur> getPionJoueurs() {
        return pionJoueurs;
    }

    public void setPionJoueurs( List<PionJoueur> pionJoueurs ) {
        this.pionJoueurs = pionJoueurs;
    }

    public Map<String, Action> getActions() {
        return actions;
    }

    public void setActions( Map<String, Action> actions ) {
        this.actions = actions;
    }

    public PionJoueur getPionCourant() {
        return pionCourant;
    }

    public void setPionCourant( PionJoueur pionCourant ) {
        this.pionCourant = pionCourant;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille( Grille grille ) {
        this.grille = grille;
    }

}
