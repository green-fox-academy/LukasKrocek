a = 1
while a <= 3:
    print(a)
    a += 1

#-----------

for letter in "Girraffe Academy": #runs for each letter in String
    print(letter) 

#------------

for index in range(5):
    if index == 0:
        print("first")

#------------
def raise_to_power(base_num, pow_num):
    result = 1
    for index in range(pow_num):
        result = result*base_num
    return result