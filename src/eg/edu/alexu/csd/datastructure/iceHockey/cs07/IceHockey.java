package eg.edu.alexu.csd.datastructure.iceHockey.cs07;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class IceHockey implements IPlayersFinder {

	private char[][] twoDimPhoto;
	private boolean[][] visitedCells;
	private int numOfRows;
	private int numOfColumns;
	private int count;
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	/**
	 * convert giving one dimension array into two dimension array
	 * 
	 * @param oneDimArray
	 *            the given array
	 */
	public void convertTotwoDimArray(String[] oneDimArray) {

		numOfRows = oneDimArray.length;
		numOfColumns = oneDimArray[0].length();
		twoDimPhoto = new char[numOfRows][numOfColumns];
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {

				twoDimPhoto[i][j] = oneDimArray[i].charAt(j);
			}
		}
	}

	public void initializetheVisitedArray() {

		visitedCells = new boolean[numOfRows][numOfColumns];

	}

	public void recursion(int teamNumber, int i, int j) {

		if (i > numOfRows - 1 || i < 0 || j < 0 || j > numOfColumns - 1) {
			return;
		} else if (visitedCells[i][j] != false || Character.getNumericValue(twoDimPhoto[i][j]) != teamNumber) {
			return;
		} else {
			count++;
			visitedCells[i][j] = true;
			if (i < y1) {
				y1 = i;
			}
			if (j < x1) {
				x1 = j;
			}
			if (i > y2) {
				y2 = i;
			}
			if (j > x2) {
				x2 = j;
			}
			recursion(teamNumber, i, j + 1);
			recursion(teamNumber, i + 1, j);
			recursion(teamNumber, i - 1, j);
			recursion(teamNumber, i, j - 1);
		}
	}

	public boolean playerOrNot(int counter, int threshold) {

		final int v = 4;
		int areaOfPlayer = counter * v;
		if (areaOfPlayer >= threshold) {
			return true;
		} else {
			return false;
		}
	}

	public Point findingCenter(int x, int y) {

		int centerX = x + x2 + 1;
		int centerY = y + y2 + 1;
		return new Point(centerX, centerY);
	}

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {

		numOfRows = 0;
		numOfColumns = 0;
		count = 0;
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;

		ArrayList<Point> centers = new ArrayList<Point>();
		convertTotwoDimArray(photo);
		initializetheVisitedArray();
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				if (Character.getNumericValue(twoDimPhoto[i][j]) == team && visitedCells[i][j] == false) {
					x1 = j;
					y1 = i;
					x2 = 0;
					y2 = 0;
					count = 0;
					
					recursion(team, y1, x1);
					if (playerOrNot(count, threshold)) {
						Point centerPoint = findingCenter(x1, y1);
						centers.add(centerPoint);
					}
				}
			}
		}

		Point[] allCenters = new Point[centers.size()];
		for (int i = 0; i < allCenters.length; i++) {
		
			allCenters[i] = centers.get(i);
		}

		Arrays.sort(allCenters, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				int result = Integer.compare((int) a.getX(), (int) b.getX());
				if (result == 0) {
					result = Integer.compare((int) a.getY(), (int) b.getY());
				}
				return result;
			}
		});
		return allCenters;
	}

	public static void main(String[] args) {

		IceHockey extractPosition = new IceHockey();
		String[] photo = { "A666FGH6H" 
				         , "L6J66KMNL" ,
				           "PN66BV6KL" ,
				           "G66WLK66B"};
		Point[] PlayersLocation = extractPosition.findPlayers(photo, 6, 4);
		for (int i = 0; i < PlayersLocation.length; i++) {
			System.out.println(PlayersLocation[i]);
		}
	}
}