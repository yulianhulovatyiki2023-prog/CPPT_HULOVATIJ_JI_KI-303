Package KI-303HulovatijLab3;
/**
 * Клас CPU представляє процесор комп'ютера. Він включає інформацію про модель процесора, частоту його роботи та кількість ядер.
 */
public class CPU {
    private String model;
    private double frequency;
    private int cores;

    /**
     * Конструктор для створення об'єкта CPU з вказаною моделлю, частотою і кількістю ядер.
     * @param model Модель процесора
     * @param frequency Частота процесора в ГГц
     * @param cores Кількість ядер процесора
     */
    public CPU(String model, double frequency, int cores) {
        this.model = model;
        this.frequency = frequency;
        this.cores = cores;
    }

    /**
     * Отримує модель процесора.
     * @return Модель процесора
     */
    public String getModel() {
        return model;
    }

    /**
     * Встановлює модель процесора.
     * @param model Модель процесора
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Отримує частоту процесора.
     * @return Частота процесора в ГГц
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     * Встановлює частоту процесора.
     * @param frequency Частота процесора в ГГц
     */
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    /**
     * Отримує кількість ядер процесора.
     * @return Кількість ядер процесора
     */
    public int getCores() {
        return cores;
    }

    /**
     * Встановлює кількість ядер процесора.
     * @param cores Кількість ядер процесора
     */
    public void setCores(int cores) {
        this.cores = cores;
    }
}