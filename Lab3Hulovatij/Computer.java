package KI-303HulovatijLab3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас Computer представляє комп'ютерну систему з можливістю керування основними компонентами, такими як CPU, RAM та жорсткий диск.
 * Включає можливість запуску/зупинки комп'ютера, оновлення RAM і жорсткого диска, встановлення програм, перевірки здоров'я системи та інше.
 */
public abstract class Computer {
    protected CPU cpu;
    protected RAM ram;
    protected HardDrive hardDrive;
    protected Logger logger;
    protected boolean isOn;
    protected int temperature;
    protected boolean overclocked;
    protected List<String> runningPrograms;

    /**
     * Конструктор для створення комп'ютера з початковим станом включення.
     * @param isOn Початковий стан комп'ютера (включений/вимкнений)
     * @throws IOException Якщо виникає помилка під час створення лог-файлу
     */
    public Computer(boolean isOn) throws IOException {
        this.isOn = isOn;
        this.cpu = new CPU("Intel i7", 3.1, 4);
        this.ram = new RAM(32);
        this.hardDrive = new HardDrive();
        this.temperature = 40;
        this.overclocked = false;
        this.runningPrograms = new ArrayList<>();

        this.logger = new Logger("computer_log.txt");

        logger.log(String.format("Комп'ютер %s створено.", this.toString()));
    }

    /**
     * Конструктор для створення комп'ютера з визначеними компонентами та станом включення.
     * @param cpu Процесор комп'ютера
     * @param ram Оперативна пам'ять комп'ютера
     * @param hardDrive Жорсткий диск комп'ютера
     * @param isOn Початковий стан комп'ютера (включений/вимкнений)
     * @throws IOException Якщо виникає помилка під час створення лог-файлу
     */
    public Computer(CPU cpu, RAM ram, HardDrive hardDrive, boolean isOn) throws IOException {
        this.cpu = cpu;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.isOn = isOn;
        this.temperature = 40;
        this.overclocked = false;
        this.runningPrograms = new ArrayList<>();

        this.logger = new Logger("computer_log.txt");

        logger.log(String.format("Комп'ютер %s створено.", this.toString()));
    }

    /**
     * Абстрактний метод для включення комп'ютера.
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public abstract void startComputer() throws IOException;

    /**
     * Абстрактний метод для виключення комп'ютера.
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public abstract void stopComputer() throws IOException;


    /**
     * Оновлює обсяг оперативної пам'яті (RAM).
     * @param capacity Новий обсяг оперативної пам'яті
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public void updateRAM(int capacity) throws IOException {
        ram.addCapacity(capacity);

        logger.log(String.format("Оновлено RAM до %s", ram.getCapacity()));
        System.out.printf("Оновлено RAM до %s\n", ram.getCapacity());
    }

    /**
     * Отримує модель процесора.
     * @return Модель процесора
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public String modelOfCPU() throws IOException {
        String model = cpu.getModel();

        logger.log(String.format("Модель CPU: %s", model));
        System.out.printf("Модель CPU: %s\n", model);
        return model;
    }

    /**
     * Оновлює обсяг вільного місця на жорсткому диску.
     * @param capacity Обсяг вільного місця на жорсткому диску
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public void updateHardDrive(int capacity) throws IOException {
        if (hardDrive.getFreeSpace() == capacity) hardDrive.setCapacity(capacity);

        logger.log(String.format("Місце на жорсткому диску збільшено на %s", capacity));
        System.out.printf("Місце на жорсткому диску збільшено на %s", capacity);
    }

    /**
     * Встановлює програму на жорсткий диск.
     * @param softwareName Назва програмного забезпечення
     * @param sizeInMB Розмір програми в мегабайтах
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public void installSoftware(String softwareName, int sizeInMB) throws IOException {
        if (isOn) {
            if (hardDrive.getFreeSpace() >= sizeInMB) {
                hardDrive.setFreeSpace(hardDrive.getFreeSpace() - sizeInMB);
                runningPrograms.add(softwareName);
                logger.log("Встановлено програму: " + softwareName + ". Розмір: " + sizeInMB + " MB");
                System.out.println("Встановлено програму: " + softwareName);
            } else {
                logger.log("Недостатньо місця для встановлення " + softwareName);
                System.out.println("Недостатньо місця для встановлення " + softwareName);
            }
        } else {
            logger.log("Неможливо встановити програму. Комп'ютер вимкнено");
            System.out.println("Неможливо встановити програму. Комп'ютер вимкнено");
        }
    }

    /**
     * Запускає стрес-тест, підвищуючи температуру комп'ютера.
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public void runStressTest() throws IOException {
        if (isOn) {
            temperature += 20;
            logger.log("Запущено стрес-тест. Температура підвищилась до " + temperature + "°C");
            System.out.println("Запущено стрес-тест");
            if (temperature > 90) {
                logger.log("УВАГА: Висока температура!");
                System.out.println("УВАГА: Висока температура!");
            }
        } else {
            logger.log("Неможливо запустити стрес-тест. Комп'ютер вимкнено");
            System.out.println("Неможливо запустити стрес-тест. Комп'ютер вимкнено");
        }
    }

    /**
     * Перевіряє здоров'я системи та виводить його рівень.
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public void checkSystemHealth() throws IOException {
        if (isOn) {
            int health = 100;
            if (temperature > 80) health -= 20;
            if (overclocked) health -= 10;
            if (hardDrive.getFreeSpace() < 1000) health -= 15;

            logger.log("Перевірка здоров'я системи: " + health + "%");
            System.out.println("Здоров'я системи: " + health + "%");

            if (health < 50) {
                logger.log("УВАГА: Рекомендується обслуговування системи");
                System.out.println("УВАГА: Рекомендується обслуговування системи");
            }
        } else {
            logger.log("Неможливо перевірити здоров'я системи. Комп'ютер вимкнено");
            System.out.println("Неможливо перевірити здоров'я системи. Комп'ютер вимкнено");
        }
    }

    /**
     * Закриває запущену програму і звільняє RAM.
     * @param programName Назва програми
     * @param ramUsage Використання RAM в мегабайтах
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public void closeProgram(String programName, int ramUsage) throws IOException {
        if (isOn && runningPrograms.contains(programName)) {
            runningPrograms.remove(programName);
            ram.setCapacity(ram.getCapacity() - ramUsage);
            logger.log("Закрито програму: " + programName + ". Звільнено RAM: " + ramUsage + " MB");
            System.out.println("Закрито програму: " + programName);

            temperature -= 1;
            if (temperature < 0) temperature = 0;
        } else {
            logger.log("Неможливо закрити програму " + programName + ". Програма не запущена або комп'ютер вимкнено");
            System.out.println("Неможливо закрити програму " + programName);
        }
    }

    /**
     * Виводить список запущених програм.
     * @throws IOException Якщо виникає помилка під час запису до лог-файлу
     */
    public void listRunningPrograms() throws IOException {
        if (isOn) {
            logger.log("Список запущених програм: " + String.join(", ", runningPrograms));
            System.out.println("Запущені програми: " + String.join(", ", runningPrograms));
        } else {
            logger.log("Неможливо отримати список програм. Комп'ютер вимкнено");
            System.out.println("Неможливо отримати список програм. Комп'ютер вимкнено");
        }
    }

    /**
     * Метод для закриття логера.
     * @throws IOException якщо виникає помилка під час закриття логера.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}