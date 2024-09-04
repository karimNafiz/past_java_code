# second implementation

# import random
# contactList = []


# def addContact(firstName, lastName, age, number):
#     temp = []
#     temp.append(firstName)
#     temp.append(lastName)
#     temp.append(age)
#     temp.append(number)
#     contactList.append(temp)


# Fname = ["nafiz", "mahir", "alif", "suji", "prottoy", "rezwan" , "fazlee"]
# Lname = ["karim", "asef", "hossain", "kumar", "mondol", "islam" , "rayhan"]
# age = [19, 20, 18, 14]
# number = [1234, 4567, 8911, 5468]

# if __name__ == '__main__':
#     print("hello world")
#     for i in range(10):
#         addContact(random.choice(Fname), random.choice(Lname),
#                    random.choice(age), random.choice(number))
#     print(contactList)


# class Test:

#     # String smth;
#     # int num;
#     # public test(String smth , int num)
#     # {
#     # this.smth = smth;
#     # this.num = num;
#     # }

#     def __new__(cls):
#         # if return smth
#         pass

#     def __init__(self, smth, num) -> None:
#         self.smth = smth
#         self.num = num

#     def testFunc(self):
#         print(self.newVar)

#     def __lt__(self , obj):
#         if self.num < obj.num:
#             self.smth = "string changed"

# t1 = Test("something", 19)

# t1.newVar = "new Var"
# t1.testFunc()
# t2 = Test("something", 19)

# print(t1 < t2)

# name1 = "alif"
# age1 = 14
# cnum1 = 178

# name2 = "alif"
# age2 = 14
# cnum2 = 178


# cList = []

# cList.append(name1)
# cList.append(name2)

person1 = []

person1.append("mahir")
person1.append(10)
person1.append(198)

person2 = []

person1.append("mahir2")
person1.append(102)
person1.append(1982)

contactList = []
contactList.append(person1)
contactList.append(person2)


def constructor(name, age, cNum):
    temp = []
    temp.append(name)
    temp.append(age)
    temp.append(cNum)
    return temp


contactList.append(constructor("ahnaf", 17, 875))

contactList.append(constructor("mushfiq", 17, 876))
contactList.append(constructor(17, "nafiz", 876))


person1 = {
    "name": "nafiz",
    "age": 20
}
person2 = {
    "name": "sujoy",
    "age": 20
}

person2["name"]


def constructor2(name, age, cNum):
    temp = {}
    temp["name"] = name
    temp["age"] = age
    # temp.append(cNum)
    return temp


person2["name"] = "fff"
