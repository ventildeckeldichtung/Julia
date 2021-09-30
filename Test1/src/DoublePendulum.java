package CodingChallenges;

import processing.core.PApplet;
import processing.core.PVector;

public class DoublePendulum extends PApplet{
	
	PVector base1 = new PVector(400,400);
	PVector pendulum1 = new PVector(400,400);
	PVector base2 = new PVector(400,400);
	PVector pendulum2 = new PVector(800,800);
	float angle1 = PI;
	float angle2 = 0;
	float accel1 = 0;
	float aVelocity1 = 0;
	float length1 = 200;
	float mass1=10;
	float accel2 = 0;
	float aVelocity2 = 0;
	float length2 = 200;
	float mass2=10;		
	float gravity=0.81f;	
	float damping = 0.98f;
	
	
	public void settings() {
		size(900,900);
	}
	public void setup() {
		
	}
	public void draw() {		
		
		aVelocity1+=accel1;
		aVelocity2+=accel2;
		angle1+=aVelocity1;		
		angle2+=aVelocity2;
		aVelocity1*=0.98;
		aVelocity2*=0.98;
		float num11 = -gravity*(2*mass1+mass2)*sin(angle1);
		float num12 = -mass2*gravity*sin(angle1-2*angle2);
		float num13 = -2*sin(angle1-angle2)*mass2*((aVelocity2*aVelocity2*length2)+(aVelocity1*aVelocity1*length1*cos(angle1-angle2)));
		float denom11 = length1*((2*mass1)+mass2-(mass2*cos((2*angle1)-(2*angle2))));
		accel1 = (num11+num12+num13)/denom11;
		
		float num21 = 2*sin(angle1-angle2)*(aVelocity1*aVelocity1*length1*(mass1+mass2));
		float num22 = gravity*(mass1+mass2)*cos(angle1);
		float num23 = aVelocity2*aVelocity2*length2*mass2*cos(angle1-angle2);
		float denom22 = length2*((2*mass1)+mass2-(mass2*cos((2*angle1)-(2*angle2))));
		accel2 = (num21+num22+num23)/denom22;
		
		base2=pendulum1;
		pendulum1.x = length1*sin(angle1)+base1.x;
		pendulum1.y = length1*cos(angle1)+base1.y;
		pendulum2.x = length2*sin(angle2)+base2.x;
		pendulum2.y = length2*cos(angle2)+base2.y;	
		
		background(1);
		strokeWeight(8);
		stroke(255);
		line(base1.x, base1.y, pendulum1.x, pendulum1.y);
		circle(pendulum1.x,pendulum1.y, 50);		
		line(base2.x, base2.y, pendulum2.x, pendulum2.y);
		circle(pendulum2.x,pendulum2.y, 50);
		System.out.println(angle1 + " " + angle2);
	}
	public static void main(String[] args) {
		PApplet.main(new String[] {"CodingChallenges.DoublePendulum"});
	}
}
