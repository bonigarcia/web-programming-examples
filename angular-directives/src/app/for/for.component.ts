import {Component} from '@angular/core';

@Component({
  selector: 'app-for',
  template: `
    <h3>NgFor example</h3>
    <ul>
       <li *ngFor="let person of people">
          {{ person.name }}
       </li>
    </ul>
    
    <h3>NgFor example (with index)</h3>
    <ul>
       <li *ngFor="let person of people; let i = index">
          {{ i + 1 }} - {{ person.name }}
       </li>
    </ul>
  `,
  styles: []
})
export class ForComponent {

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
