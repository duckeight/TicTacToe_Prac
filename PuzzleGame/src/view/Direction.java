package view;

public enum Direction {
	east(0, 1), west(0, -1), south(1, 0), north(-1, 0);
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
