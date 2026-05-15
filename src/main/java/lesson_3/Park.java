package lesson_3;

public class Park {
    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private String attractionName;
        private String workTime;
        private double price;

        public Attraction(String attractionName, String workTime, double price) {
            this.attractionName = attractionName;
            this.workTime = workTime;
            this.price = price;
        }

        public void info() {
            System.out.println("Парк: " + parkName + "\n" + "Аттракцион: " + attractionName + "\n" + "Время работы: " + workTime + "\n" + "Цена: " + price + "\n");
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Победы");

        Park.Attraction attration1 = park.new Attraction("Веселые горки", "10:00-22:00", 500.0);
        Park.Attraction attration2 = park.new Attraction("Колесо обозрения", "10:00-23:00", 300.0);
        Park.Attraction attration3 = park.new Attraction("Тир", "10:00-21:30", 150.0);

        System.out.println("Задание 3");
        attration1.info();
        attration2.info();
        attration3.info();
    }
}
