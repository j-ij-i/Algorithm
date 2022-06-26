
stick = input()
prev = '';
num = 0
result = 0
for n in stick:
    if n == '(':
       num += 1
    else:
        if prev == '(':
            num-=1
            result+=num
        else:
            num-=1
            result+=1

    prev=n

print(result)