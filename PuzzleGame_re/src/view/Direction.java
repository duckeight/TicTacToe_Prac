package view;

public enum Direction {
	North(-1, 0), South(1, 0), West(0, -1), East(0, 1);
	private int rowDelta, colDelta;
	
	private Direction(int rowDelta, int colDelta) {
		this.rowDelta = rowDelta;
		this.colDelta = colDelta;
	}

	public int getRowDelta() {
		return rowDelta;
	}

	public int getColDelta() {
		return colDelta;
	}
}
