import { Component } from '@angular/core';

@Component({
    selector: 'ngswitch-example',
    templateUrl: './ngswitch.html',
    styleUrls: ['./ngswitch.css']
    
})
export class NgSwitch {
    people: any[] = [
        {
            "name": "Douglas Pace",
            "age": 35,
            "country": 'FR'
        },
        {
            "name": "Mcleod Mueller",
            "age": 32,
            "country": 'USA'
        },
        {
            "name": "Day Meyers",
            "age": 21,
            "country": 'ES'
        },
        {
            "name": "Aguirre Ellis",
            "age": 34,
            "country": 'UK'
        },
        {
            "name": "Cook Tyson",
            "age": 32,
            "country": 'USA'
        }
    ];
}