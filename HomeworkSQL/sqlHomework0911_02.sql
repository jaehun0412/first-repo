-- 문제 1: 각 부서의 평균 급여를 조회하세요.
select
	d.department_name 부서이름,
    avg(e.salary) 평균급여
from departments d
join employees e on d.department_id = e.department_id
group by d.department_name
order by 2 desc; 

-- 문제 2: 최고 급여를 받는 직원의 이름과 급여를 조회하세요.
select 
	CONCAT(first_name, ' ', last_name) 이름,
    salary 급여
from employees
where salary = (
	select MAX(salary) from employees
);

-- 문제 3: 각 부서에서 근무하는 직원 수를 조회하세요.
select
	d.department_name 부서이름,
    COUNT(e.employee_id) 직원수
from departments d
left join employees e on d.department_id = e.department_id
group by d.department_name
order by 1;

-- 문제 4: 각 직원의 이름, 직무 타이틀, 부서 이름을 조회하세요.
select
	CONCAT(e.first_name, ' ', e.last_name) 이름,
    j.job_title '직무 타이틀',
    d.department_name '부서 이름'
from employees e
join jobs j on e.job_id = j.job_id
join departments d on e.department_id = d.department_id;

-- 문제 5: 각 직원의 입사일로부터 경과한 일수를 조회하세요.
select
	CONCAT(first_name, ' ', last_name) 이름,
	hire_date 입사일,
    DATEDIFF(now(), hire_date) '경과 일수'
from employees;

-- 문제 6: 모든 직원의 이름과 그들의 매니저 이름을 조회하세요.
select
	e.employee_id 직원번호,
	CONCAT(e.first_name, ' ', e.last_name) 직원이름,
    m.employee_id 매니저번호,
    CONCAT(m.first_name, ' ', m.last_name) 매니저이름
from employees e
join employees m on e.manager_id = m.employee_id;

-- 문제 7: 국가 코드가 'US'인 모든 위치의 도시 이름을 조회하세요.
select
	country_id 국가코드,
    city 도시
from locations
where country_id = 'US';

-- 문제 8: 2005년 이후에 입사한 모든 직원의 이름과 입사 날짜를 조회하세요.
select
	CONCAT(first_name, ' ', last_name) 이름,
    hire_date 입사날짜
from employees
where YEAR(hire_date) >= 2005;
# 2005년 이후 입사자가 없는 것이 맞는지 검증
select * from employees order by hire_date desc;

-- 문제 9: 각 직원의 전체 이름과 이메일을 조회하세요.
select
	CONCAT(first_name, ' ', last_name) 이름,
    email 이메일
from employees;

-- 문제 10: 직업이 'IT_PROG'인 직원들의 이름과 급여를 조회하세요.
select
	j.job_id 직업,
    CONCAT(e.first_name, ' ', e.last_name) 이름,
    e.salary 급여
from jobs j
join employees e on j.job_id = e.job_id
where j.job_id = 'IT_PROG';