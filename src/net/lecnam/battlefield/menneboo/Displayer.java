package net.lecnam.battlefield.menneboo;
/*
 * Classe qui affiche les informations lors du jeu
 */
public class Displayer {
	
	public void attaqueMechant( String nom ) {
        System.out.println( "-" + nom + " riposte" );
    }

    public void attaqueJoueur( String attaquant, String attaque ) {
        System.out.println( attaquant + " attaque " + attaque );
    }

    public void afficheAttributJoueur( String nom, int vitatlite, int forceFrappe, int heritage ) {
        System.out.println( "- Points de Vie : " + vitatlite + ", Force d'attaque : " + forceFrappe + ", Point d'héritage : " + heritage );
    }

    /**
     * 
     */
    public void finDeJeuSuiteAMortMechant() {
        System.out.println( "- Tous les ennemis sont morts. Vous avez gagné !" );
    }

    /**
     * 
     *
     */
    public void mortMechant( String name ) {
        System.out.println( "-" + name + " est mort" );
    }

    public void gameOver() {
        // TODO Auto-generated method stub
        System.out.println( "- Tous les gentils sont morts. GAME OVER" );
    }

}
