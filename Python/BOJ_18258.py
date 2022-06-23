
import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
_list = []
popnum = 0
for i in range(N):
    cmd = input().split()
    num = 0
    if len(cmd) > 1:
        num = cmd[1]
    cmd = cmd[0]

    if cmd == 'push':
        _list.append(num)
    elif cmd == 'front':
        if len(_list)-popnum > 0:
            print(_list[popnum])
        else:
            print(-1)
    elif cmd == 'back':
        if len(_list)-popnum > 0:
            print(_list[-1])
        else:
            print(-1)
    elif cmd == 'size':
        print(len(_list)-popnum)
    elif cmd == 'empty':
        if len(_list)-popnum > 0:
            print(0)
        else:
            print(1)
    elif cmd == 'pop':
        if len(_list)-popnum > 0:
            print(_list[popnum])
            popnum += 1
        else:
            print(-1)


