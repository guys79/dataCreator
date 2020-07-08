import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        int numOfHours = 12;
        int numOfDays = 10;
        int simulationLengthInSeconds = numOfHours * 3600;
        int numOfCustomerInHour = 10;
        int numberOfManicureUnit = 3;
        int numberOfPedicureUnits = 3;
        int numberOfTanUnit = 3;
        for (int i = 0; i < numOfDays; i++) {
            Simulation simulation = new Simulation(simulationLengthInSeconds, numOfCustomerInHour, numberOfManicureUnit, numberOfPedicureUnits, numberOfTanUnit);
            Set<Customer> customers = simulation.runSimulation();

            double sum = 0;
            String toPrint = "Id,ArrivalTIme,Manicure,Pedicure,Tan,timeSpentInQueue\n";
            String line;
            for (Customer customer : customers) {
                //if(customer.isTan() || customer.isPedicure() || customer.isManicure())
                //     System.out.println("fuck "+customer.getId());
                //Id,ArrivalTIme,Manicure,Pedicure,Tan,timeSpentInQueue
                line = String.format("%d,%d,%s,%s,%s,%s\n", customer.getId(), customer.getArrivalTime(), customer.getInitManicure()
                        , customer.getInitPedicure(), customer.getInitTan(), customer.getTimeSpentInQueueInSeconds());
                toPrint += line;
                System.out.println(line);
                //System.out.println("customer "+customer.getId()+" waited in line for "+customer.getTimeSpentInQueueInSeconds()+" second");
                sum += customer.getTimeSpentInQueueInSeconds();
            }
            System.out.println("Total number of customers - " + customers.size());
            System.out.println("Average time wait - " + (sum / customers.size()));

            FileWriter myWriter = null;
            try {
                myWriter = new FileWriter("data_"+i+".csv");
                myWriter.write(toPrint);
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}
