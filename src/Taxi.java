import java.util.UUID;

public class Taxi extends ServiceUtil {
    //택시 번호
    private String number;

    //주유량
    private int gas;

    //현재 속도
    private int nowSpeed;

    //목적지
    private String destination;

    //기본 거리
    final private int common_distance;

    //목적지 까지 거리
    private int destination_distance;

    // 기본 요금
    private int commonRate;

    //거리당 요금
    private int distanceRate;

    //상태
    private String state;

    public String getNumber() {
        return number;
    }

    public int getGas() {
        return gas;
    }

    public int getNowSpeed() {
        return nowSpeed;
    }

    public String getDestination() {
        return destination;
    }

    public int getCommon_distance() {
        return common_distance;
    }

    public int getDestination_distance() {
        return destination_distance;
    }

    public int getCommonRate() {
        return commonRate;
    }

    public int getDistanceRate() {
        return distanceRate;
    }

    public String getState() {
        return state;
    }

    public void setNowSpeed(int nowSpeed) {
        this.nowSpeed = nowSpeed;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Taxi(int gas, int nowSpeed, String destination, int destination_distance) {
        this.number = UUID.randomUUID().toString();
        this.gas = gas;
        this.nowSpeed = nowSpeed;
        this.destination = destination;
        this.common_distance = 20;
        this.destination_distance = destination_distance;
        this.commonRate = 1000;
        this.distanceRate = 1;
        this.state = stateCheck(gas) ? "일반" : "운행불가";

    }

    public void paymentOfFees() {
        int fees = 0;
        if (stateCheck(gas) && state.equals("운행 중")) {
            if (common_distance < destination_distance) {
                fees = ((distanceRate + 5) * (destination_distance - common_distance))+commonRate;
            } else {
                fees = commonRate;
            }
            System.out.println(fees);
        }else{
            System.out.println("정산 불가능");
        }
    }
}

