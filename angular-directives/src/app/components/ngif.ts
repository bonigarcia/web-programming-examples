import { Component } from '@angular/core';

@Component({
    selector: 'ngif-example',
    templateUrl: '../views/ngif.html'
})
export class NgIf {
    people: any[] = [
        {
            "name": "Douglas Pace",
            "age": 35
        },
        {
            "name": "Mcleod Mueller",
            "age": 29
        },
        {
            "name": "Day Meyers",
            "age": 21
        },
        {
            "name": "Aguirre Ellis",
            "age": 34
        },
        {
            "name": "Cook Tyson",
            "age": 32
        }
    ];
}