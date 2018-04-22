import {Component} from '@angular/core';

@Component({
  selector: 'app-switch',
  templateUrl: 'switch.html',
  styleUrls: ['switch.css']
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
