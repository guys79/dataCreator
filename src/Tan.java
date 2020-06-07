public class Tan extends AbstractTimedService {

    public Tan(int numOfUnits) {
        super(numOfUnits);
    }

    @Override
    protected double getMinTime() {
        return 480;
    }

    @Override
    protected double getMaxTime() {
        return 720;
    }

    @Override
    protected void finishService(Customer customer) {
        customer.setTan(false);
    }
}
