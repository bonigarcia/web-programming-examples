import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {RootComponent} from './components/root.component';
import {HeaderComponent} from './components/header.component';
import {SidebarComponent} from './components/sidebar.component';
import {ContentComponent} from './components/content.component';
import {FooterComponent} from './components/footer.component';

@NgModule({
  declarations: [RootComponent, HeaderComponent, SidebarComponent, ContentComponent, FooterComponent],
  imports: [BrowserModule],
  bootstrap: [RootComponent]
})
export class AppModule {}
