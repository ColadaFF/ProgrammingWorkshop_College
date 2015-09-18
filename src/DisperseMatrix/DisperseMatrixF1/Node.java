package DisperseMatrix.DisperseMatrixF1;

/**
 * Created by cs2kn on 17/09/2015.
 */
public class Node {
    private int row, column, data;
    private Node next, nextRow, nextColumn;

    public Node(int row, int column, int data) {
        this.row = row;
        this.column = column;
        this.data = data;
        this.nextRow = null;
        this.nextColumn = null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNextRow() {
        return nextRow;
    }

    public void setNextRow(Node nextRow) {
        this.nextRow = nextRow;
    }

    public Node getNextColumn() {
        return nextColumn;
    }

    public void setNextColumn(Node nextColumn) {
        this.nextColumn = nextColumn;
    }
}
