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
│   ├── repository
│   │   ├── BookRepository
│   │   └── MemoryBookRepository
│   └── Book
├── member
│   ├── repository
│   │   ├── MemberRepository
│   │   └── MemoryMemberRepository
│   └── Member
├── library
│   ├── service
│   │   ├── LibraryService
│   │   └── LibraryServiceImpl
│   └── Library
├── generator
│   ├── BookIdGenerator
│   ├── MemberIdGenerator
│   └── MenuGenerator
├── validator
│   ├── BookValidator
│   └── MemberValidator
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
- 회원 저장소, 도서 저장소를 파일에 쓸 수 있도록 해보기
  - -> 대여 중인 도서 목록도 파일로 작성
## refactor
- 현재는 회원과 도서 등록 시 공백이 입력된 경우만 오류가 발생하도록 검증기가 작동
    - -> 등록시 일어날 수 있는 예외 상황을 더 많이 추가하기
- 도서와 회원을 검색하는 과정에서도 일어날 수 있는 예외 상황 추가
