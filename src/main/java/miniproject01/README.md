# 멋쟁이 사자처럼 백엔드 스쿨 첫 번째 미니 프로젝트
## 수강생 정보
- 이름: 김재훈
- 기수: 19기
- 트랙: 백엔드 스쿨
- GitHub: https://github.com/jaehun0412
## 프로젝트 주제
콘솔 도서 관리 프로그램
## 개발 환경
- 언어: Java 21
- IDE: IntelliJ IDEA
- 운영체제: Mac OS
## 파일 구조
```mathematica
miniproject01/
├── README.md
├── book
│   ├── repository -- BookRepository, MemoryBookRepository 
│   └── Book
├── member
│   ├── repository -- MemberRepository, MemoryMemberRepository 
│   └── Member
├── library
│   ├── service -- LibraryService, LibraryServiceImpl
│   └── Library
├── generator -- BookIdGenerator, MemberIdGenerator, MenuGenerator  
├── validator -- BookValidator, MemberValidator
└── LibraryMain
```
## 프로젝트 개요
### 구현할 기능
- 콘솔 창에서 다음과 같은 기능을 선택하여 실행할 수 있다. 메뉴는 숫자로만 입력될 수 있으며, 문자가 입력되거나 범위를 벗어난 숫자가 입력될 경우 오류 메시지와 함께 메뉴 선택으로 되돌아간다.
    - **1. 회원 추가**: 이름과 전화번호, 생년월일을 입력받아 회원을 저장한다. 이미 등록된 회원일 경우 안내 문구를 출력한다.
    - **2. 도서 추가**: 도서 제목과 저자를 입력받아 도서를 저장한다.
    - **3. 회원 목록 조회**: 등록된 모든 회원 목록을 출력한다. 등록된 회원이 없을 경우 안내 문구를 출력한다.
    - **4. 도서 목록 조회**: 등록된 모든 도서 목록을 대여 상태와 함께 출력한다. 등록된 도서가 없을 경우 안내 문구를 출력한다.
    - **5. 회원 검색**: 이름을 입력받아 해당 이름의 회원을 출력한다. 영어는 대소문자를 구분하지 않는다. 등록된 회원이 없을 경우 안내 문구를 출력한다.
    - **6. 도서 검색**: 제목을 입력받아 해당 제목이 포함된 모든 도서를 출력한다. 영어는 대소문자를 구분하지 않는다. 등록된 도서가 없을 경우 안내 문구를 출력한다.
    - **7. 도서 대여**: 도서 ID를 입력받아 대여 상태로 변경한다. 등록된 도서가 없거나 해당 도서가 대여 중일 경우 안내 문구를 출력한다.
    - **8. 도서 반납**: 도서 ID를 입력받아 반납 상태로 변경한다. 등록된 도서가 없어 반납 받을 도서가 없거나 이미 반납된 도서일 경우 안내 문구를 출력한다.
    - **9. 대여 중인 도서 목록**: 대여 중인 도서 목록과 대여 중인 회원을 출력한다. 대여 중인 도서가 없을 경우 안내 문구를 출력한다.
    - **10. 종료**: 프로그램을 종료한다. 미반납 도서가 있을 경우 강제 종료를 물어본다.
## 클래스 설계
### Book (class)
- **속성(Fields)**
  - `bookId`: 도서 번호 (Long)
  - `title`: 도서 제목 (String)
  - `author`: 저자 (String)
  - `isRented`: 대여 상태 (boolean, true일 경우 대여 중)
- **기능(Methods)**
  - 생성자 (제목, 저자): 도서 번호는 자동 생성, 대여 상태는 `flase`(대여 가능)으로 초기화
  - Getter, Setter: `isRented`는 외부에서 상태 변경이 필요하므로 유일한 Setter
  - toString: 도서 정보를 가독성 좋게 출력하기 위해 오버라이딩
