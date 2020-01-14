package com.mmg.game.stoneage.logic;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Point;

import com.mmg.game.stoneage.interfaces.IPlayer;
import com.mmg.game.stoneage.interfaces.IStoneAgeModel;

public class StoneAgeModelImpl implements IStoneAgeModel {

	private ArrayList<IPlayer> _playerList;
	private final ArrayList<Point> _fieldMap = new ArrayList<Point>();
	private Point initialPoint = new Point(8, 8);
	private static final int HORIZONTAL_STEP = 10;
	private static final int VERTICAL_STEP = 10;

	
	public StoneAgeModelImpl() {
		createFieldMap();
	}
	
	@Override
	public List<Point> getFieldMap() {
		return _fieldMap;
	}

	private void createFieldMap() {
		Point basePoint = new Point(initialPoint.x, initialPoint.y);
		for (int i = 0; i < 100; i++) {
			Point nextPoint = calculateNextPoint(i, basePoint);
			_fieldMap.add(nextPoint);
		}
	}

	private Point calculateNextPoint(int i, Point basePoint) {
		if(i == 0) {
			return basePoint;
		}else if(i > 0 && i <= 30) {
			basePoint.x = basePoint.x + HORIZONTAL_STEP;
			return basePoint;
		}else if(i > 30 && i <= 50) {
			
		}else if(i > 50 && i <= 80) {
			
		}else if(i > 80 && i < 100) {
			
		}else if(i >= 100) {
			System.err.println("fild scores are incorrect");
			return null;
		}
		System.err.println("index < 0");
		return null;
	}
	
	public ArrayList<IPlayer> getPlayerList(){
		return new ArrayList<IPlayer>(_playerList);
	}
	
	public void setPlayerList(ArrayList<IPlayer> playerList) {
		_playerList = new ArrayList<IPlayer>(playerList);
	}

}
