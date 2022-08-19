import itertools

def factorial(n):
    num = 1
    for i in range(1,n+1):
        num *= i
    return num

t = int(input())

memo = []
for _ in range(t):
    n, m = tuple(map(int, input().split()))
    result = factorial(m) // (factorial(n) * factorial(m-n))
    print(result)