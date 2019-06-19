from Aircraft import Aircraft

class F35 (Aircraft):
    def __init__(self):
        self.max_ammo = 12
        self.base_damage = 50
        self.priority = True
        self.current_ammo = 0
        self.aircraftType = "F35"
