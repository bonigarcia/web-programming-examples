import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoot } from './app.root';
import { NgFor } from './ngfor';
import { NgIf } from './ngif';
import { NgSwitch } from './ngswitch';

@NgModule({
    imports: [BrowserModule],
    declarations: [AppRoot, NgFor, NgIf, NgSwitch],
    bootstrap: [AppRoot]
})
export class AppModule { }
