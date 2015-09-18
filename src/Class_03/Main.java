package Class_03;

/**
 * Created by Force on 8/18/2015.
 */
public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker("Pedro Perez", 19, 50000, 20.0);
        worker.print();
        System.out.println("Salary: " + worker.getSalary());
    }
}
