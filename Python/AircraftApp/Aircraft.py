class Aircraft:
    max_ammo = 0
    base_damage = 0
    current_ammo = 0
    aircraftType = ""
    priority = False

    def fight(self):
        damage = self.base_damage*self.current_ammo
        self.current_ammo = 0
        return damage

    def refill(self, number_of_ammo):
        before_refill = self.current_ammo
        self.current_ammo += number_of_ammo
        if(self.current_ammo > self.max_ammo):
            self.current_ammo = self.max_ammo
        remainder = number_of_ammo - (self.current_ammo-before_refill)
        return remainder

    def getType(self):
        return self.aircraftType

    def __str__(self):
        # status = "Type " + str(self.aircraftType) + ", Ammo: " + str(self.current_ammo) + ",Base Damage: " + str(
        #    self.base_damage) + ", All Damage: " + str(self.base_damage*self.current_ammo)
        status = "Type {}, Ammo: {},Base Damage: {}, All Damage: {}".format(
            self.aircraftType, self.current_ammo, self.base_damage, self.base_damage*self.current_ammo)
        return status


#"Shepherd {} is {} years old.".format(shepherd, age)

    def isPriority(self):
        return self.priority
