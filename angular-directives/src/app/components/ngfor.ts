import { Component } from '@angular/core';

@Component({
    selector: 'ngfor-example',
    templateUrl: '../views/ngfor.html'
})
export class NgFor {
    people: any[] = [
        {
            "name": "Douglas Pace"
        },
        {
            "name": "Mcleod Mueller"
        },
        {
            "name": "Day Meyers"
        },
        {
            "name": "Aguirre Ellis"
        },
        {
            "name": "Cook Tyson"
        }
    ];
}
