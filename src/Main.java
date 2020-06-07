import java.util.Set;

public class Main {
    public static void main(String[] args) {


        int numOfHours = 8;
        int simulationLengthInSeconds = numOfHours*3600;
        int numOfCustomerInHour = 10;
        int numberOfManicureUnit = 3;
        int numberOfPedicureUnits = 3;
        int numberOfTanUnit = 3;
        Simulation simulation = new Simulation(simulationLengthInSeconds,numOfCustomerInHour,numberOfManicureUnit,numberOfPedicureUnits,numberOfTanUnit);
        Set<Customer> customers = simulation.runSimulation();

        double sum = 0;
        for(Customer customer : customers)
        {
            //if(customer.isTan() || customer.isPedicure() || customer.isManicure())
           //     System.out.println("fuck "+customer.getId());
            System.out.println("customer "+customer.getId()+" waited in line for "+customer.getTimeSpentInQueueInSeconds()+" second");
            sum+=customer.getTimeSpentInQueueInSeconds();
        }
        System.out.println("Total number of customers - "+customers.size());
        System.out.println("Average time wait - "+(sum/customers.size()));


    }

}
