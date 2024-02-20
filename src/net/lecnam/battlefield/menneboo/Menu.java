package net.lecnam.battlefield.menneboo;

import java.util.List;

/*
 * Classe permettant au joueur de choisir une action.
 */
public class Menu {
    
	  public <T extends Choisissable> T choose( Player player, List<T> listeChoix, String message ) {
	        System.out.println( " " + message );
	        for ( int i = 0; i < listeChoix.size(); i++ ) {
	            System.out.println( i + " --> " + listeChoix.get( i ).getDescription() );
	        }
	        int choice = ScannerInt.readInt( listeChoix.size() );
	        return listeChoix.get( choice );
	    }
	}
