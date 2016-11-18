package wargame;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends Element implements IConfig {
	public enum TypeObstacle {
		ROCHER(COULEUR_ROCHER), FORET(COULEUR_FORET), EAU(COULEUR_EAU);
		private final Color COULEUR;

		TypeObstacle(Color couleur) {
			COULEUR = couleur;
		}

		public static TypeObstacle getObstacleAlea() {
			return values()[(int) (Math.random() * values().length)];
		}
	}

	private TypeObstacle TYPE;
	private Position pos;

	Obstacle(TypeObstacle type, Position pos) {
		super(pos);
		TYPE = type;
		this.pos = pos;
		CouleurElm = type.COULEUR;
	}

	
	
	public String toString() {
		return "" + TYPE;
	}
}