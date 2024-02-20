package net.lecnam.battlefield.menneboo;
/*
 * Enumération qui indique les direction pour permetre le déplacement
 */
public enum Direction implements Choisissable {

    HAUT, DROITE, GAUCHE, BAS;

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return this.name();
    }
}
