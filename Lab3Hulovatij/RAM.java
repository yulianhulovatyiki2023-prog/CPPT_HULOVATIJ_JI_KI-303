Package KI-303HulovatijLab3;
/**
 * Клас RAM представляє оперативну пам'ять комп'ютера. Він включає інформацію про загальну місткість пам'яті та можливість її збільшення.
 */
public class RAM {
    private int capacity;

    /**
     * Конструктор за замовчуванням для створення оперативної пам'яті з початковою місткістю 8 ГБ.
     */
    public RAM() {
        this(8);
    }

    /**
     * Конструктор для створення об'єкта RAM з вказаною місткістю.
     * @param capacity Місткість оперативної пам'яті в ГБ
     */
    public RAM(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Додає вказану кількість до загальної місткості оперативної пам'яті.
     * @param amount Кількість пам'яті, яку потрібно додати (в ГБ)
     */
    public void addCapacity(int amount) {
        this.capacity += amount;
    }

    /**
     * Отримує загальну місткість оперативної пам'яті.
     * @return Місткість оперативної пам'яті в ГБ
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Встановлює нову місткість оперативної пам'яті.
     * @param capacity Місткість оперативної пам'яті в ГБ
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}