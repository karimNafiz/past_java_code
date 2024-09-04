import random


class TreasureChest:
    def __init__(self, question, answer, points) -> None:
        self.question = question
        self.answer = answer
        self.points = points
        self.attempts = 0

    def setCordinates(self, x, y):
        self.x = x
        self.y = y

    @staticmethod
    def constructor(question, answer, points):
        return TreasureChest(question, answer, points)

    def getQuestion(self):
        print(self.question)

    def getAns(self, answer):
        if(self.answer == answer):
            self.attempts += 1
            return self.getPoints(self.attempts)
        else:
            self.attempts += 1

    def getPoints(self, attempts):
        temp = self.attempts
        self.attempts = 0
        return self.points - self.attempts


class Player:
    def __init__(self, x, y) -> None:
        self.x = x
        self.y = y


class GameBoard:
    gameBoard = []
    rows = 0
    columns = 0
    sadPlayer = None
    noOfT = random.randint(1, 4)
    listOfT = []
    print(noOfT)
    for i in range(noOfT):
        question = input("enter question ")
        print()
        answer = input("enter answer ")
        print()
        points = input("enter points")
        listOfT.append(TreasureChest(question, answer, points))

    @classmethod
    def setRowCol(cls, rows, cols):
        cls.rows = rows
        cls.columns = cols

    @classmethod
    def setBoard(cls):
        for i in range(cls.rows):
            cls.gameBoard.append([])
            for j in range(cls.columns):
                cls.gameBoard[i].append('*')

        for T in cls.listOfT:
            T.setCordinates(random.randint(1, cls.rows - 1),
                            random.randint(1, cls.columns - 1))
            cls.gameBoard[T.x][T.y] = "T"

    @classmethod
    def drawBoard(cls):
        # cls.setBoard()
        if cls.sadPlayer != None:
            cls.gameBoard[cls.sadPlayer.x][cls.sadPlayer.y] = "P"
        for columns in cls.gameBoard:
            for grid in columns:
                print("[{}]".format(grid), end=" ")
            print()
        print()

    @classmethod
    def setPlayer(cls, x, y):
        cls.sadPlayer = Player(x-1, y-1)

    @classmethod
    def gameLoop(cls):
        while True:
            x, y, direction = input("pls enter steps for player in x and y")
            cls.gameBoard[cls.sadPlayer.x][cls.sadPlayer.y] = "*"
            if direction == 'l':
                if(cls.sadPlayer.x + 1 - int(y) < 0) or (cls.sadPlayer.y + 1 - int(x) < 0):
                    print("invalid moves try again")
                    continue
                else:
                    cls.sadPlayer.x -= int(y)
                    cls.sadPlayer.y -= int(x)

            else:
                if(cls.sadPlayer.x + 1 + int(y) > cls.rows) or (cls.sadPlayer.y + 1 + int(x) > cls.columns):
                    print("invalid moves try again")
                    continue
                else:
                    cls.sadPlayer.x += int(y)
                    cls.sadPlayer.y += int(x)
            cls.drawBoard()


GameBoard.setRowCol(5, 5)
GameBoard.setPlayer(4, 4)
GameBoard.setBoard()
GameBoard.drawBoard()
GameBoard.gameLoop()
