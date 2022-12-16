m,n,k = map(int,input().split())

s_arr = list(map(int, input().split()))

button_list = list(map(int, input().split()))

result = False

for i in range(len(button_list)):
    if s_arr[0] == button_list[i]:
        cnt = 0
        for j in range(len(s_arr)):
            if i+j >= len(button_list):
                break
            else:
                if s_arr[j] == button_list[i+j]:
                    cnt += 1
        if cnt == len(s_arr):
            result = True
            break
if result:
    print("secret")
else:
    print("normal")