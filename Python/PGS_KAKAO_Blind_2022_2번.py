def solution(n, k):
    answer = 0
    
    def convert_iter(num, base):
        power = 0
        tmp = ''
        while num:
            tmp = str(num%base) + tmp
            num //= base
        return tmp
    num = str(convert_iter(n,k))
    for i in range(len(num)):
        str_num = ''
        for j in range(len(num)):
            if i + j >= len(num):
                break
            else:
                str_num += "{}".format(num[i+j])
                if len(str_num.strip("0")) != len(str_num):
                    break
                if is_prime_number(int(str_num)):
                    if (i-1<0 and j+1 >= len(num)):
                        answer += 1
                    elif (i-1<0 and num[i+j+1] == '0') :
                        answer += 1
                    elif (i+j+1 >= len(num) and num[i-1] == '0'):
                        answer += 1
                    elif (num[i-1] == '0' and num[i+j+1] == '0'):
                        answer += 1
                           
    return answer

def is_prime_number(n):
    if n == 1:
        return False
    for i in range(2, int(n**(1/2))+1):
        if n % i == 0:
            return False
    return True