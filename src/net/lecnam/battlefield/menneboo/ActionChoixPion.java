package net.lecnam.battlefield.menneboo;

import java.util.List;

/*
 * Classe qui permet de choisir le pion à jouer, définit qui exécute et si cela est possible
 */
public class ActionChoixPion implements Action {
	private Menu menu = new Menu();

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return " -Choisir un autre pion";
    }

    @Override
    public void executePar( Player player ) {
        // TODO Auto-generated method stub
        List<PionJoueur> pions = player.getPionJoueurs();
        PionJoueur pionJoueur = menu.choose( player, pions, "Choisissez un pion" );
        player.setPionCourant( pionJoueur );
        System.out.println( "pion " + player.getPionCourant().getNom() + " choisi" );
    }

    @Override
    public boolean estPossible( Player player ) {
        return true;
    }

}
