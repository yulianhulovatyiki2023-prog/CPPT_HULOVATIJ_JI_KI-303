package KI-303Hulovatiulab6;

/**
 * Клас, що представляє контейнер з вантажем
 */
class Container implements Comparable<Container> {
    private String type;
    private double weight;

    /**
     * Конструктор класу Container
     * @param type тип контейнера
     * @param weight вага контейнера
     */
    public Container(String type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    /**
     * Порівнює контейнери за вагою
     * @param other інший контейнер для порівняння
     * @return від'ємне число, якщо поточний контейнер легший,
     *         додатне число, якщо важчий,
     *         0, якщо ваги рівні
     */
    @Override
    public int compareTo(Container other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "Container{type='" + type + "', weight=" + weight + "}";
    }
}