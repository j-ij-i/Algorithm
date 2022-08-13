n = int(input())
arr1 = list(map(int,input().split()))
m = int(input())
arr2 = list(map(int,input().split()))

arr1.sort(reverse=True)
arr2.sort(reverse=True)

idx = 0
# 만약 arr1 max가 arr2 max보다 작으면 -1 출력

if arr2[0] > arr1[0]:
        idx = -1
else:
    while len(arr2) > 0:
        for_idx = 0
        for i in range(len(arr1)):
            if arr2 and arr1[i] < arr2[-1]:
                break
            for j in range(for_idx, len(arr2)):
                if arr2[j] <= arr1[i]:
                    arr2.pop(j)
                    break
                else:
                    continue
            for_idx = j
        idx += 1
print(idx)