import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Customer {

    private boolean manicure;
    private boolean pedicure;
    private boolean tan;
    private boolean initManicure;
    private boolean initPedicure;
    private boolean initTan;
    private double timeSpentInQueueInSeconds;
    public static int numOfCustomers = 0;
    private int id;
    private int arrivalTime;

    public Customer(int arrivalTime) {
        this.timeSpentInQueueInSeconds = 0;
        numOfCustomers+=1;
        id = numOfCustomers;
        this.arrivalTime = arrivalTime;
        setParameters();
    }

    public int getArrivalTime() {
        return arrivalTime;
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

        this.initManicure = manicure;
        this.initPedicure = pedicure;
        this.initTan = tan;
    }
    public boolean isManicure() {
        return manicure;
    }

    public void setManicure(boolean manicure) {
        this.manicure = manicure;
    }

    public boolean getInitManicure() {
        return initManicure;
    }

    public boolean getInitPedicure() {
        return initPedicure;
    }

    public boolean getInitTan() {
        return initTan;
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
