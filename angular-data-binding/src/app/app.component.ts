import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styles: []
})
export class AppComponent {
  name = 'Anybody';
  imgUrl = "assets/utad.png";

  setName(name: string) {
    this.name = name;
  }

  changeUrl() {
    this.imgUrl = "assets/angular.png";
  }
}
