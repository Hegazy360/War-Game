package wargame;

public class Monstres extends Soldat {
	private TypesM type;
	Monstres(Position position) {
		super(position);
		type = TypesM.getTypeMAlea();
		typeSoldat = type.name();
		points = type.getPoints();
		portee = type.getPortee();
		tir = type.getTir();
		puissance = type.getPuissance();
		CouleurElm = COULEUR_MONSTRES ;
	}


}
