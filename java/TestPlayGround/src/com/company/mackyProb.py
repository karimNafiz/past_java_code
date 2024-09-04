
inputList = []

for i in range(6):
    inputList.append(int(input("enter amount")))

sum = 0
amount = 0
for x in range(len(inputList)):
    sum += inputList[x]

if sum % 3 == 0:
    print(sum)
    amount = (sum * 3)-sum
    print("she needs more ", amount, " to make it sum * 3")
else:
    print("the total amount is ", (amount + 100))
