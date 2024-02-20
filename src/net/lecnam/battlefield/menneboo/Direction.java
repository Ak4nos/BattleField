package net.lecnam.battlefield.menneboo;
/*
 * Enum�ration qui indique les direction pour permetre le d�placement
 */
public enum Direction implements Choisissable {

    HAUT, DROITE, GAUCHE, BAS;

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return this.name();
    }
}
