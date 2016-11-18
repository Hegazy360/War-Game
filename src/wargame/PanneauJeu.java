package wargame;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PanneauJeu extends JPanel implements IConfig {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Carte carte ;	


public PanneauJeu(){
	
	carte = new Carte();
}
public Carte getCarte() {
	return carte;
}
public void paintComponent(Graphics g){
	super.paintComponent(g);
	carte.toutDessiner(g);
}
}
