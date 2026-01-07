Package KI-303HulovatijLab2;

import java.io.IOException;

/**
 * Головний клас для запуску і тестування функціональності комп'ютера.
 * Містить метод main, який демонструє використання класу Computer.
 */
public class ComputerDriver {
    /**
     * Основний метод програми. Виконує симуляцію керування комп'ютерп.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        try {
            // Створює новий об'єкт комп'ютера з початковим станом "увімкнуто".
            Computer computer = new Computer(true);

            computer.startComputer();
            computer.updateRAM(2);
            computer.modelOfCPU();
            computer.updateHardDrive(100);
            computer.installSoftware("GoogleChrome", 500);
            computer.runStressTest();
            computer.checkSystemHealth();
            computer.listRunningPrograms();
            computer.closeProgram("GoogleChrome", 500);
            computer.stopComputer();

            computer.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}