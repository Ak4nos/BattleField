package net.lecnam.battlefield.menneboo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*
 * Classe qui permet le déplacement des pions, définit qui exécute et si cela est possible 
 */
public class ActionDeplacement implements Action {

    protected String name;
    private Menu     menu = new Menu();
/*
 * Méthode qui va proposer une direction au joueur en fonction de la configuration de la case
 */
    private List<Direction> getCaseCouranteVoisinsDirections( Pion pion ) {
        Map<Direction, Case> voisins = pion.getCaseCourante().getVoisins();
        Iterable<Direction> k = voisins.keySet();
        List<Direction> directions = new ArrayList<Direction>();
        for ( Direction direction : k )
            directions.add( direction );
        return directions;
    }

    @Override
    public void executePar( Player player ) {
        // TODO Auto-generated method stub
        List<Direction> directions = getCaseCouranteVoisinsDirections( player.getPionCourant() );
        if ( !directions.isEmpty() ) {
            Direction directionChoisi = menu.choose( player, directions, "Quel direction veux tu prendre ?" );
            player.getPionCourant().deplacer( directionChoisi );
            player.getGrille().placer( player.getPionCourant().getCaseCourante().getLigne(),
                    player.getPionCourant().getCaseCourante().getColonne(), player.getPionCourant() );
        }
    }

    public boolean estPossible( Player player ) {
        boolean res = true;
        List<Pion> pions = player.getPionCourant().getCaseCourante().getPions();
        for ( Pion pion : pions ) {
            if ( pion instanceof PionMechant && pion.estVivant() ) {
                res = false;
                break;
            } else {
                res = true;
            }
        }

        return res;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return " -Me déplacer";
    }

}
