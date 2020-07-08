import java.util.*;

public class Salon {

    private Manicure manicure;
    private Pedicure pedicure;
    private Tan tan;

    private ArrayList<Customer> manicureQueue;
    private ArrayList<Customer> pedicureQueue;
    private ArrayList<Customer> tanQueue;

    public Salon(int numberOfManicureUnits, int numberOfPedicureUnits, int numberOfTanUnits) {

        this.manicure = new Manicure(numberOfManicureUnits);
        this.pedicure = new Pedicure(numberOfPedicureUnits);
        this.tan = new Tan(numberOfTanUnits);
        this.manicureQueue = new ArrayList<>();
        this.pedicureQueue = new ArrayList<>();
        this.tanQueue = new ArrayList<>();
    }


    public void passTime(int timeInSeconds)
    {
        Set<Customer> finished = new HashSet<>();

        //Add customers who finished to queue
        finished.addAll(this.manicure.passTime(timeInSeconds));
        finished.addAll(this.pedicure.passTime(timeInSeconds));
        finished.addAll(this.tan.passTime(timeInSeconds));
        for(Customer customer : finished)
        {
            AddToQueue(customer);
        }

        //Update customer waiting time
        for(Customer customer : this.manicureQueue)
        {
            customer.addTimeInQueue(timeInSeconds);
        }
        for(Customer customer : this.pedicureQueue)
        {
            customer.addTimeInQueue(timeInSeconds);
        }
        for(Customer customer : this.tanQueue)
        {
            customer.addTimeInQueue(timeInSeconds);
        }

        //Add customers to services
        TimedServiceUnit unitToUse = this.manicure.getNotOccupied();
        while (unitToUse!=null && this.manicureQueue.size()>0)
        {
            unitToUse.enterCustomer(this.manicureQueue.get(0));
            this.manicureQueue.remove(0);
            unitToUse = this.manicure.getNotOccupied();
        }

        unitToUse = this.pedicure.getNotOccupied();
        while (unitToUse!=null && this.pedicureQueue.size()>0)
        {
            unitToUse.enterCustomer(this.pedicureQueue.get(0));
            this.pedicureQueue.remove(0);
            unitToUse = this.pedicure.getNotOccupied();
        }

        unitToUse = this.tan.getNotOccupied();
        while (unitToUse!=null && this.tanQueue.size()>0)
        {
            unitToUse.enterCustomer(this.tanQueue.get(0));
            this.tanQueue.remove(0);
            unitToUse = this.tan.getNotOccupied();
        }
    }

    public void AddToQueue(Customer customer) {
        int sizeManicure = this.manicureQueue.size();
        int sizePedicure = this.pedicureQueue.size();
        int sizeTan = this.tanQueue.size();

        int min = Integer.MAX_VALUE;
        ArrayList<Customer> minQueue = null;
        if(customer.isManicure() && sizeManicure <min)
        {
            minQueue = this.manicureQueue;
            min = sizeManicure;
        }
        if(customer.isPedicure() && sizePedicure <min)
        {
            minQueue = this.pedicureQueue;
            min = sizePedicure;
        }
        if(customer.isTan() && sizeTan <min)
        {
            minQueue = this.tanQueue;
            min = sizeTan;
        }
        if(minQueue == null)//customer finished
        {
           // System.out.println("customer "+customer.getId()+" is done");
            return;
        }
        minQueue.add(customer);
    }


}
