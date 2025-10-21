# 날짜형 함수 사용
-- employees 테이블에서 각 직원의 입사 연도(year)를 조회하세요.
SELECT
	first_name 이름,
    last_name 성,
    email 이메일,
    phone_number 휴대폰번호,
    YEAR(hire_date) 입사년도
FROM employees;

## TODO
-- job_history 테이블에서 각 기록의 근무 기간을 월(months) 단위로 계산하세요.
SELECT
	start_date 시작날짜,
    end_date 종료날짜,
    (YEAR(end_date) - YEAR(start_date)) * 12
		+ (MONTH(end_date) - MONTH(start_date)) '근무기간(월)'
FROM job_history;

-- employees 테이블에서 오늘로부터 입사한 지 30년이 된 직원들의 이름과 입사 날짜를 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    hire_date 입사날짜
FROM employees
WHERE (YEAR(NOW()) - YEAR(hire_date)) = 30;

-- employees 테이블에서 이번 달이 입사월인 직원들의 이름과 이메일을 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    email 이메일,
    hire_date 입사일
FROM employees
WHERE MONTH(hire_date) = MONTH(NOW());

-- employees 테이블에서 입사 날짜가 최근 30년 이내인 직원들의 이름과 입사 날짜를 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    hire_date 입사날짜
FROM employees
WHERE (YEAR(NOW()) - YEAR(hire_date)) <= 30;


-- job_history 테이블에서 직원이 특정 부서에 근무한 기간을 일(days) 단위로 조회하세요. 
SELECT
	employee_id 직원ID,
	DATEDIFF(end_date, start_date) '근무기간(일)'
FROM job_history;

-- employees 테이블에서 가장 오래전에 입사한 직원의 이름과 입사 날짜를 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    hire_date 입사날짜
FROM employees
WHERE hire_date = (
	SELECT MIN(hire_date)
    FROM employees
);

-- employees 테이블에서 각 직원의 입사일로부터 경과한 일수를 조회하세요.
SELECT
	hire_date 입사일,
	DATEDIFF(NOW(), hire_date) 경과일수
FROM employees;

-- job_history 테이블에서 1999년도에 시작된 모든 근무 기록을 조회하세요.
SELECT * FROM job_history
WHERE YEAR(start_date) = 1999;

-- employees 테이블에서 각 직원의 입사 날짜를 요일로 표시하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
	hire_date 입사날짜,
    DAYOFWEEK(hire_date) 입사요일
FROM employees;

# 숫자형 함수 사용
-- employees 테이블에서 각 직원의 급여에 10% 인상된 금액을 계산하여 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    salary 현재급여,
    salary + (salary * 0.1) '10% 인상된 급여'
FROM employees;

-- jobs 테이블에서 각 직업의 최소 급여와 최대 급여의 차이를 계산하세요.
SELECT
	job_id 직업ID,
    job_title 직업이름,
    min_salary 최소급여,
    max_salary 최대급여,
    (max_salary - min_salary) 차이
FROM jobs;

-- employees 테이블에서 각 직원의 급여를 원화(KRW)로 환산하여 조회하세요 (환율 가정: 1 USD = 1200 KRW).
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    salary 급여,
    salary * 1200 원화
FROM employees;

-- employees 테이블에서 전체 직원의 평균 급여보다 높은 급여를 받는 직원들의 이름과 급여를 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    salary 급여
FROM employees
WHERE salary > (
	SELECT AVG(salary)
    FROM employees
);

-- employees 테이블에서 각 직원의 급여에서 평균 급여를 뺀 금액을 계산하여 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    salary 급여,
    salary - (
		SELECT AVG(salary)
        FROM employees) '평균 급여를 뺀 금액'
FROM employees;

-- employees 테이블에서 급여의 표준 편차를 계산하여 조회하세요.
# 표준편차 구하기 -> 평균 구하기 -> 편차 구하기(평균 빼기) -> 편차 제곱하기 -> 분산 구하기(자료의 개수로 나누기) -> 표준 편차 구하기(분산에 제곱근)
SELECT
	SQRT(
		AVG(POWER(
		salary - (SELECT AVG(salary) FROM employees), 2))) '급여 표준 편차'
FROM employees;

-- employees 테이블에서 각 직원의 연봉을 계산하고, 연봉이 가장 높은 순으로 정렬하여 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    salary 급여,
    salary * 12 연봉
FROM employees
ORDER BY 연봉 DESC;

-- job_history 테이블에서 각 기록에 대해 부서 변경 횟수를 계산하세요.
SELECT
	employee_id 직원ID,
    COUNT(*) '부서 변경 횟수'
FROM job_history
GROUP BY employee_id;

-- employees 테이블에서 직원들의 급여를 오름차순으로 정렬하여 조회하세요.
SELECT * FROM employees
ORDER BY salary;