package KI-303Hulovatiulab6;

/**
 * Головний клас для тестування функціональності трюму
 */
public class ShipHoldDriver {
    public static void main(String[] args) {
        // Створюємо трюм для контейнерів
        ShipHold<Container> containerHold = new ShipHold<>(5);

        try {
            // Додаємо контейнери
            containerHold.addCargo(new Container("Electronics", 1000));
            containerHold.addCargo(new Container("Clothing", 500));
            containerHold.addCargo(new Container("Machinery", 2000));

            System.out.println("Список контейнерів: " + containerHold);

            // Знаходимо найважчий контейнер
            Container heaviestContainer = containerHold.findMaxCargo();
            Container containerRemoved = containerHold.removeCargo(2);

            System.out.println("Вилучений контейнер: " + containerRemoved);
            System.out.println("Найважчий контейнер: " + heaviestContainer);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Створюємо трюм для рідких вантажів
        ShipHold<LiquidCargo> liquidHold = new ShipHold<>(3);

        try {
            // Додаємо рідкі вантажі
            liquidHold.addCargo(new LiquidCargo("Oil", 1000, 0.9));
            liquidHold.addCargo(new LiquidCargo("Water", 1000, 1.0));
            liquidHold.addCargo(new LiquidCargo("Gasoline", 800, 0.75));

            System.out.println("Список рідких вантажів: " + liquidHold);
            // Знаходимо найважчий рідкий вантаж
            LiquidCargo heaviestLiquid = liquidHold.findMaxCargo();
            System.out.println("Найважчий рідкий вантаж: " + heaviestLiquid);

            // Демонструємо виймання вантажу
            Container removedContainer = containerHold.removeCargo(0);
            System.out.println("Вийнятий контейнер: " + removedContainer);
            System.out.println("Залишилось контейнерів: " + containerHold.getCurrentLoad());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}