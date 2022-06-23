N = int(input())

stack = []

for i in range(N):
    cmd = input().split()
    x = 0

    if len(cmd) > 1:
        x = cmd[1]
    cmd = cmd[0]

    if cmd == "push":
        stack.append(x)
    elif cmd == "pop":
        if len(stack) == 0:
            print(-1)
        else:
            print(-1)
            stack.pop(-1)


