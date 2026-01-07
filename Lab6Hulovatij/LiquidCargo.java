package KI-303Hulovatiulab6;

/**
 * Клас, що представляє рідкий вантаж
 */
class LiquidCargo implements Comparable<LiquidCargo> {
    private String name;
    private double volume;
    private double density;

    /**
     * Конструктор класу LiquidCargo
     * @param name назва рідини
     * @param volume об'єм
     * @param density густина
     */
    public LiquidCargo(String name, double volume, double density) {
        this.name = name;
        this.volume = volume;
        this.density = density;
    }

    public double getWeight() {
        return volume * density;
    }

    public String getName() {
        return name;
    }

    /**
     * Порівнює рідкі вантажі за їх вагою (об'єм * густина)
     * @param other інший рідкий вантаж для порівняння
     * @return від'ємне число, якщо поточний вантаж легший,
     *         додатне число, якщо важчий,
     *         0, якщо ваги рівні
     */
    @Override
    public int compareTo(LiquidCargo other) {
        return Double.compare(this.getWeight(), other.getWeight());
    }

    @Override
    public String toString() {
        return "LiquidCargo{name='" + name + "', volume=" + volume +
                ", density=" + density + ", weight=" + getWeight() + "}";
    }
}