import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TimedServiceUnit{

    private boolean occupied;
    private Customer inService;
    private double timeRemainingInSecond;
    private double maxTimeInSeconds;
    private double minTimeInSeconds;


    public TimedServiceUnit(double maxTimeInSeconds, double minTimeInSeconds) {
        this.maxTimeInSeconds = maxTimeInSeconds;
        this.minTimeInSeconds = minTimeInSeconds;
        occupied = false;
        this.inService = null;

    }

    private double setTreatmentTime(double minTimeInSeconds, double maxTimeInSeconds) {
        //Uniform distribution
        double length = maxTimeInSeconds - minTimeInSeconds;
        double rand = Math.random();
        return minTimeInSeconds + length*rand;
    }

    public boolean enterCustomer(Customer customer)
    {
        if(!occupied) {
            this.timeRemainingInSecond = setTreatmentTime(minTimeInSeconds,maxTimeInSeconds);
          //  System.out.println("customer "+customer.getId()+" is in");
            occupied = true;
            inService = customer;
            return true;
        }
        return false;

    }

    public void removeCustomer()
    {
       // if(occupied)
       //     System.out.println("customer "+this.inService.getId()+" is out");
        occupied  =false;

        this.inService = null;

    }

    public double getTimeRemainingInSecond() {
        return timeRemainingInSecond;
    }

    public void setTimeRemainingInSecond(double timeRemaningInSecond) {
        this.timeRemainingInSecond = timeRemaningInSecond;
    }
    public Customer passTime(int timeInSeconds)
    {
        this.timeRemainingInSecond -= timeInSeconds;
        if(timeRemainingInSecond<=0)
        {
            Customer customer = this.inService;
            removeCustomer();
            return customer;

        }
        return null;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
