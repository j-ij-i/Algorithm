-- 코드를 입력하세요
SELECT NAME, COUNT(NAME)'COUNT' FROM ANIMAL_INS GROUP BY NAME HAVING COUNT(NAME) > 1 ORDER BY NAME;