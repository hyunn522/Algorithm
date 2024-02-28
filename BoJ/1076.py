first_color = input()
second_color = input()
third_color = input()

result = 0

color_map = [
    'black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet',
    'grey', 'white'
]

if first_color in color_map:
  result += 10 * color_map.index(first_color)

if second_color in color_map:
  result += color_map.index(second_color)

if third_color in color_map:
  result *= 10**color_map.index(third_color)

print(result)
