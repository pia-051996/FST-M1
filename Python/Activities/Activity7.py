numbers = list(input("Enter a sequence of comma separated values: ").strip().split(","))
sum = 0

for number in numbers:
  sum += int(number)

print(sum)