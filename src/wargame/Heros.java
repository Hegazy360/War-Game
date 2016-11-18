package wargame;

public class Heros extends Soldat{
	protected TypesH type;

	Heros(Position position) {
		super(position);
		type = TypesH.getTypeHAlea();
		typeSoldat = type.name();
		points = type.getPoints();
		portee = type.getPortee();
		tir = type.getTir();
		puissance = type.getPuissance();
		CouleurElm = COULEUR_HEROS;
	}

	



}
