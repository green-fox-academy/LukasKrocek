from Aircraft import Aircraft

class F16 (Aircraft):
    
    def __init__(self):
        self.max_ammo = 8
        self.base_damage = 30
        self.priority = False
        self.current_ammo = 0
        self.aircraftType = "F16"