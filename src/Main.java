public class Main {
    public static void main(String[] args) {
        // static 객체 생성
        ServiceCar taxiService = TaxiUtilImpl.getInstance();
        ServiceCar busService = BusUtilImpl.getInstance();


        // 택시
        Taxi taxi = new Taxi(10, 120, "부산", 500);

        taxiService.boarding(taxi);
        taxiService.changeSpeed(taxi,10,1);
        taxi.paymentOfFees();
        System.out.println();

        //버스
        Bus bus = new Bus(3,0, 1, 18, 30);
        bus.operating();
        for (int i=0; i<10;i++){
            busService.changeSpeed(bus,15,1);
        }
        bus.close();



    }
}