package com.pucbol.labs;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame implements ApplicationListener {
	
	private Texture texture;
	private SpriteBatch batch;
	
	int startX = 100;
	int startY = 380;
	
	int touchedX = 100;
	int touchedY = 380;
	
	boolean	isFirstTime = true;
	
	static int SPEED = 5;
	static int SPRITE_TOP = 0;
	static int FRAME_COUNT = 11;
	static int FRAME_WIDTH = 40;
	static int FRAME_HEIGHT = 37;
	static int FRAME_INTERVAL = 5;
	
	int currentIteration = 0;
	int currentFrame = 0;
	
	
	public void create() {
		texture = new Texture(Gdx.files.internal("supermario.png"));
		batch = new SpriteBatch();
	}

	public void dispose() {
		// TODO Auto-generated method stub
	}

	public void pause() {
		// TODO Auto-generated method stub
	}

	public void render() {
		
		currentIteration = (currentIteration + 1) % FRAME_INTERVAL;
		if(currentIteration == 0) currentFrame = (currentFrame + 1) % FRAME_COUNT;
				
		int frameLeft = currentFrame * FRAME_WIDTH;				
		
		if(Gdx.input.isTouched()){  
            touchedX = Gdx.input.getX() - FRAME_WIDTH / 2;  
            touchedY = Gdx.graphics.getHeight() - Gdx.input.getY() - FRAME_HEIGHT / 2;  
            //do something with the input!  
       }	
		
		int differenceX = Math.abs(touchedX - startX);
		int differenceY = Math.abs(touchedY - startY);
		
		double stepX = 0;
		double stepY = 0;
		
		if(differenceX + differenceY > 0) {
			stepX = (double)differenceX / (differenceX + differenceY) * SPEED;
			stepY = (double)differenceY / (differenceX + differenceY) * SPEED;
		}		
		
		boolean flipX = (touchedX < startX);
		
		if(touchedX > startX)
			startX += Math.min(differenceX, stepX);
		else if(touchedX < startX)
			startX -= Math.min(differenceX, stepX);
		
		if(touchedY > startY)
			startY += Math.min(differenceY, stepY);
		else if(touchedY < startY)
			startY -= Math.min(differenceY, stepY);
		
		
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		batch.begin();		
		batch.draw(texture, startX,startY, FRAME_WIDTH, FRAME_HEIGHT, frameLeft,SPRITE_TOP, FRAME_WIDTH, FRAME_HEIGHT, flipX, false);
		batch.end();
		
	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}

	public void resume() {
		// TODO Auto-generated method stub
	}
}
