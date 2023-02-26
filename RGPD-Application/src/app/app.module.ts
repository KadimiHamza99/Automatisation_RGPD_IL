import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './core/components/nav-bar/nav-bar.component';
import { SideBarComponent } from './core/components/side-bar/side-bar.component';
import { FooterComponent } from './core/components/footer/footer.component';
import { ConsentComponent } from './consent/consent.component';
import {ContractComponent} from './contract/contract.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ProcessingComponent } from './processing/processing.component';
import {CoreModule} from "./core/core.module";
import { ProcessingDetailsComponent } from './processing-details/processing-details.component';
import { DataComponent } from './data/data.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    ConsentComponent,
    ContractComponent,
    ProcessingComponent,
    ProcessingDetailsComponent,
    DataComponent,
    LandingPageComponent,
    PageNotFoundComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        CoreModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
