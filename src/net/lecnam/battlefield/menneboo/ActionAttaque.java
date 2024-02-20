package net.lecnam.battlefield.menneboo;

import java.util.ArrayList;
import java.util.List;

/*
 * Classe qui permet l'action d'attaquer
 */
public class ActionAttaque implements Action{

	private Menu menu = new Menu();

    @Override
    public void executePar( Player player ) {
        // TODO Auto-generated method stub
        List<Pion> pions = player.getPionCourant().getCaseCourante().getPions();
        List<Pion> pionAattaques = new ArrayList<Pion>();
        for ( Pion pion : pions ) {
            if ( pion instanceof PionMechant ) {
                pionAattaques.add( pion );
            }
        }
        Pion pionAattaque = menu.choose( player, pionAattaques, "Choisis le pion à attaquer" );
        player.getPionCourant().attaquer( pionAattaque );
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return " -Me battre !";
    }

    @Override
    public boolean estPossible( Player player ) {
        // TODO Auto-generated method stub
        List<Pion> pions = player.getPionCourant().getCaseCourante().getPions();
        List<Pion> pionAattaques = new ArrayList<Pion>();

        for ( Pion pion : pions ) {
            if ( pion instanceof PionMechant ) {
                pionAattaques.add( pion );
            }
        }
        for ( Pion pionAattaque : pionAattaques ) {
            if ( pionAattaque.estVivant()
                    && !( pionAattaque instanceof PionJoueur ) && player.getPionCourant().estVivant() )
                return true;
        }
        return false;
    }

}
