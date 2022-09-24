
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
import re

def clean_text(inputString):
  text_rmv = re.sub('[=+,#/\?:^@*\"※~ㆍ<>&{}$%!』‘|\(\)\[\]`\'…》\”\“\’·]', '', inputString)
  return text_rmv

def solution(new_id):
    answer = ''
    # 1단계
    new_id = new_id.lower()

    # 2단계
    new_id = clean_text(new_id)

    # 3단계
    while '..' in new_id:
        new_id = new_id.replace('..','.')

    # 4단계
    new_id = new_id.strip(".")

    # 5단계
    if new_id == '':
        new_id = 'a'

    # 6단계
    if len(new_id) >= 16:
        new_id = new_id[0:15]
    if new_id[-1] == '.':
        new_id = new_id.rstrip('.')

    # 7단계
    while len(new_id)<=2:
        new_id += new_id[-1]

    return new_id