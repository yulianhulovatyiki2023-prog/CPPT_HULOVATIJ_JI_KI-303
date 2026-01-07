package KI-303HulovatijLab3;

import java.io.IOException;

/**
 * Головний клас для запуску і тестування функціональності комп'ютера.
 * Містить метод main, який демонструє використання класу Computer.
 */
public class LaptopDriver {
    /**
     * Основний метод програми. Виконує симуляцію керування комп'ютерп.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        try {
            CPU cpu = new CPU("Intel i5", 2.5, 4);
            RAM ram = new RAM(8);
            HardDrive hardDrive = new HardDrive();

            Laptop laptop = new Laptop(cpu, ram, hardDrive, false);

            laptop.startComputer();
            System.out.println("Рівень батареї: " + laptop.getBatteryLevel() + "%");

            laptop.useLaptop();
            laptop.useLaptop();

            System.out.println("Рівень батареї після використання: " + laptop.getBatteryLevel() + "%");

            laptop.chargeBattery();
            System.out.println("Рівень батареї після зарядки: " + laptop.getBatteryLevel() + "%");

            laptop.stopComputer();

            laptop.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}