def solution(s):
    answer = 0
    arr = list(s.split())
    stack = []
    for i in arr:
        if i == 'Z':
            stack.pop()
        else:
            stack.append(int(i))
    
    return sum(stack)