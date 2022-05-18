import java.util.UUID;

public class Bus extends ServiceUtil {
    // 최대 승객 수
    private int maxPassenger;
    // 현재 승객 수
    private int nowPassenger;
    // 요금
    private int rate;
    // 버스 번호
    final private String number;
    //주유량
    private int gas;
    // 현재 속도
    private int nowSpeed;
    // 상태
    private String state;

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public int getNowPassenger() {
        return nowPassenger;
    }

    public void setNowPassenger(int nowPassenger) {
        this.nowPassenger = nowPassenger;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getNumber() {
        return number;
    }


    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getNowSpeed() {
        return nowSpeed;
    }

    public void setNowSpeed(int nowSpeed) {
        this.nowSpeed = nowSpeed;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Bus(int maxPassenger, int nowPassenger, int rate, int gas, int nowSpeed) {
        this.maxPassenger = maxPassenger;
        this.nowPassenger = nowPassenger;
        this.rate = rate;
        this.number = UUID.randomUUID().toString();
        this.gas = gas;
        this.nowSpeed = nowSpeed;
        this.state = "운행";
    }

    public void operating() {
        if (stateCheck(gas)) {
            this.state = "운행 중";
            System.out.println("운행 시작");
        } else {
            System.out.println("주유가 필요하다.");
        }
    }

    public void close() {
        this.state = "차고지 행";
        System.out.println("운행종료: 차고지 행");
    }
}
