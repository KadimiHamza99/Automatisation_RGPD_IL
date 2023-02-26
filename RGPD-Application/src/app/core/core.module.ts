import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FooterComponent} from "./components/footer/footer.component";
import {NavBarComponent} from "./components/nav-bar/nav-bar.component";
import {SideBarComponent} from "./components/side-bar/side-bar.component";
import {RouterLink} from "@angular/router";



@NgModule({
  declarations: [
    FooterComponent,
    NavBarComponent,
    SideBarComponent
  ],
  imports: [
    CommonModule,
    RouterLink
  ],
  exports:[
    FooterComponent,
    NavBarComponent,
    SideBarComponent
  ]
})
export class CoreModule { }
