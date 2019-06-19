from Ship import Ship

class Armada:
    def __init__(self):
        self.ships = []

    def fill_armada(self, number_of_ships):
        for x in range(number_of_ships):
            self.ships.append(Ship())

    def war(self, enemy_armada):
        self_ship_number = 0
        enemy_ship_number = 0

        while len(self.ships) > self_ship_number and len(enemy_armada.ships) > enemy_ship_number:
            self_ship = self.ships[self_ship_number]
            enemy_ship = enemy_armada.ships[enemy_ship_number]
            # self ship always wins here
            if self_ship.get_battle_power(self_ship) > enemy_ship.get_battle_power(enemy_ship):
                self_ship.battle(enemy_ship)
                enemy_ship_number += 1
            # self ship always loose here
            else:
                self_ship.battle(enemy_ship)
                self_ship_number += 1

        if len(enemy_armada.ships) <= enemy_ship_number:
            return True
        else:
            return False
