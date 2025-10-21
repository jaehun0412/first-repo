# 문자 함수
-- 직원의 성(last_name)을 대문자로 변환하여 조회하기:
SELECT
	UPPER(last_name)
FROM employees;

-- 직원의 이름(first_name)의 첫 글자를 추출하기:
SELECT
	first_name 이름,
    SUBSTRING(first_name, 1, 1) 첫글자
FROM employees;

-- 직원의 성(last_name)에서 'a'가 몇 번 나오는지 세기:
SELECT
	last_name 성,
    LENGTH(last_name) - LENGTH(REPLACE(last_name, 'a', '')) 'a 등장 횟수'
FROM employees;

-- 직원의 이메일에서 도메인 부분만 추출하기 (@ 이후 문자열):
SELECT
	email 이메일,
    SUBSTRING_INDEX(email, '@', -1) 도메인
FROM employees;

-- 직원의 전체 이름을 성과 이름으로 구분하여 조회하기:
SELECT
	CONCAT(first_name, ' ', last_name),
    last_name,
    SUBSTRING_INDEX(CONCAT(first_name, ' ', last_name), ' ', -1) 성,
    first_name,
    SUBSTRINg_INDEX(CONCAT(first_name, ' ', last_name), ' ', 1) 이름
FROM employees;

-- 직원의 이름(first_name)에서 세 번째 문자부터 세 글자 가져오기:
SELECT
	first_name 이름,
    SUBSTRING(first_name, 3, 3) '세 번째 문자부터 세 글자'
FROM employees;

-- 모든 직원의 성(last_name)을 쉼표와 공백 후 이름(first_name)으로 표시하기:
SELECT
	last_name 성,
    first_name 이름,
    CONCAT(last_name, ', ', first_name) 변환이름
FROM employees;

-- 직원의 이름(first_name)의 길이를 구하여 조회하기:
SELECT
	first_name 이름,
    LENGTH(first_name) '이름의 길이'
FROM employees;

-- 직원의 성(last_name)이 'King'인 직원 찾기 (대소문자 구분 없이):
SELECT * FROM employees
WHERE LOWER(last_name) = 'king';

-- 직원의 성(last_name) 중 'M'으로 시작하는 사람들의 수 구하기:
SELECT COUNT(*) AS '성이 M으로 시작하는 사람들의 수' FROM employees
WHERE SUBSTRING(last_name, 1, 1) = 'M';