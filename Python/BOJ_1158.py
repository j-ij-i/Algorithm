

from collections import deque

N, K = map(int, input().split())
_list= []
q = deque([i+1 for i in range(N)])

while len(q) != 0:
    q.rotate(-K)
    _list.append(q.pop())


print('<'+'. '.join(map(str,_list))+'>')