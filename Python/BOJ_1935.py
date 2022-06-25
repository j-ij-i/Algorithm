
N = int(input())
sen = input()
alpha = [0] * N
stack = []
for i in range(N):
    alpha[i] = int(input())

for r in sen:
    if 'A' <= r <= 'Z':
        stack.append(alpha[ord(r)-ord('A')])
    else:
        a = stack.pop()
        b = stack.pop()
        if r == '*':
            stack.append(b*a)
        elif r == '+':
            stack.append(b+a)
        elif r == '-':
            stack.append(b-a)
        elif r == '/':
            stack.append(b/a)

print('%.2f' %stack[0])