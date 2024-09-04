class Block:
    def __init__(self, value, isNew) -> None:
        self.value = value
        self.isNew = isNew


leftTest = [Block(2, False), Block(2, False), Block(2, False), Block(2, False)]


def addAndSwapp():
    for _ in range(4):

        for i in range(4):

            if i - 1 < 0:
                continue

            bCur = leftTest[i-1]
            Cur = leftTest[i]

            if bCur.value == Cur.value and not bCur.isNew:
                bCur.isNew = True
                Cur.isNew = True
                bCur.value *= 2
                Cur.value = 0

            elif bCur.value == 0 and Cur.value != 0:
                bCur.value = Cur.value
                bCur.isNew = False
                Cur.isNew = True
                Cur.value = 0
    for block in leftTest:
        print(block.value, end=" ")
    print()


addAndSwapp()


# def addLeft():
#     for i in range(4):
#         if i - 1 < 0:
#             continue
#         bCur = leftTest[i - 1]
#         Cur = leftTest[i]

#         if bCur.value == Cur.value:
#             bCur.value += Cur.value
#             Cur.value = 0

#     for block in leftTest:
#         print(block.value, end=" ")
#     print()


# def swapLeft():
#     temp = None
#     spaces = 0

#     for i in range(4):

#         if leftTest[i].value != 0:
#             print("value of i ", i)
#             print("value of spaces ", spaces)
#             if temp != None:
#                 if i - 1 >= 0:
#                     # temp1 = leftTest[i]
#                     # leftTest[i] = leftTest[i - spaces]
#                     # leftTest[i-spaces] = temp1
#                     print("value of i - spaces", (i-spaces))
#                     leftTest[i-spaces].value = leftTest[i].value
#                     leftTest[i].value = 0
#             elif temp == None and spaces != 0:
#                 print("inside second elif")
#                 if i - 1 >= 0:
#                     leftTest[i-spaces].value = leftTest[i].value
#                     leftTest[i].value = 0
#             # else:
#             #     temp = leftTest[i]
#         else:
#             spaces += 1
#     for block in leftTest:
#         print(block.value, end=" ")
#     print()


# addLeft()
# swapLeft()

# print("in the method")
# temp = None
# # start = 3
# spaces = 0
# for i in range(4):
#     if leftTest[i].value != 0:
#         if temp != None:
#             # leftTest[start + spaces] = temp
#             print("value of i ", i)
#             print("value of spaces ", spaces)
#             leftTest[i - spaces].value = leftTest[i].value
#             leftTest[i].value = 0
#             leftTest[i].isNew = True
#             leftTest[i - spaces].isNew = False
#             pass
#         temp = leftTest[i]
#         # spaces -= 1
#         # start = i
#         spaces = 0
#     # elif leftTest[i].value == 0 and temp != None:
#     #     spaces += 1
#     else:
#         spaces += 1
# for block in leftTest:
#     print(block.value, end=" ")
# print()
# addLeft()
# swapLeft()


# def swapLeft():
#     for _ in range(4):
#         for i in range(4):
#             if i - 1 < 0:
#                 continue
#             bCur = leftTest[i-1]
#             Cur = leftTest[i]
#             if bCur.isNew and not Cur.isNew:
#                 bCur.isNew = False
#                 Cur.isNew = True
#                 bCur.value = Cur.value
#                 Cur.value = 0
#             elif bCur.value == Cur.value:
#                 bCur.value += Cur.value
#                 Cur.value = 0
#                 Cur.isNew = True
#             for block in leftTest:
#                 print(block.value, end=" ")
#             print()


# swapLeft()
