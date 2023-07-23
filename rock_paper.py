import random
user_wins = 0
computer_wins = 0
user_input=input('enter r or  p or s. Press q to quit the game")
user_input.lower()
if user_input == "q":
    quit
else:
    a = ['r', 'p', 's']
    if user_input is in a:
        random.choice(a)
        if user_input == a:
            print("you win!")
            else"
            print("you looze")
    if user_input not in ['r', 'p', 's']:
        continue:

