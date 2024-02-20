package net.lecnam.battlefield.menneboo;
/*
 * Interface pour permettre les actions
 */
public interface Action extends Choisissable {

	 void executePar( Player player );

	    boolean estPossible( Player player );
}
