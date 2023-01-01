from math import sqrt
def solution(n):
    sq = int(sqrt(n))
    if n == (sq**2):
        return (sq+1)**2
    else:
        return -1