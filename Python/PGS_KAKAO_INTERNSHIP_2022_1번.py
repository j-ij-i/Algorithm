def solution(survey, choices):
    answer = ''

    result = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0}

    for i in range(len(survey)):
        if choices[i] > 4:
            result[survey[i][1]] += choices[i] - 4
        elif choices[i] < 4:
            result[survey[i][0]] += (choices[i]) + (4 + (-2 * (choices[i])))

    answer += ('R') if result['R'] >= result['T'] else ('T')
    answer += ('C') if result['C'] >= result['F'] else ('F')
    answer += ('J') if result['J'] >= result['M'] else ('M')
    answer += ('A') if result['A'] >= result['N'] else ('N')

    return answer