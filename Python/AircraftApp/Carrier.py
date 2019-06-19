
class Carrier:
    def __init__(self, ammo_amount, health_points):
        self.ammo_amount = ammo_amount
        self.health_points = health_points
        self.aircrafts = []

    def add(self, aircraft):
        self.aircrafts.append(aircraft)
        
    def fill(self):
        for aircraft in self.aircrafts:
            if self.ammo_amount>aircraft.max_ammo-aircraft.current_ammo:
                self.ammo_amount = aircraft.refill(self.ammo_amount)
                