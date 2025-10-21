-- 문제1: 각 직원의 이름과 그들이 속한 부서 이름을 조회하세요.
select 
	CONCAT(e.first_name, ' ', e.last_name) 이름,
    d.department_name 부서이름
from employees e 
join departments d on e.department_id = d.department_id;

-- 문제2: 모든 직원의 이름과 그들의 직무 타이틀을 조회하세요.
select
	CONCAT(e.first_name, ' ', last_name) 이름,
    j.job_title '직무 타이틀'
from employees e 
join jobs j on e.job_id = j.job_id;

-- 문제3: 모든 직원의 이름, 부서 이름 및 그들이 근무하는 국가 이름을 조회하세요.
select
	CONCAT(e.first_name, ' ', e.last_name) 이름,
    d.department_name 부서이름,
    c.country_name 국가이름
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
join countries c on l.country_id = c.country_id;

-- 문제4: 1999년 이후에 입사한 직원들과 그들의 직무 타이틀을 조회하세요.
select
	CONCAT(e.first_name, ' ', e.last_name) 이름,
    j.job_title '직무 타이틀',
    YEAR(hire_date) 입사년도
from employees e 
join jobs j on e.job_id = j.job_id
where YEAR(hire_date) >= 1999;

-- 문제5: 모든 직원의 이름과 그들이 근무한 지역 이름을 조회하세요.
select
	CONCAT(e.first_name, ' ', e.last_name) 이름,
    r.region_name 지역이름
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
join countries c on l.country_id = c.country_id
join regions r on c.region_id = r.region_id;

-- 문제6: 각 부서에서 근무하는 직원 수를 부서 이름과 함께 조회하세요.
select 
	d.department_name 부서이름,
    COUNT(e.department_id) 직원수
from departments d 
left join employees e on d.department_id = e.department_id
group by d.department_name
order by 1;

-- 문제7: 모든 지역(region)과 해당 지역에 위치한 국가들을 조회하세요.
select 
	r.region_name 지역,
    c.country_name 국가
from regions r
join countries c on r.region_id = c.region_id;

-- 문제8: 각 부서의 위치 정보와 해당 위치의 도시 이름을 조회하세요.
select
	d.department_name 부서이름,
	d.location_id 위치정보,
    l.city 도시
from departments d
join locations l on d.location_id = l.location_id
order by 1;

-- 문제9: 각 부서에서 근무하는 모든 직원의 이름과 부서 이름, 그리고 직무를 조회하세요.
select
	CONCAT(e.first_name, ' ', last_name) 이름,
    d.department_name 부서이름,
    j.job_title 직무
from employees e
join departments d on e.department_id = d.department_id
join jobs j on e.job_id = j.job_id;

-- 문제10: 각 직원의 이름과 그들의 입사 날짜, 그리고 그들이 근무한 모든 부서의 이름을 조회하세요.
select
	CONCAT(e.first_name, ' ', e.last_name) 이름,
    e.hire_date 입사날짜,
    d.department_name 부서이름
from employees e
join job_history jh on e.employee_id = jh.employee_id
join departments d on e.department_id = d.department_id;