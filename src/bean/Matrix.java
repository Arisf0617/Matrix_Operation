package bean;

public class Matrix {
	
	private String matrix[][];//矩阵定义
    private int row;//行数
    private int line;//列数
    
    public String[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getLine() {
        return line;
    }
    public void setLine(int line) {
        this.line = line;
    }
}
