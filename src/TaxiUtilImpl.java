public class TaxiUtilImpl extends ServiceUtil implements ServiceCar {


    private static final TaxiUtilImpl instance = new TaxiUtilImpl();

    public static TaxiUtilImpl getInstance(){
        return instance;
    }
    private TaxiUtilImpl() {
    }
    @Override
    public void boarding(Object object) {
        Taxi taxi = (Taxi) object;
        taxi.setState(taxi.getState().equals("일반") ? "운행 중" : "탑승 불가");
        System.out.println(taxi.getState());
    }


    @Override
    public void changeSpeed(Object object,int speed, int opt) {
        Taxi taxi = (Taxi) object;
        if (stateCheck(taxi.getGas())&& taxi.getState().equals("운행 중")) {
            int preSpeed = taxi.getNowSpeed();
            taxi.setNowSpeed(opt > 0 ? preSpeed + speed : (preSpeed - speed));

            if ((taxi.getNowSpeed()) < 0) System.out.println("현재 속도 0");
            else System.out.println("이전 속도: " + preSpeed + " 현재 속도: " + taxi.getNowSpeed());
        }
    }
}
