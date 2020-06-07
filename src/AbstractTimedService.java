import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTimedService {

    Set<TimedServiceUnit> units;

    public AbstractTimedService(int numOfUnits) {
        double maxTimeInSeconds = getMaxTime();
        double minTimeInSeconds = getMinTime();
        this.units = new HashSet<>();

        TimedServiceUnit timedServiceUnit;
        for(int i=0;i<numOfUnits;i++)
        {
            timedServiceUnit = new TimedServiceUnit(maxTimeInSeconds,minTimeInSeconds);
            this.units.add(timedServiceUnit);
        }
    }

    public int getNumberOfUnits()
    {
        return this.units.size();
    }

    protected abstract double getMinTime();
    protected abstract double getMaxTime();
    protected abstract void finishService(Customer customer);

    public String getServiceName() {
        Class<?> enclosingClass = getClass().getEnclosingClass();
        if (enclosingClass != null) {
            return enclosingClass.getName();
        }
        return getClass().getName();
    }

    public Set<Customer>  passTime(int timeInSeconds)
    {
        Set<Customer> finished = new HashSet<>();
        for(TimedServiceUnit unit : this.units)
        {
            Customer customer = unit.passTime(timeInSeconds);
            if(customer!=null) {
                finished.add(customer);
                finishService(customer);
            }

        }
        return finished;
    }

    public TimedServiceUnit getOccupied()
    {
        for(TimedServiceUnit unit : this.units)
        {
            if(!unit.isOccupied())
                return unit;
        }
        return null;
    }
}
