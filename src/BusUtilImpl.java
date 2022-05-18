public class BusUtilImpl extends ServiceUtil implements ServiceCar {

    private final static BusUtilImpl instance = new BusUtilImpl();

    private BusUtilImpl() {
    }

    public static BusUtilImpl getInstance() {
        return instance;
    }


    @Override
    public void boarding(Object object) {
        Bus bus = (Bus) object;
        if (bus.getState().equals("운행 중")) {
            System.out.println("승객 탑승");
            if (bus.getNowPassenger() < bus.getMaxPassenger()) {
                bus.setNowPassenger(bus.getNowPassenger() + 1);
            }else{
                System.out.println("탑승 초과");
            }
        }
    }

    @Override
    public void changeSpeed(Object object, int speed, int opt) {
        Bus bus = (Bus) object;
        if (stateCheck(bus.getGas())) {
            int preSpeed = bus.getNowSpeed();
            int nowSpeed = opt > 0 ? preSpeed + speed : preSpeed - speed;
            bus.setNowSpeed(nowSpeed);
            bus.setGas(bus.getGas() - 1);
            if (bus.getGas() < 10) {
                bus.setState("차고지행");
                System.out.println("주유량을 확인해 주세요.");
            } else {
                System.out.println("이전 속도: " + preSpeed + " 이후 속도: " + nowSpeed);
            }


        } else {
            System.out.println("주유가 필요하다.");
        }
    }
}
