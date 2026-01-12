import random
import sys


def generate_value(value):
        sequence = ''
        if value > 200 or value < 1:
            print("Write number of steps between 1 and 200.\nUsage example: python3 genSequence.py 10")
            exit()
        options = [" U", " F", " R", " B", " L", " D", " U'", " F'", " R'", " B'", " L'", " D'",
                   " U2", " F2", " R2", " B2", " L2", " D2"]
        for val in range(value):
            sequence += random.choices(options)[0]
        return sequence


if __name__ == '__main__':
    print(len(sys.argv[1]))
    if len(sys.argv) != 2:
        print("Write number of steps as argument.\nUsage example: python3 genSequence.py 10")
    else:

        value = int(sys.argv[1])
        print(generate_value(value))

