package KI-303HulovatijLab2;
/**
 * Клас HardDrive представляє жорсткий диск комп'ютера. Він включає інформацію про загальну місткість диска та доступний вільний простір.
 */
public class HardDrive {
    private int capacity;
    private int freeSpace;

    /**
     * Конструктор за замовчуванням для створення жорсткого диска з початковою місткістю 1000 ГБ і 500 ГБ вільного простору.
     */
    public HardDrive() {
        this(1000, 500);
    }

    /**
     * Конструктор для створення об'єкта HardDrive з вказаною місткістю та вільним простором.
     * @param capacity Загальна місткість жорсткого диска в ГБ
     * @param freeSpace Вільний простір на жорсткому диску в ГБ
     */
    public HardDrive(int capacity, int freeSpace) {
        this.capacity = capacity;
        this.freeSpace = freeSpace;
    }

    /**
     * Отримує загальну місткість жорсткого диска.
     * @return Загальна місткість жорсткого диска в ГБ
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Встановлює загальну місткість жорсткого диска.
     * @param capacity Загальна місткість жорсткого диска в ГБ
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Отримує вільний простір на жорсткому диску.
     * @return Вільний простір на жорсткому диску в ГБ
     */
    public int getFreeSpace() {
        return freeSpace;
    }

    /**
     * Встановлює вільний простір на жорсткому диску.
     * @param freeSpace Вільний простір на жорсткому диску в ГБ
     */
    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }