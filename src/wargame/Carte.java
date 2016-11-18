package wargame;

import java.awt.Color;
import java.awt.Graphics;

import wargame.Obstacle.TypeObstacle;

public class Carte implements ICarte, IConfig {
	private Element tabElement[][];

	public Carte() {
		tabElement = new Element[LARGEUR_CARTE][HAUTEUR_CARTE];

		// Creation des Heros
		for (int i = 0; i < NB_HEROS; i++) {
			int xH = (int) (Math.random() * LARGEUR_CARTE / 2);
			int yH = (int) (Math.random() * HAUTEUR_CARTE);

			if (tabElement[xH][yH] instanceof Heros) {
				while (tabElement[xH][yH] instanceof Heros) {

					xH = (int) (Math.random() * LARGEUR_CARTE / 2);
					yH = (int) (Math.random() * HAUTEUR_CARTE);
				}
			}
			tabElement[xH][yH] = new Heros(new Position(xH,yH));
		}
		// Creation Des Monstres
		for (int i = 0; i < NB_MONSTRES; i++) {
			int xM = (int) ((LARGEUR_CARTE / 2 + 1) + Math.random() * (LARGEUR_CARTE - (LARGEUR_CARTE / 2 + 1)));
			int yM = (int) (Math.random() * HAUTEUR_CARTE);

			if (tabElement[xM][yM] instanceof Monstres) {
				while (tabElement[xM][yM] instanceof Monstres) {
					xM = (int) ((LARGEUR_CARTE / 2 + 1) + Math.random() * (LARGEUR_CARTE - (LARGEUR_CARTE / 2 + 1)));
					yM = (int) (Math.random() * HAUTEUR_CARTE);
				}
			}

			tabElement[xM][yM] = new Monstres(new Position(xM,yM));
			
		}
		// Creations Obstacles
		for (int i = 0; i < NB_OBSTACLES; i++) {

			int xO = (int) (Math.random() * LARGEUR_CARTE);
			int yO = (int) (Math.random() * HAUTEUR_CARTE);

			if (tabElement[xO][yO] instanceof Monstres || tabElement[xO][yO] instanceof Heros) {
				while (tabElement[xO][yO] instanceof Monstres || tabElement[xO][yO] instanceof Heros) {

					xO = (int) (Math.random() * LARGEUR_CARTE);
					yO = (int) (Math.random() * HAUTEUR_CARTE);
				}
			}
			TypeObstacle type = TypeObstacle.getObstacleAlea();
			tabElement[xO][yO] = new Obstacle(type, new Position(xO, yO));
		}
	}
	
	@Override
	public Element getElement(Position pos) {
		// TODO Stub de la méthode généré automatiquement
//		System.out.println(tabElement[pos.getX()][pos.getY()].toString());
		return tabElement[pos.getX()][pos.getY()];
	}

	@Override
	public Position trouvePositionVide() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	@Override
	public Position trouvePositionVide(Position pos) {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	@Override
	public Heros trouveHeros() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	@Override
	public Heros trouveHeros(Position pos) {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	@Override
	public boolean deplaceSoldat(Position pos, Soldat soldat) {
		// TODO Stub de la méthode généré automatiquement
		if(tabElement[pos.getX()][pos.getY()] == null){
			tabElement[pos.getX()][pos.getY()] = soldat;
			soldat.seDeplace(pos);
			return true;
		}
		return false;
	}

	@Override
	public void mort(Soldat perso) {
		// TODO Stub de la méthode généré automatiquement
		tabElement[perso.getPosition().getX()][perso.getPosition().getY()] = null;
	}
	@Override
	public void mort(Position pos){
		tabElement[pos.getX()][pos.getY()] = null;
	}
	@Override
	public boolean actionHeros(Position clickedSoldierPosition, Position secondClickPosition) {
		
		return false;
	}

	@Override
	public void jouerSoldats(PanneauJeu pj) {
		// TODO Stub de la méthode généré automatiquement

	}

	@Override
	public void toutDessiner(Graphics g) {

		// affichage de la Carte
		System.out.println("Refreshed");
		for (int k = 0; k < LARGEUR_CARTE; k++) {
			for (int l = 0; l < HAUTEUR_CARTE; l++) {

				if (tabElement[k][l] instanceof Heros) {
					g.setColor(COULEUR_HEROS);
					g.fillRect(k * NB_PIX_CASE, l * NB_PIX_CASE, NB_PIX_CASE, NB_PIX_CASE);
				}

				if (tabElement[k][l] instanceof Monstres) {
					g.setColor(COULEUR_MONSTRES);
					g.fillRect(k * NB_PIX_CASE, l * NB_PIX_CASE, NB_PIX_CASE, NB_PIX_CASE);
				}

				if (tabElement[k][l] instanceof Obstacle) {

					if (tabElement[k][l].CouleurElm == COULEUR_EAU) {
//						System.out.println(tabElement[k][l].CouleurElm);
						g.setColor(COULEUR_EAU);
					}

					if (tabElement[k][l].CouleurElm == COULEUR_FORET) {
//						System.out.println(tabElement[k][l].CouleurElm);
						g.setColor(COULEUR_FORET);
					}

					if (tabElement[k][l].CouleurElm == COULEUR_ROCHER) {
//						System.out.println(tabElement[k][l].CouleurElm);
						g.setColor(COULEUR_ROCHER);
					}

					g.fillRect(k * NB_PIX_CASE, l * NB_PIX_CASE, NB_PIX_CASE, NB_PIX_CASE);
				}

			}

		}
		for (int j = 0; j < LARGEUR_CARTE; j++) {

			g.setColor(Color.BLACK);
			g.drawLine(0, j * NB_PIX_CASE, LARGEUR_CARTE * NB_PIX_CASE, j * NB_PIX_CASE);
			g.drawLine(j * NB_PIX_CASE, 0, j * NB_PIX_CASE, HAUTEUR_CARTE * NB_PIX_CASE);

		}
	}

}
