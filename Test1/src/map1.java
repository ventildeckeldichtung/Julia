import processing.core.PApplet;
public class map1 extends PApplet {

	public void settings() {
		size(400,400);
	}
	public static void maid(String args[]) {
		PApplet.main("map1");
	}
	public void setup() {
		  size(200, 200);
		  background(255);
		  smooth();
		  line(0, 0, 200, 0); // draw axes
		  line(0, 0, 0, 200);
		  
		  pushMatrix();
		  fill(255, 0, 0); // red square
		  rotate(radians(30));
		  translate(70, 70);
		 
		  rect(0, 0, 20, 20);
		  popMatrix();

		  pushMatrix();
		  fill(255); // white square
		  translate(70, 70);
		  rotate(radians(30));
		
		  rect(0, 0, 20, 20);
		  popMatrix();
	}
	public void draw() {
		rect(100,100,50,50);
	}
}
