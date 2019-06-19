from F35 import F35
from Carrier import Carrier

testPlane = F35()
print(testPlane)
testCarrier = Carrier(200,1000)
testCarrier.add(testPlane)
print(testCarrier.aircrafts)




