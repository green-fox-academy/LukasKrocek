import random

class Pirate:
    def __init__(self, is_captain = False):
        self.intoxication = 0
        self.is_dead = False
        self.is_captain = is_captain
        self.has_wooden_leg = False

    def drink_some_rum(self):
        if self.is_dead:
            print("he's dead")
        else:
            self.intoxication += 1

    def how_it_going_mate(self):
        if self.is_dead:
            print("he's dead")
        elif self.intoxication < 5:
            print("Pour me anudder!")
        else:
            print("Arghh, I'ma Pirate. How d'ya d'ink its goin?")
            self.intoxication = 0

    def die(self):
        self.is_dead = True

    def brawl(self, another_pirate):
        if self.is_dead or another_pirate.is_dead:
            print("One of those pirates is already dead")
        else:
            brawl_outcomes = "win", "loose", "draw"
            brawl_result = random.choice(brawl_outcomes)
            if brawl_result == "win":
                another_pirate.die()
            elif brawl_result == "loose":
                self.die()
            else:
                another_pirate.die()
                self.die()

