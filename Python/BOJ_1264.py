import sys
import re
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/testcase.txt', 'r')

while True:
    n = input()
    if n == '#':
        break
    else:
        p = re.compile('[aeiou]', re.I)
        print(len(p.findall(n)))
