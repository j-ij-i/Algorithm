import re

txt = input()
result = re.split('(?=[A-Z])',txt)
cnt = 0
for i in range(1, len(result)-1):
    n = (len(result[i])) % 4
    if n != 0: cnt += 4-n
print(cnt)