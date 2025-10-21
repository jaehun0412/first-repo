# 멋쟁이 사자처럼 백엔드 스쿨 과제 제출 - 0821 과제
## 수강생 정보
- 이름: 김재훈
- 기수: 19기
- 트랙: 백엔드 스쿨
- GitHub: https://github.com/jaehun0412
## 과제 개요
**Java 기초**를 활용한 문제 해결 과제
## 개발 환경
- 언어: Java 21
- IDE: IntelliJ IDEA
- 운영체제: Mac OS
## 파일 구조
```mathematica
hw1/
├── README.md
├── step1/
│   ├── question01/
│   │   ├──Question01
│   │   └──result.txt
│   ├── question02/
│       ├──Question02
│       └──result.txt
├── step2/
│   ├── question03/
│   │   ├──Question03
│   │   └──result.txt
│   ├── question04/
│   │   ├──Question04
│   │   └──result.txt
│   ├── question05/
│       ├──Question05
│       └──result.txt
├── step3/
│   ├── question06/
│   │   ├──Question06
│   │   └──result.txt
│   ├── question07/
│       ├──Question07
│       └──result.txt
└── step4/
    ├── question08/
    │   ├──Question06
    │   └──result.txt
    ├── question09/
    │   ├──Question09
    │   └──result.txt
    └── question10/
        ├──Question10
        └──result.txt
```
## 문제별 현황
### 문제1: 홀짝 판별 프로그램
- 파일: Question01.java
- 상태: ✅ 완료
- 실행 방법: java Question01 또는 IDE 직접 실행
- 핵심 개념: 변수와 조건문
- 배운점: 삼항 연산자 활용
### 문제2: 가장 큰 수 출력
- 파일: Question02.java
- 상태: ✅ 완료
- 실행 방법: java Question02 또는 IDE 직접 실행
- 핵심 개념: 변수와 조건문
- 배운점: 조건문의 활용 (배열을 활용하는 것이 더 효율적일 것 같다.)
### 문제3: 1부터 100까지의 합
- 파일: Question03.java
- 상태: ✅ 완료
- 실행 방법: java Question03 또는 IDE 직접 실행
- 핵심 개념: 반복문
- 배운점: 반복문의 활용
### 문제4: 구구단 출력
- 파일: Question04.java
- 상태: ✅ 완료
- 실행 방법: java Question04 또는 IDE 직접 실행
- 핵심 개념: 반복문
- 배운점: 반복문 활용과 반복문 내에서의 출력 방법
### 문제5: 특정 조건 수 출력
- 파일: Question05.java
- 상태: ✅ 완료
- 실행 방법: java Question05 또는 IDE 직접 실행
- 핵심 개념: 반복문과 조건문
- 배운점: 조건문 내에서 and 조건과 or 조건 활용
### 문제6: 배열의 최대값과 최소값
- 파일: Question06.java
- 상태: ✅ 완료
- 실행 방법: java Question06 또는 IDE 직접 실행
- 핵심 개념: 배열과 반복문
- 배운점: 최대값과 최소값을 배열의 0번 인덱스로 지정하면 반복문에서 0번째 인덱스는 확인하지 않아도 된다.
### 문제7: 배열 안에 존재 여부
- 파일: Question07.java
- 상태: ✅ 완료
- 실행 방법: java Question07 또는 IDE 직접 실행
- 핵심 개념: 배열
- 배운점: 반복문 내에서 break 사용 시 반복을 종료하고 반복문을 탈출한다.
### 문제8: 학생 정보 출력
- 파일: Question08.java
- 상태: ✅ 완료
- 실행 방법: java Question08 또는 IDE 직접 실행
- 핵심 개념: 조건문, 반복문, 배열, 형변환
- 배운점: int형으로 저장한 총 점수를 평균으로 구할 때는 나눗셈이 들어가므로 double형으로 형변환이 필요하다.
### 문제9: 숫자 맞추기 게임
- 파일: Question09.java
- 상태: ✅ 완료
- 실행 방법: java Question09 또는 IDE 직접 실행
- 핵심 개념: 조건문, 반복문, 랜덤
- 배운점: continue를 사용하면 현재 반복을 종료하고 다음 반복을 시작한다.
  - new Random().nextInt(bound)를 사용하면 0이상 bound 미만의 랜덤 정수를 생성하고, +1을 해주면 1이상 bound+1 미만으로 생성한다. 
### 문제10: 로또 번호 생성기
- 파일: Question10.java
- 상태: ✅ 완료
- 실행 방법: java Question10 또는 IDE 직접 실행
- 핵심 개념: 조건문, 반복문, 배열, 랜덤
- 배운점: 배열에 중복값을 넣지 않기 위한 조건문 생성과 Arrays.sort()를 통한 배열의 정렬
## 궁금한 점
~~~1. `Question05`에서 반복문을 출력할 때 마지막 반복문 뒤에는 `,`가 오지 않도록 하는 방법~~~
   1. 우선 StringBuilder와 delete 메서드를 사용해 마지막 부분을 지우는 방법을 사용했다.
   2. 또 다른 방법은 어떤 것이 있을까? => StringJoiner 클래스를 사용해서 해결할 수 있다!! (구현 완료)