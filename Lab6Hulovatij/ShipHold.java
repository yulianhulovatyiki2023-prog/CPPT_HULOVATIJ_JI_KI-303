package KI-303Hulovatiulab6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Параметризований клас, що реалізує трюм корабля.
 * Дозволяє зберігати та управляти вантажем різних типів.
 *
 * @param <T> тип вантажу, що зберігається в трюмі
 */
public class ShipHold<T extends Comparable<T>> {
    private ArrayList<T> cargo;
    private int capacity;

    /**
     * Конструктор класу ShipHold
     * @param capacity максимальна місткість трюму
     */
    public ShipHold(int capacity) {
        this.capacity = capacity;
        this.cargo = new ArrayList<>();
    }

    /**
     * Додає вантаж до трюму
     * @param item елемент для додавання
     * @return true якщо додавання успішне, false якщо трюм повний
     */
    public boolean addCargo(T item) {
        if (cargo.size() < capacity) {
            cargo.add(item);
            return true;
        }
        return false;
    }

    /**
     * Виймає вантаж з трюму
     * @param index індекс вантажу для виймання
     * @return вийнятий вантаж або null якщо індекс невірний
     */
    public T removeCargo(int index) {
        if (index >= 0 && index < cargo.size()) {
            return cargo.remove(index);
        }
        return null;
    }

    /**
     * Знаходить максимальний елемент у трюмі
     * @return максимальний елемент або null якщо трюм порожній
     */
    public T findMaxCargo() {
        if (cargo.isEmpty()) {
            return null;
        }
        return Collections.max(cargo);
    }

    /**
     * Отримує поточну кількість вантажу в трюмі
     * @return кількість елементів у трюмі
     */
    public int getCurrentLoad() {
        return cargo.size();
    }

    /**
     * Перевіряє чи є вказаний вантаж у трюмі
     * @param item елемент для пошуку
     * @return true якщо елемент знайдено, false якщо ні
     */
    public boolean containsCargo(T item) {
        return cargo.contains(item);
    }

    /**
     * Вивести вміст списку
     * @return рядок, що представляє вміст списку
     */
    @Override
    public String toString() {
        return "ShipHold{" +
                "cargo=" + cargo +
                ", capacity=" + capacity +
                '}';
    }
}