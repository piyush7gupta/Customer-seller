import random

catalogSize = random.randint (5, 10)
numBuyers = random.randint (5, 10)
numSellers = random.randint(3, 7)
buyerSleepTime = random.randint(50, 200)
sellerSleepTime = 0
itemCount = random.randint(2, 5) * numBuyers

with open ('gen_testcase.txt', 'w') as f:
    f.write(f'{catalogSize} {numBuyers} {numSellers} {buyerSleepTime} {sellerSleepTime}\n')
    for i in range(itemCount):
        priority = random.randint(1, 3)
        price = random.randint(8, 12)
        f.write(f'{priority} A {price}\n')
