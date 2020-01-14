package com.mmg.game.stoneage.logic;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

import com.mmg.game.stoneage.interfaces.IPlayer;

public class PlayerImpl implements IPlayer {

	private String _name;
	private Image _image;
	private Point _position;
	
	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setImage(Image image) {
		_image = image;
	}

	@Override
	public Image getImage() {
		return _image;
	}


	@Override
	public void moveForward(int stepsNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveBack(int stepsNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getPosition() {
		return _position;
	}

	@Override
	public void setPosition(Point newPosition) {
		_position = newPosition;
		
	}

}
