import sys
from xml.etree.ElementInclude import include
sys.stdin = open(
    '/Users/sunm/Workspace/Algorithm/testcase.txt', 'r')

vowel =  ['a','e','i','o','u']
double = ['e','o']

while True:
    n = input()
    flag = True
    if n == 'end':
        break
    else:
        flag1 = False
        flag2 = False
        flag3 = False

        if flag:
            wordArr = (list(n))
            if not len(list(set(wordArr) & set(vowel))):
                flag = False
        
        prev = ''
        if flag:
            for i in wordArr:
                if i == prev and i not in double:
                    flag = False
                    break
                else:
                    prev = i

        if flag:
            vowelflag = 0
            for i in wordArr:
                if i in vowel:
                    if vowelflag == 2:
                        flag = False
                        break
                    elif vowelflag < 0:
                        vowelflag = 1
                    else:
                        vowelflag += 1
                else:
                    if vowelflag == -2:
                        flag = False
                        break
                    elif vowelflag > 0:
                        vowelflag = -1
                    else:
                        vowelflag -= 1



        if flag:
            print(f'<{n}> is acceptable.')
        else:
            print(f'<{n}> is not acceptable.')