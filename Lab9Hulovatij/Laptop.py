from Computer import Computer


class Laptop(Computer):
    """
    Клас Laptop розширює функціональність базового класу Computer,
    додаючи можливість роботи на батареї та закриття/відкриття кришки.
    """

    def __init__(self, name, processor, ram, battery_capacity):
        """
        Ініціалізує об'єкт ноутбука.

        :param name: Назва ноутбука.
        :param processor: Процесор ноутбука.
        :param ram: Обсяг оперативної пам'яті в ГБ.
        :param battery_capacity: Максимальний обсяг батареї в мАг.
        """
        super().__init__(name, processor, ram)
        self.battery_capacity = battery_capacity  # максимальний обсяг батареї
        self.current_battery = battery_capacity  # поточний рівень заряду
        self.lid_closed = False  # стан кришки (закрита/відкрита)

    def use_battery(self, amount):
        """
        Використовує заряд батареї.

        :param amount: Обсяг заряду, що використовується (мАг).
        :return: True, якщо операція успішна, False - якщо недостатньо заряду.
        """
        if amount <= self.current_battery:
            print(f"{self.name} використовує {amount} мАг заряду.")
            self.current_battery -= amount
            return True
        else:
            print(f"Недостатньо заряду для використання {amount} мАг.")
            return False

    def charge_battery(self):
        """
        Заряджає батарею до повного рівня.
        """
        self.current_battery = self.battery_capacity
        print(f"{self.name} повністю заряджений.")

    def close_lid(self):
        """
        Закриває кришку ноутбука.
        """
        self.lid_closed = True
        print(f"{self.name} закрив кришку.")

    def open_lid(self):
        """
        Відкриває кришку ноутбука.
        """
        self.lid_closed = False
        print(f"{self.name} відкрив кришку.")

    def get_status(self):
        """
        Отримує поточний статус ноутбука, включаючи стан батареї та кришки.

        :return: Строка із характеристиками ноутбука.
        """
        basic_status = super().get_status()
        lid_status = "закрита" if self.lid_closed else "відкрита"
        return f"{basic_status}, батарея: {self.current_battery}/{self.battery_capacity} мАг, кришка: {lid_status}."