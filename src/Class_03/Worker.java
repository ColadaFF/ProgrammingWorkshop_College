package Class_03;

/**
 * Created by Force on 8/18/2015.
 */
public class Worker extends Person {
    private int hoursQuantity;
    private double hourPrice;
    private double salary;

    public Worker(String name, int age, int hoursQuantity, double hourPrice) {
        super(name, age);
        this.hoursQuantity = hoursQuantity;
        this.hourPrice = hourPrice;
    }

    public double getSalary() {
        salary = hoursQuantity * hourPrice;
        return salary;
    }

    @Override
    public void print(){
        super.print();
        System.out.println("Salary: " + getSalary());
    }
}
