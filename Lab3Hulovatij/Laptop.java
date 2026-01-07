package KI-303HulovatijLab3;

import java.io.IOException;

/**
 * Клас Laptop розширює Computer і реалізує інтерфейс Portable.
 */
public class Laptop extends Computer implements Portable {
    private int batteryLevel;
    private Logger logger;

    /**
     * Конструктор для створення ноутбука.
     * @param cpu Процесор ноутбука
     * @param ram Оперативна пам'ять ноутбука
     * @param hardDrive Жорсткий диск ноутбука
     * @param isOn Початковий стан ноутбука (включений/вимкнений)
     * @throws IOException Якщо виникає помилка під час створення лог-файлу
     */
    public Laptop(CPU cpu, RAM ram, HardDrive hardDrive, boolean isOn) throws IOException {
        super(cpu, ram, hardDrive, isOn);
        this.batteryLevel = 100;
        this.logger = new Logger("laptop_log.txt");
    }

    @Override
    public void startComputer() throws IOException {
        if (!isOn) {
            isOn = true;
            logger.log("Ноутбук увімкнено");
            System.out.println("Ноутбук увімкнено");
        }
    }

    @Override
    public void stopComputer() throws IOException {
        if (isOn) {
            isOn = false;
            logger.log("Ноутбук вимкнено");
            System.out.println("Ноутбук вимкнено");
        }
    }

    @Override
    public void chargeBattery() {
        batteryLevel = Math.min(100, batteryLevel + 10);
        System.out.println("Батарея заряджається. Поточний рівень: " + batteryLevel + "%");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    /**
     * Метод для використання ноутбука, що зменшує рівень батареї.
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public void useLaptop() throws IOException {
        if (isOn && batteryLevel > 0) {
            batteryLevel -= 5;
            logger.log("Ноутбук використовується. Рівень батареї: " + batteryLevel + "%");
            System.out.println("Ноутбук використовується. Рівень батареї: " + batteryLevel + "%");
        } else if (!isOn) {
            System.out.println("Неможливо використовувати ноутбук. Він вимкнений.");
        } else {
            System.out.println("Батарея розряджена. Потрібно зарядити ноутбук.");
        }
    }
}