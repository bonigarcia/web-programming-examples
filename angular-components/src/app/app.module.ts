import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoot } from './components/app.root';
import { HeaderComponent } from './components/header';
import { SidebarComponent } from './components/sidebar';
import { ContentComponent } from './components/content';
import { FooterComponent } from './components/footer';

@NgModule({
  declarations: [AppRoot, HeaderComponent, SidebarComponent, ContentComponent, FooterComponent],
  imports: [BrowserModule],
  bootstrap: [AppRoot]
})
export class AppModule { }
