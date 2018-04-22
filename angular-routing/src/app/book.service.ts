import {Injectable} from '@angular/core';

export class Book {
  constructor(public id: number, public title: string, public description: string) {}
}

@Injectable()
export class BookService {

  private books = [
    new Book(11, 'Spring in Action',
      'Craig Walls.'),
    new Book(12, 'Java for Web Applications',
      'Nicholas S. Williams'),
    new Book(13, 'Learning Bootstrap',
      'Aravind Shenoy, Ulrich Sossou'),
    new Book(14, 'Client-Server Web Apps with JavaScript and Java',
      'Casimir Saternos.')
  ];

  getBooks() {
    return this.books;
  }

  getBook(id: number) {
    return this.books.find(book => book.id === id);
  }
}
