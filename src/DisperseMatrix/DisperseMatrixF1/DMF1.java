package DisperseMatrix.DisperseMatrixF1;

/**
 * Created by cs2kn on 17/09/2015.
 */
public class DMF1 {
    private Node head;
    private int[][] matrix;
    private int rows, columns, highest;

    public DMF1(int[][] matrix) {
        this.matrix = matrix;
        this.head = null;

        this.rows = matrix.length;
        this.columns = matrix[0].length;

        this.highest = Math.max(rows, columns);
        generateHeaders();
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private void generateHeaders() {
        Node n = new Node(rows, columns, 0);
        head = n;
        Node q = head;
        int rowsCounter = 0, columnsCounter = 0;

        while(rowsCounter != highest){
            Node p = new Node(rowsCounter, columnsCounter, 0);
            while (q.getNext() != head){

            }
        }
    }
}
