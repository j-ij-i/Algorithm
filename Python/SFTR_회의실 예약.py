import sys
from collections import defaultdict

n, m= map(int, input().split())

meeting_name = defaultdict()
meeting_res_list = [[0 for _ in range(9)] for _ in range(n)]

for i in range(n):
    room_name = input()
    meeting_name[room_name] = i

for _ in range(m):
    name, start, end = input().split()
    for i in range( int(start)-9, int(end)-9):
        meeting_res_list[meeting_name[name]][i] = -1

meeting_name_sorted = (sorted(meeting_name.keys()))
total_cnt = 0
for key in meeting_name_sorted:
    print(f"Room {key}:")
    cnt = 0
    arr = []
    m_key = meeting_name[key]
    times = ''
    flag = False
    for meet in range(9):
        if not flag and meeting_res_list[m_key][meet] == 0:
            flag = True
            if meet == 0:
                times += "09"
            else:
                times += str(meet+9)
            times += '-'
        elif flag and meeting_res_list[m_key][meet] == 0:
            continue
        elif flag and meeting_res_list[m_key][meet] == -1:
            times += str(meet+9)
            arr.append(times)
            times = ''
            flag = False
            cnt += 1
    if flag:
        times += "18"
        arr.append(times)
        cnt += 1
    if cnt == 0:
        print("Not available")
    else:
        print(f"{cnt} available:")
        for time in arr:
            print(time)
    total_cnt+=1            
    if total_cnt < n:
        print("——")
    