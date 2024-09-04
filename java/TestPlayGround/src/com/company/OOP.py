

class Contacts:

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def getName(self):
        print(self.name)

    def changeNume(self):
        pass

    def __le__(self):
        pass

con1 = Contacts("nafiz" , 20 )
con2 = Contacts("mahir", 20)

print(con1 < con2)

list1 = ["nafiz", "karim", "alif"]

list2 = list1

list2.append("hnaf")

print(list1)
print(4 < 5)

print(int.__le__(4 , 5))