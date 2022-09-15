def solution(brown, yellow):
    answer = []
    x = 3
    y = 3
    total = brown + yellow
    
    for i in range(3, total):
        if total % i != 0:
            continue
        else:
            row = total // i
            col = i
            if row < col:
                continue
            row_brown = 4 + (col-2)*2 + (row-2)*2
            col_yellow = total - row_brown
            if brown == row_brown and yellow == col_yellow:
                answer.append(row)
                answer.append(col)
                break            
        
    return answer