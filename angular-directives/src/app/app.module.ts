import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoot } from './components/app.root';
import { NgFor } from './components/ngfor';
import { NgIf } from './components/ngif';
import { NgSwitch } from './components/ngswitch';

@NgModule({
    imports: [BrowserModule],
    declarations: [AppRoot, NgFor, NgIf, NgSwitch],
    bootstrap: [AppRoot]
})
export class AppModule { }
