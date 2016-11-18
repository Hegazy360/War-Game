package wargame;

abstract public class Soldat extends Element implements ISoldat {
Soldat(Position position) {
		super(position);
	}
public static int Tour = 1;
protected String typeSoldat;
protected int points,portee,tir,puissance;

@Override
public int getPoints() {
	return this.points;
}

@Override
public int getPortee() {
	return this.portee;
}
@Override
public int getTir() {
	return this.tir;
}
@Override
public int getPuissance() {
	return this.puissance;
}
@Override
public int getTour() {
	return Tour;
}
@Override
public void joueTour(int tour) {
	if(tour==1){
		Tour = tour+1;
	}
	else {
		Tour=tour-1;
	}
}
@Override
public void combat(Soldat soldat) {
	int hitPoints = (int) Math.floor(Math.random() * this.puissance+1);
	int arrowPoints = (int) Math.floor(Math.random() * this.tir+1);
	//combat corps-a-corps
	if(this.getPosition().estVoisine(soldat.getPosition())){
		soldat.points -= hitPoints;
	}
	//combat a distance
	else {
		soldat.points -= arrowPoints;
	}

}
@Override
public void seDeplace(Position newPos) {
	this.setPosition(newPos);
}
public String toString(){
	return this.typeSoldat+": "+this.points + " points,"+this.tir+" tir,"+this.portee+" portee,"+this.puissance+" puissance.";
}
}
