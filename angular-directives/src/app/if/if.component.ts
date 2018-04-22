import {Component} from '@angular/core';

@Component({
  selector: 'app-if',
  template: `
    <h3>NgIf example</h3>
    
    <!-- <ng-container> is a logical container that can be used to group nodes but is not rendered in the DOM tree  -->
    <!-- Two *ng at the same element: ERROR Can't have multiple template bindings on one element -->
    
    <ul>
      <ng-container *ngFor="let person of people">
      <li *ngIf="person.age < 30">{{ person.name }} ({{ person.age }})</li>
      </ng-container>
    </ul>
  `,
  styles: []
})
export class IfComponent {

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
