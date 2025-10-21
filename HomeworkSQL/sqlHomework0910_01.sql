# SELECT문 사용
-- employees 테이블에서 직원의 이름(first_name), 성(last_name)을 조회하세요.
SELECT 
	first_name 이름, 
	last_name 성
FROM employees;

-- departments 테이블에서 모든 부서의 이름(department_name)과 위치 ID(location_id)를 조회하세요.
SELECT 
	department_name 부서이름, 
    location_id 위치
FROM departments;

-- jobs 테이블에서 직업 ID(job_id)와 직업 타이틀(job_title)을 조회하세요.
SELECT
	job_id 직업ID,
    job_title 직업타이틀
FROM jobs;

-- locations 테이블에서 각 위치의 주소(street_address)와 우편번호(postal_code)를 조회하세요.
SELECT 
	street_address 주소,
    postal_code 우편번호
FROM locations;

-- countries 테이블에서 국가 ID(country_id)와 국가 이름(country_name)을 조회하세요.
SELECT
	country_id 국가ID,
    country_name 국가이름
FROM countries;

-- regions 테이블에서 지역 ID(region_id)와 지역 이름(region_name)을 조회하세요.
SELECT
	region_id 지역ID,
    region_name 지역이름
FROM regions;

-- employees 테이블에서 모든 직원의 직업 ID(job_id)를 조회하세요.
SELECT
	job_id 직업ID
FROM employees;

-- departments 테이블에서 부서 ID(department_id)별로 부서 이름(department_name)을 조회하세요.
SELECT
	department_id 부서ID,
    department_name 부서이름
FROM departments;

-- job_history 테이블에서 직원 ID(employee_id)와 부서 ID(department_id)를 조회하세요.
SELECT
	employee_id 직원ID,
    department_id 부서ID
FROM job_history;

-- employees 테이블에서 직원 ID(employee_id), 이름(first_name)과 성(last_name)을 조회하세요.
SELECT 
	employee_id 직원ID,
    first_name 이름,
    last_name 성
FROM employees;

# WHERE 구문 사용
-- employees 테이블에서 급여(salary)가 10000 이상인 직원의 이름과 급여를 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    salary 급여
FROM employees
WHERE salary >= 10000;

-- departments 테이블에서 위치 ID(location_id)가 1700인 부서의 이름을 조회하세요.
SELECT
	department_name 부서이름
FROM departments
WHERE location_id = 1700;

-- employees 테이블에서 직업 ID(job_id)가 'IT_PROG'인 직원들의 전체 정보를 조회하세요.
SELECT * FROM employees
WHERE job_id = 'IT_PROG';

-- employees 테이블에서 부서 ID(department_id)가 90인 직원들의 이름과 급여를 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    salary 급여
FROM employees
WHERE department_id = 90;

-- jobs 테이블에서 최소 급여(min_salary)가 5000 이상인 직업의 타이틀을 조회하세요.
SELECT job_title FROM jobs
WHERE min_salary >= 5000;

-- employees 테이블에서 성(last_name)이 'King'인 직원의 전체 정보를 조회하세요.
SELECT * FROm employees
WHERE last_name = 'King';

-- locations 테이블에서 국가 ID(country_id)가 'US'인 위치의 상세 정보를 조회하세요.
SELECT * FROM locations
WHERE country_id = 'US';

-- job_history 테이블에서 시작 날짜(start_date)가 '2001-01-01' 이전인 기록을 조회하세요.
SELECT * FROM job_history
WHERE start_date < '2001-01-01';

-- employees 테이블에서 성(last_name)에 'a'가 포함되는 직원들의 이름과 이메일을 조회하세요.
SELECT
	CONCAT(first_name, ' ', last_name) 이름,
    email 이메일
FROM employees
WHERE last_name LIKE '%a%';

-- departments 테이블에서 부서 이름(department_name)이 'Sales'인 부서의 모든 직원 정보를 조회하세요.
SELECT department_id, department_name FROM departments WHERE department_name = 'Sales'; # 80
SELECT * FROM employees WHERE department_id = 80;