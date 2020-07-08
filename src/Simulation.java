import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

public class Simulation {
    int simulationLengthInSeconds;
    int numOfCustomerInHour;
    private Salon salon;

    public Simulation(int simulationLengthInSeconds, int numOfCustomerInHour,int numberOfManicureUnits, int numberOfPedicureUnits, int numberOfTanUnits) {
        this.simulationLengthInSeconds = simulationLengthInSeconds;
        this.numOfCustomerInHour = numOfCustomerInHour;
        this.salon = new Salon(numberOfManicureUnits,numberOfPedicureUnits,numberOfTanUnits);
    }

    public Set<Customer> runSimulation()
    {
        int numOfNewCustomers;
        Set<Customer> customers = new HashSet<>();
        Customer customer;
        int timePassed = 0;
        for(int second = 0;second<this.simulationLengthInSeconds;second++)
        {
            salon.passTime(1);
            timePassed++;
            numOfNewCustomers  = getPoisson(this.numOfCustomerInHour/3600.0);
            for(int j=0; j<numOfNewCustomers;j++)
            {
                customer = new Customer(timePassed);
                System.out.println(customer);
                customers.add(customer);
                salon.AddToQueue(customer);
            }

        }
        return customers;
    }

    private int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);

        return k - 1;
    }
}
