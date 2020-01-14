package com.mmg.game.stoneage.interfaces;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public interface IPlayer {

	void setName(String name);
	void setImage(Image image);
	Image getImage();
	void moveForward(int stepsNumber);
	void moveBack(int stepsNumber);
	void setPosition(Point newPosition);
	Point getPosition();
}
