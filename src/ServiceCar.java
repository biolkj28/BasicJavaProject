public interface ServiceCar<T> {

    void boarding(T object);
    void changeSpeed(T object, int speed, int opt);

}
