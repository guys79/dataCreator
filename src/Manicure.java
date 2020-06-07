public class Manicure extends AbstractTimedService {


    public Manicure(int numOfUnits) {
        super(numOfUnits);
    }

    @Override
    protected double getMinTime() {
        return 1800;
    }

    @Override
    protected double getMaxTime() {
        return 3600;
    }

    @Override
    protected void finishService(Customer customer) {
        customer.setManicure(false);
    }


}
