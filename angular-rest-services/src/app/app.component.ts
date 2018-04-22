import { Component } from '@angular/core';
import { Http } from '@angular/http';

import { BooksService } from './books.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html'
})
export class AppComponent {
    books: string[] = [];

    constructor(private http: Http, private service: BooksService) { }

    seek(title: string) {
        this.books = [];
        let url = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + title;
        this.http.get(url).subscribe(
            response => {
                for (let book of response.json().items) {
                    this.books.push(book.volumeInfo.title);
                }
            },
            error => console.error(error)
        );
    }

    search(title: string) {
        this.books = [];
        this.service.getBooks(title).subscribe(
            books => this.books = books,
            error => console.error(error)
        );
    }
}
