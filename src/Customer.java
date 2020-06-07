import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Customer {

    private boolean manicure;
    private boolean pedicure;
    private boolean tan;
    private double timeSpentInQueueInSeconds;
    public static int numOfCustomers = 0;
    private int id;

    public Customer() {
        this.timeSpentInQueueInSeconds = 0;
        numOfCustomers+=1;
        id = numOfCustomers;
        setParameters();
    }

    public int getId() {
        return id;
    }

    private void setParameters()
    {
        double rand = Math.random();
        if(rand<0.5)
            this.manicure = true;
        else
            this.manicure = false;

        rand = Math.random();
        if(rand<0.3)
            this.pedicure = true;
        else
            this.pedicure = false;

        rand = Math.random();
        if(rand<0.2)
            this.tan = true;
        else
            this.tan = false;
    }
    public boolean isManicure() {
        return manicure;
    }

    public void setManicure(boolean manicure) {
        this.manicure = manicure;
    }

    public boolean isPedicure() {
        return pedicure;
    }

    public void setPedicure(boolean pedicure) {
        this.pedicure = pedicure;
    }

    public boolean isTan() {
        return tan;
    }

    public void setTan(boolean tan) {
        this.tan = tan;
    }

    public void addTimeInQueue(double timeInSeconds)
    {
        timeSpentInQueueInSeconds += timeInSeconds;
    }

    public double getTimeSpentInQueueInSeconds() {
        return timeSpentInQueueInSeconds;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "manicure=" + manicure +
                ", pedicure=" + pedicure +
                ", tan=" + tan +
                ", id=" + id +
                '}';
    }
}
