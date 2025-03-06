# Given tuple
# num_tuple = (10, 20, 33, 46, 55)
# Taking input and converting each element to an integer manually
user_input = input("Enter a sequence of comma-separated values: ").strip().split(",")
num_tuple = tuple(int(num.strip()) for num in user_input)  # Convert each item to int
print("Given list is ", num_tuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)