### BookRepository (interface)
- **기능(Methods)**
  - `void addBook(Book book)`
  - `void listAllBooks()`
  - `void getBooksByTitle(String title)`
  - `Book getBookById(Long bookId)`
  - `boolean isEmpty()`

[//]: # (  - `getBooksByAuthor&#40;&#41;`)
### MemoryBookRepository (class)
- `BookRepository의` 구현체로 메모리에 도서 정보를 관리한다.
- `bookMap<Long, Book>`을 가지고 있고. 도서 번호로 도서를 관리한다.

[//]: # (### TODO: FileBookRepository &#40;class&#41;)

[//]: # (- BookRepository의 구현체로 파일에 도서 정보를 관리한다. )
### Member (class)
- **속성(Fields)**
  - `memberId`: 회원 번호 (Long)
  - `name`: 회원 이름 (String)
  - `phoneNumber`: 휴대폰 번호 (String, 13자리 입력, '-' 포함)
  - `birth`: 생년월일 (String, 6자리 입력, '-' 제외)
- **기능(Methods)**
  - 생성자 (이름, 전화번호, 생년월일): 회원 번호는 자동 생성
  - Getter
  - toString: 회원 정보를 가독성 좋게 출력하기 위해 오버라이딩
### MemberRepository (interface)
- **기능(Methods)**
  - `void addMember()`
  - `void listAllMembers()`
  - `void getMemberByName(String name)`
  - `Member getMemberById(Long memberId)`
  - `boolean isEmpty()`

[//]: # (  - `getMemberByPhoneNumber&#40;&#41;`)
### MemoryMemberRepository (class)
- `MemberRepository`의 구현체로 메모리에 회원 정보를 저장한다.
- `memberMap<Long, Book>`을 가지고 있고. 회원 번호로 회원을 관리한다.

[//]: # (### TODO: FileMemberRepository &#40;class&#41;)

[//]: # (- MemberRepository의 구현체로 파일에 회원 정보를 저장한다.)
### BookIdGenerator
- 도서 등록 번호 자동 생성기
### MemberIdGenerator
- 회원 등록 번호 자동 생성기
### MenuGenerator
- 메뉴창 생성기
### BookValidator
- 도서 관련 기능 사용시 검증
### MemberValidator
- 회원 관련 기능 사용시 검증
### LibraryService (interface)
- **기능(Methods)**
    - `void rentBook(Book book, Member member)`
    - `void returnBook(Book book)`
    - `void listRentedBooks()`
    - `boolean rentedBookEmpty()`
### LibraryServiceImpl (class)
- `LibraryService`의 구현체로 도서 대여와 반납 기능을 가지고 있다.
- `rentedBookMap<Book, Member>`을 가져서 대여 중인 도서 목록을 관리한다. 
### Library (class)
- `BookRepository`, `MemberRepository`, `LibraryService`를 참조하여 검증을 거친 후 기능이 수행될 수 있도록 한다.
### LibraryMain (class)
- `Library`만 알고 있으면 모든 기능을 사용할 수 있다.
- 메뉴를 생성한 뒤, 사용자의 입력을 받아 메뉴를 실행한다.
---
## TODO
- 회원 저장소, 도서 저장소를 파일로 관리하도록 구현해보기 (+ 대여 중인 도서 목록도 파일로 작성) 
- DB 연결하여 관리
## refactor
- 현재는 회원과 도서 등록 시 공백이 입력된 경우만 오류가 발생하도록 검증기가 작동한다.
    - -> 등록시 일어날 수 있는 예외 상황 추가(연락처 오류, 생년월일 오류 등..)
- 도서와 회원을 검색하는 과정에서 일어날 수 있는 예외 상황 추가
- 대여와 반납에서는 예외가 발생할 수 없는지 고민해보기
## WISH
- 회원을 검색했을 때 해당 회원이 대여 중인 도서 목록까지 함께 출력하고 싶다.
- 회원마다 대여 도서 수의 한계를 지정하고 싶다.
## 느낀점 및 아쉬운 점
- 설계의 중요성을 너무나 크게 깨닫는다. 프로젝트를 갈아엎은 수준으로 리팩토링하고, 새로운 설계에 적지 않은 시간을 썼는데도 불구하고 코드를 구현하면서 변경되는 부분이 적지 않았다.
- 사실 `rentedBookList`를 키가 `Member`, 값이 `Book`으로 하고 싶었으나, 한 명의 회원이 여러 권의 도서를 대여할 수도 있을 것인데 해당 부분을 어떻게 구현하는지 한참을 붙잡아도 해결되지 않아 키-값을 바꾸었다.
  - -> 이 부분이 해결되어야 `WISH` 부분을 해결할 수 있을 것으로 예상된다.
- 리팩토링 + 자격증 시험 준비로 인해 배운 IO 부분을 아직 적용하지 못한 점이 아쉽다. 시험이 끝나고 주말에 적용할 수 있도록 해봐야겠다!
---
# 25.09.17 리팩토링
## 주요 리팩토링 내용
- 레이어트 아키텍처 구조로 패키지 변경
- 메모리로 사용되던 저장소를 DB로 변경
- `Library` 클래스와 `LibraryServiceImpl` 클래스 모두 `Repository`를 호출하는 바람에 저장소가 바뀔 경우 리팩토링 취약
    - -> `LibraryServiceImpl` 클래스만 저장소를 호출하도록 리팩토링, `LibraryDAO` 인터페이스 통해 기능 분리
- `void`로 호출되던 많은 메서드가 리팩토링 과정에서 반환값 필요에 의해 메서드 반환값 수정
  - -> 반환값 수정 이후 `NullPointerException` 발생 구간 다수 발견되어 오류 처리 필요

## 레이어트 아키텍처 구조로 패키지 변경
```mathematica
miniproject01/
├── README.md
├── common
│   ├── generator -- BookIdGenerator, MemberIdGenerator, MenuGenerator
│   ├── validator -- BookValidator, MemberValidator
│   └── DBUtil
├── controller -- LibraryMain
├── dto -- Book, Member
├── repository
│   ├── book -- BookRepository, MemoryBookRepository, DataBookRepository
│   ├── library -- LibraryDAO, MemoryLibraryImpl
│   └── member -- MemberRepository, MemoryMemberRepository, DataMemberRepository
└── service
    └── library -- LibraryService, LibraryServiceImpl
```

## DB (library)
### 테이블
- books
  - book_id: BigInt, primary key, auto_increment
  - title: String, not null
  - author: String, not null
  - is_rented: Boolean, default false 
- members
  - member_id: BigInt, primary key, auto_increment
  - name: String, not null
  - phone_number: String, not null
  - birth: String
- rented_books
  - book_id: BigInt (FK)
  - member_id: BigInt (FK)

## TODO
- 리팩토링 과정에서 미완성된 기능 구현하기
- 회원, 도서 등록 전에 목록 조회 시 / 대여 중인 도서 없는 경우 NPE(NullPointerException 발생) -> 오류 해결하기
- 존재하지 않는 회원 / 도서 검색 시 아무 출력도 발생하지 않고 넘어감 -> 출력문 만들기
- 존재하지 않는 회원 / 도서 대여 시 대여 가능 / 반납 가능 -> 대여 중인 도서 목록에서 null 발생 -> 해결하기

## FEEDBACK
- 검증에 대해
  - 비즈니스 규칙(예: 이미 존재하는 회원, 대여 중인 도서)의 경우 대체로 서비스 쪽에서 검증한다.
  - 불변 조건(예: 회원 이름이 공백, 전화번호나 생년월일이 음수)의 경우 대체로 엔티티 쪽에서 검증한다.
  - 메뉴 출력(컨트롤러)은 메인에서 메서드로 뽑는 것도 방법이다.

## Addition
- DAO는 오직 데이터베이스에 대한 내용만 담고 있어야 한다.
- 검증을 통해 구현되는 부분은 service로 옮겨지는 것이 필요하다.