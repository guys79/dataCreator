public class Pedicure extends AbstractTimedService {

    public Pedicure(int numOfUnits) {
        super(numOfUnits);
    }

    @Override
    protected double getMinTime() {
        return 1200;
    }

    @Override
    protected double getMaxTime() {
        return 2400;
    }

    @Override
    protected void finishService(Customer customer) {
        customer.setPedicure(false);
    }
}
