from Laptop import Laptop

if __name__ == "__main__":
    # Створюємо об'єкт ноутбука
    # Параметри: назва, процесор, оперативна пам'ять (ГБ), об'єм батареї (мАг)
    macbook = Laptop("MacBook Pro", "M2", 16, 10000)

    # Виводимо початковий стан
    print("\n1. Початковий стан:")
    print(macbook.get_status())

    # Використання батареї
    print("\n2. Використання ноутбука:")
    macbook.use_battery(3000)
    print(macbook.get_status())

    # Спроба використати більше заряду, ніж залишилось
    print("\n3. Спроба перевищити заряд:")
    macbook.use_battery(8000)

    # Заряджання ноутбука
    print("\n4. Зарядка ноутбука:")
    macbook.charge_battery()
    print(macbook.get_status())

    # Закриваємо та відкриваємо ноутбук
    print("\n5. Закриття та відкриття ноутбука:")
    macbook.close_lid()
    macbook.open_lid()
    print(macbook.get_status())