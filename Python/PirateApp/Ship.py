from Pirate import Pirate
import random


class Ship:

    def __init__(self):
        self.pirates = []
        self.captain = ""
        self.fill_ship()

    def fill_ship(self):
        self.number_of_pirates = round(random.random()*50)
        self.captain = Pirate(True)
        for x in range (self.number_of_pirates):
            self.pirates.append(Pirate())

    def get_pirates_alive(self):
        count = 0
        for pirate in self.pirates:
            if(pirate.is_dead == False):
                count +=1
        return count

    def __str__(self):
        status ="Captain intoxication: {}, Dead: {}, alive crew: {}".format(self.captain.intoxication,self.captain.is_dead, self.get_pirates_alive())
        return status

    def battle (self, another_ship):
        this_ship_power = self.get_battle_power(self)
        another_ship_power = self.get_battle_power(another_ship)
        if this_ship_power>another_ship_power:
            self.__win(self)
            self.__loose(another_ship)
            return True
        else:
            self.__win(another_ship)
            self.__loose(self)
            return False

    def get_battle_power (self, ship):
        return ship.get_pirates_alive() - ship.captain.intoxication

    def __loose (self, ship):
        options = "live","die"
        destiny = random.choice(options)
        if destiny=="die":
            ship.captain.die()
        for pirate in ship.pirates:
            destiny = random.choice(options)
            if destiny=="die":
                pirate.die()
            
    def __win (self, ship):
        rum_ammount = round(random.random()*50)
        ship.captain.intoxication += rum_ammount
        for pirate in ship.pirates:
            pirate.intoxication += rum_ammount
