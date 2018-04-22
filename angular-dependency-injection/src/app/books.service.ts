import {Injectable} from '@angular/core';

@Injectable()
export class BooksService {

  private myBooks: string[] = ['Spring in Action', 'Java for Web Applications', 'Spring Boot Cookbook'];

  getBooks(key: string) {
    let out: string[] = [];
    for (let book of this.myBooks) {
      if (book.includes(key)) {
        out.push(book);
      }
    }
    return out;
  }

  getAllBooks() {
    return this.myBooks;
  }

}
