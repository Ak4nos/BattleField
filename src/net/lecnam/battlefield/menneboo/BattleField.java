package net.lecnam.battlefield.menneboo;

import java.util.Iterator;
import java.util.List;

/*
 * Classe qui permet de gérer le jeu sur le champ de bataille / battle field
 */
public class BattleField {

	 private Grille            grille;
	    private Player            player;
	    private List<PionJoueur>  gentils;
	    private List<PionMechant> mechants;
	    private Displayer         displayer = new Displayer();

	    public BattleField( Player player, Grille grille, List<PionJoueur> gentils, List<PionMechant> mechants ) {
	        this.grille = grille;
	        this.player = player;
	        this.gentils = gentils;
	        this.mechants = mechants;
	    }

	    public void play() {
	        while ( !this.gentils.isEmpty() ) {
	            this.grille.afficher();
	            this.player.agir();
	            actualiserPionsMechants();
	            if ( this.mechants.isEmpty() ) {
	                displayer.finDeJeuSuiteAMortMechant();
	                break;
	            }
	        }
	        if ( this.gentils.isEmpty() ) {
	            displayer.gameOver();
	        }

	    }

	    public void actualiserPionsMechants() {
	        for ( Iterator<PionMechant> iterator = mechants.iterator(); iterator.hasNext(); ) {
	            PionMechant mechant = (PionMechant) iterator.next();
	            if ( !mechant.estVivant() ) {
	                iterator.remove();
	            }

	        }
	    }

	}
