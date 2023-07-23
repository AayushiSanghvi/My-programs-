import random

class Card:
    def __init__(self, number):
        self.number = number
        self.ducks = self.calculate_ducks()

    def calculate_ducks(self):
        if self.number % 11 == 0:
            return 5
        elif self.number % 10 == 0:
            return 3
        elif self.number % 5 == 0:
            return 2
        else:
            return 1

class Player:
    def __init__(self, name):
        self.name = name
        self.hand = []
        self.ducks = 0

    def play_card(self):
        card_index = int(input(f"{self.name}, choose a card to play (0-9): "))
        card = self.hand.pop(card_index)
        print(f"{self.name} played {card.number}")
        return card

def create_deck():
    deck = []
    for number in range(1, 105):
        card = Card(number)
        deck.append(card)
    random.shuffle(deck)
    return deck

def create_table_rows():
    rows = [[] for _ in range(4)]
    return rows

def print_table(rows):
    print("\nTable Rows:")
    for row in rows:
        row_numbers = [card.number for card in row]
        print(row_numbers)

def get_row_difference(card, row):
    return max(card.number - row[-1].number, 0)

def choose_best_row(card, rows):
    row_differences = [get_row_difference(card, row) for row in rows]
    min_difference = min(row_differences)
    best_row = row_differences.index(min_difference)
    return best_row

def play_round(players, deck, rows):
    for player in players:
        card = player.play_card()
        best_row_index = choose_best_row(card, rows)
        rows[best_row_index].append(card)

        if len(rows[best_row_index]) == 6:
            print(f"Row {best_row_index+1} is full!")
            player.ducks += sum(card.ducks for card in rows[best_row_index])
            rows[best_row_index] = []

        print_table(rows)

def calculate_scores(players):
    for player in players:
        player.ducks += sum(card.ducks for row in rows for card in row)
    players.sort(key=lambda x: x.ducks)

def play_game(num_players):
    players = []
    for i in range(num_players):
        name = input(f"Enter the name of player {i+1}: ")
        players.append(Player(name))

    deck = create_deck()
    rows = create_table_rows()

    for _ in range(10):
        for player in players:
            player.hand.append(deck.pop())

    while True:
        play_round(players, deck, rows)
        if all(len(player.hand) == 0 for player in players):
            break

    calculate_scores(players)

    print("\nGame Over!")
    print("Final Scores:")
    for player in players:
        print(f"{player.name}: {player.ducks} ducks")

    winner = players[0]
    if all(player.ducks >= 66 for player in players):
        winner = min(players, key=lambda x: x.ducks)

    print(f"\nCongratulations, {winner.name}! You are the winner!")

# Example usage:
num_players = int(input("Enter the number of players: "))
play_game(num_players)
