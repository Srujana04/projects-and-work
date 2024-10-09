import random

lower, upper = input("Enter range: ").split()
lower, upper = int(lower), int(upper)
n = 10
systemNumber = random.randint(lower, upper + 1)
userNumber = int(input(f"Enter a number in the range {lower} to {upper}: "))
while n != 0:
    if userNumber > upper or userNumber < lower:
        userNumber = int(input(f"You're going out of bound! Try again within the range {lower} to {upper}: "))
    else:
        if userNumber == systemNumber:
            print("Congratulations! You guessed it right!")
            break
        elif userNumber > systemNumber:
            userNumber = int(input("Too high! Try again! Enter your guess: "))
        else:
            userNumber = int(input("Too low! Try again! Enter your guess: "))
    if n == 1:
        print("Sorry, you've exhausted all your trials! :(")
    n -= 1
