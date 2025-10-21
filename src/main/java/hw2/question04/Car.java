package hw2.question04;

public class Car {

    private String brand;
    private String name;
    private int year;
    private double storage;
    private double fuel;
    private int distance;
    private boolean isOn;
    private static final int FUEL_EFFICIENCY = 10;

    public Car(String brand, String name, int year, double storage) {
        this.brand = brand;
        this.name = name;
        this.year = year;
        this.storage = storage;
        fuel = storage / 2;
        distance = 0;
        isOn = false;
    }

    // 차량 현재 상태 출랙
    public void showCarStatus() {
        System.out.println("자동차 현재 상태");
        System.out.println(" - " + this);
    }

    // 전원 켜기
    public void startEngine() {
        if (isOn) {
            System.out.println("이미 엔진이 켜져있습니다.");
            return;
        }

        if (fuel < 0) {
            System.out.println("연료가 부족해 전원을 켤 수 없습니다.");
            return;
        }

        isOn = true;
        System.out.println("전원이 켜졌습니다.");
    }

    // 전원 끄기
    public void stopEngine() {
        if (!isOn) {
            System.out.println("이미 엔진이 꺼져있습니다.");
            return;
        }

        isOn = false;
        System.out.println("전원을 종료합니다.");
    }

    // 해당 거리 주행 가능 여부
    public void canDrive(int distance) {
        if (!isOn) {
            System.out.println("전원이 꺼져있어 주행 가능 여부를 확인할 수 없습니다.");
            return;
        }

        if (FUEL_EFFICIENCY * fuel < distance) {
            System.out.println("연료가 부족하여 " + distance + "KM 주행이 불가능합니다. 현재 주행가능 거리: " + FUEL_EFFICIENCY * fuel + "KM");
            return;
        }

        System.out.println(distance + "KM 주행이 가능합니다.");
    }

    // 주행
    public void drive(int distance) {
        if (!isOn) {
            System.out.println("엔진이 꺼져있어 주행할 수 없습니다.");
            return;
        }

        if (FUEL_EFFICIENCY * fuel < distance) {
            System.out.println("연료가 부족하여 주행할 수 없습니다. 현재 주행가능 거리: " + FUEL_EFFICIENCY * fuel + "KM");
            return;
        }

        fuel -= distance / FUEL_EFFICIENCY;
        this.distance += distance;
        System.out.println(distance + "KM 주행합니다. 주행가능 거리: " + FUEL_EFFICIENCY * fuel + "KM");
    }

    // 주유
    public void refuel(int amount) {
        if (fuel + amount > storage) {
            System.out.println("최대 주유량을 넘어서 주유할 수 없습니다. 가능한 주유량: " + (storage - fuel) + "L");
            return;
        }

        fuel += amount;
        System.out.println(amount + "L 주유합니다. 현재 주유량: " + fuel + "L");
    }

    @Override
    public String toString() {
        return "브랜드: " + brand + " | 차종: " + name + " | 연식: " + year + " | 최대 연료량: " + storage +
                "L | 연료량: " + fuel + "L | 주행거리: " + distance + "KM | 엔진: " + (isOn ? "켜짐" : "꺼짐");
    }
}
