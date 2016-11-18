package wargame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FentereJeu implements IConfig {
	private JFrame f;
	private PanneauJeu p;
	private JLabel elementInfo;
	private Position clickedSoldierPosition,secondClickPosition;
	private Soldat clickedSoldier;
	private boolean clicked = false;
	private Carte carte;

	public FentereJeu() {
		f = new JFrame("War Game");
		f.pack();
		Insets insets = f.getInsets();
		p = new PanneauJeu();
		carte = p.getCarte();
		elementInfo = new JLabel("Tesdddddddddt");
		f.setSize(new Dimension(insets.left + insets.right + 500, insets.top + insets.bottom + 500));
		f.setLayout(new FlowLayout());
		f.setContentPane(p);
		f.add(elementInfo);
		p.setBackground(Color.white);
		p.setPreferredSize(new Dimension(LARGEUR_CARTE * NB_PIX_CASE, HAUTEUR_CARTE * NB_PIX_CASE));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
		f.setResizable(false);
		p.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					Element currentElement = carte
							.getElement(new Position(e.getX() / NB_PIX_CASE, e.getY() / NB_PIX_CASE));
					if (!clicked) {
						if (currentElement instanceof Heros) {
							p.setCursor(new Cursor(Cursor.HAND_CURSOR));
						} else {
							p.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						}
					}

					if (currentElement instanceof Heros || currentElement instanceof Monstres) {
						elementInfo.setText(currentElement.toString());
					}
				} catch (Exception e2) {
					elementInfo.setText(null);
				}

				p.validate();

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println(e.getX() / NB_PIX_CASE + "," + e.getY() / NB_PIX_CASE);
			}
		});
		p.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println(e.getX()/NB_PIX_CASE+","+e.getY()/NB_PIX_CASE);
				if (!clicked) {
					try {
						Element currentElement = carte
								.getElement(new Position(e.getX() / NB_PIX_CASE, e.getY() / NB_PIX_CASE));
						if (currentElement instanceof Heros) {
							clickedSoldierPosition =new Position(e.getX()/NB_PIX_CASE,e.getY()/NB_PIX_CASE);
							p.setCursor(new Cursor(Cursor.HAND_CURSOR));
							clickedSoldier = (Soldat) currentElement;
							clicked = true;
						}

					} catch (Exception e2) {
						elementInfo.setText(null);
					}
				}
				else {
					secondClickPosition= new Position(e.getX()/NB_PIX_CASE,e.getY()/NB_PIX_CASE);
					if(carte.deplaceSoldat(secondClickPosition,clickedSoldier))
						carte.mort(clickedSoldierPosition);;
					p.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					clicked = false;
					p.repaint();
					p.validate();
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// System.out.println(e.getX()/NB_PIX_CASE+","+e.getY()/NB_PIX_CASE);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
	}

	public static void main(String[] args) {
		new FentereJeu();

		// Carte c = new Carte();

	}

}