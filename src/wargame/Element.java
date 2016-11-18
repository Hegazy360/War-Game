package wargame;

import java.awt.Color;

public class Element implements IConfig{
	private Position position;
	Color CouleurElm =Color.white;

	Element(Position position) {
	}
	
	public String toString(){
		return this.getClass().getName();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
