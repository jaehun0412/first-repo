// 학생 정보를 담은 객체를 만드세요
// 포함할 정보: 이름, 나이, 학년, 좋아하는 과목들(배열)

// 그리고 다음 작업들을 해보세요:
// 1. 학생의 이름을 출력하기
// 2. 학생의 나이를 1살 증가시키기
// 3. 새로운 과목을 좋아하는 과목 배열에 추가하기
// 4. 학생 정보를 모두 출력하기

const student = {
  name: "홍길동",
  age: 20,
  grade: 1,
  favoriteSubject: ["체육", "수학"],
};

console.log(student.name);

student.age++;

student.favoriteSubject.push("음악");

console.log(student);
