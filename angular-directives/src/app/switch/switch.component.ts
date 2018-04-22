import {Component} from '@angular/core';

@Component({
  selector: 'app-switch',
  template: `
    <h3>NgSwitch example</h3>
    <ul>
       <ng-container *ngFor="let person of people" [ngSwitch]="person.country">
          <li *ngSwitchCase="'UK'" class="primary">{{ person.name }} ({{ person.country }})</li>
          <li *ngSwitchCase="'USA'" class="warning">{{ person.name }} ({{ person.country }})</li>
          <li *ngSwitchCase="'ES'" class="success">{{ person.name }} ({{ person.country }})</li>
          <li *ngSwitchDefault class="danger">{{ person.name }} ({{ person.country }})</li>
       </ng-container>
    </ul>
    
    <h3>NgStyle example</h3>
    <ul>
       <ng-container *ngFor="let person of people" [ngSwitch]="person.country">
          <li [ngStyle]="{'color':person.country === 'ES' ? 'green' : 'red' }">{{ person.name }} ({{ person.country }})</li>   
       </ng-container>
    </ul>
    
    <h3>NgClass example</h3>
    <ul>
       <ng-container *ngFor="let person of people" [ngSwitch]="person.country">
          <li [ngClass]="{'success':person.country === 'USA', 'danger':person.country === 'UK'}">{{ person.name }} ({{ person.country }})</li>   
       </ng-container>
    </ul>
  `,
  styles: []
})
export class SwitchComponent {

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
