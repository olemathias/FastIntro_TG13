package net.msbone.fastIntro;

import org.newdawn.slick.*;

import java.awt.Font;
import java.util.Random;

public class Intro extends BasicGame
{	
  public Intro()
  {
     super("Nerdvana INTRO");
  }
 
  public Image bg;
  public Image goit;
  public Image woman;
  public Image machine;
  
  public float scale = 2;
  public float bgX = 0;
  public float bgY = 0;
  
  public float gjeitPosX;
  public float gjeitPosY;
  
  public int counter = - 100;
private boolean envolved;
  
  @Override
  public void init(GameContainer gc) throws SlickException
  {
	  Sound fx = new Sound("res/lyd.wav");
	  fx.play(2.0f, 0.5f);
	  bg = new Image("res/bg.png");
	  goit = new Image("res/gjeit.png");
	  woman = new Image("res/something.png");
	  machine = new Image("res/computer.png");
	  
	  gjeitPosX = bgX;
	  gjeitPosY = bgY + 700;
  }
 
  @Override
  public void update(GameContainer gc, int delta) throws SlickException
  {  

	 counter += 0.1 * delta;
	  
	  if(counter < 1000 && counter > 100) {
		  if(bgY >= -600) {
			  bgY -= 0.1 * delta;
			  gjeitPosX = bgX;
			  gjeitPosY = bgY + 700;
		  }  
	  }
	  if(counter < 1500 && counter > 900) {
		  bgX -= 0.1  * delta;;
		  gjeitPosX = bgX;
		  gjeitPosY = bgY + 700;
	  }
	  if(counter < 1350 && counter > 1300) {
		  goit = new Image("res/gjeit_flip.png");
	  }
	  if(counter < 3300 && counter > 1360) {
		  gjeitPosX += 0.1 * delta;
	  }
	  if(counter < 3350+500 && counter > 3300+500) {
		  goit = new Image("res/gjeit.png");
		  //Zoom in on the face of the gjeit
		  scale = 7;
		  //Set the camara to his/her face
		  bgX = -50;
		  bgY = -50;
		  gjeitPosX = -50;
		  gjeitPosY = -50;
	  }
	  if(counter < 4200+500 && counter > 3350+500) { 
		  if(envolved) {
			  envolved = false;
			  goit = new Image("res/gjeit.png");
		  }
		  else {
			  envolved = true;
			  goit = new Image("res/gjeit_new.png");
		  }
	  }
	  if(counter < 4250+500 && counter > 4200+500) {
		  goit = new Image("res/gjeit_evil.png");
	  }
	  if(counter < 4500+500 && counter > 4400+500) { 
		  goit = new Image("res/gjeit_evil.png");
		  scale = 2;
		  bgX = -500;
		  gjeitPosX = 600;
		  gjeitPosY = 600;
		  bgY = -600;
	  }
	  if(counter < 4700+500 && counter > 4500+500) { 
		  gjeitPosX -= 1 * delta;
	  }
	  
	  if(counter < 6000+500 && counter > 4700+500) { 
		  gc.exit();
		  bgX = 0;
		  gjeitPosX = 600;
		  gjeitPosY = 0;
		  bgY = 0; 
	  }
	  
	  
	  System.out.println(counter);
  }
  
  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException
  {
	  Random random = new Random();
	  gc.setShowFPS(false);
	  
	  //Render the background
	  bg.draw(bgX, bgY, scale);
	  
	  //Render the rest
	  goit.draw(gjeitPosX + random.nextInt(5), gjeitPosY + random.nextInt(5), (float) (scale*0.5));
	  
	  if(counter < 3000) {
		  
	  woman.draw(bgX + 200 + random.nextInt(15), bgY + random.nextInt(15), (float) (scale*0.5));
	  }
	  if(counter < 3800 && counter > 3200) {
		  //Show the evil machine
		  random.nextInt(50);
		  machine.draw(random.nextInt(20), random.nextInt(20));
	  }
	  
	  //Render the text
	  TrueTypeFont font;
	  Font awtFont = new Font("Century Schoolbook", Font.PLAIN, 30);
	  font = new TrueTypeFont(awtFont, true);
	  
	  g.setColor(Color.red);
	  g.setFont(font);
	  
	  if(counter < 100 && counter > 0) {
	  g.drawString("Nerdvana PRESENTS", 10, 10);
	  }
	  if(counter < 250 && counter > 100) {
		  g.drawString("A fast intro", 10, 10);
		  g.drawString("Created by", 10, 50);
		  }
	  if(counter < 400 && counter > 300) {
		  g.drawString("Graphics:", 10, 10);
		  g.drawString("Anda:", 10, 50);
		  }
	  if(counter < 500 && counter > 400) {
		  g.drawString("Vestrevekk ", 10, 25);
		  }
	  if(counter < 600 && counter > 500) {
		  g.drawString("Code:", 10, 10);
		  g.drawString("MSbone ", 10, 50);
		  }
	  if(counter < 700 && counter > 600) {
		  g.drawString("Pyrofy ", 10, 25);
		  }
	  if(counter < 1000 && counter > 750) {
		  Font bigFont = new Font("Century Schoolbook", Font.PLAIN, 45);
		  font = new TrueTypeFont(bigFont, true);
		  
		  g.setColor(Color.green);
		  g.setFont(font);
		  g.drawString("The evil computer", 50, 50);
		  }  
  }
 
  public static void main(String[] args) throws SlickException
  {
     AppGameContainer app = new AppGameContainer(new Intro());
 
     app.setDisplayMode(1280, 720, true);
     app.start();
  }
}