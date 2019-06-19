from Pirate import Pirate
from Ship import Ship
from Armada import Armada

test_armada = Armada()
enemy_armada = Armada()
test_armada.fill_armada(10)
enemy_armada = Armada()
enemy_armada.fill_armada(10)
result = test_armada.war(enemy_armada)
print(result)



