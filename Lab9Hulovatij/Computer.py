class Computer:
    """
    Клас Computer представляє базову модель комп’ютера.
    """

    def __init__(self, name, processor, ram):
        """
        Ініціалізує об'єкт комп’ютера.

        :param name: Назва комп’ютера.
        :param processor: Процесор комп’ютера.
        :param ram: Обсяг оперативної пам'яті в ГБ.
        """
        self.name = name
        self.processor = processor
        self.ram = ram  # обсяг оперативної пам'яті

    def get_status(self):
        """
        Отримує поточний статус комп’ютера.

        :return: Строка із характеристиками комп’ютера.
        """
        return f"Комп’ютер {self.name}: процесор {self.processor}, оперативна пам'ять {self.ram} ГБ."