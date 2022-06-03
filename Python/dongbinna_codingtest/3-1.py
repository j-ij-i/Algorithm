n = 1260
count = 0
coins_type = [500, 100, 50, 10]

for coin in coins_type:
    count += n // coin
    n %= coin

print(count)

# / 소수점 나옴
# // 소수점 안나옴
# % 나머지는 같음