// 도서관 시스템을 만들어보세요
// 1. 책 객체들이 담긴 배열을 만드세요 (제목, 저자, 출간년도, 대여 상태)
// 2. 책 제목으로 검색하는 함수를 만드세요
// 3. 대여 가능한 책들의 제목만 출력하는 함수를 만드세요
// 4. 새 책을 추가하는 함수를 만드세요

let library = {
  books: [
    {
      title: "데미안",
      author: "헤르만 헤세",
      publication_year: 2009,
      isRented: false,
    },
    {
      title: "자바의 정석",
      author: "남궁성",
      publication_year: 2025,
      isRented: true,
    },
    {
      title: "해리포터와 마법사의 돌",
      author: "J.K. 롤링",
      publication_year: 2024,
      isRented: true,
    },
    {
      title: "미움받을 용기",
      author: "기시미 이치로",
      publication_year: 2022,
      isRented: false,
    },
    {
      title: "총, 균, 쇠",
      author: "재레드 다이아몬드",
      publication_year: 2023,
      isRented: false,
    },
  ],

  findByTitle: function (title) {
    for (let i = 0; i < this.books.length; i++) {
      if (this.books[i].title === title) {
        return this.books[i];
      }
    }
    return "등록되지 않은 도서입니다.";
  },

  possibleRentBooks: function () {
    console.log("대여 가능한 도서 목록");
    for (let i = 0; i < this.books.length; i++) {
      if (this.books[i].isRented === false) {
        console.log(" - " + this.books[i].title);
      }
    }
  },

  addBook: function (title, author, publication_year) {
    let newBook = {
      title: title,
      author: author,
      publication_year: publication_year,
      isRented: false,
    };

    this.books.push(newBook);
    console.log("도서가 등록되었습니다.");
  },
};

console.log(library.findByTitle("데미안"));
library.possibleRentBooks();
library.addBook("나미야 잡화점의 기적", "히가시노 게이고", 2022);
console.log(library.books);
