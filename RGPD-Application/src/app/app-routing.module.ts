import { ConsentComponent } from './consent/consent.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContractComponent} from './contract/contract.component';
import {ProcessingDetailsComponent} from "./processing-details/processing-details.component";
import {DataComponent} from "./data/data.component";
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";

const routes: Routes = [
  { path: 'processing/:id', component: ProcessingDetailsComponent },
  { path: 'consent', component: ConsentComponent },
  { path: 'contract', component: ContractComponent },
  { path: 'data', component: DataComponent },
  { path: 'landing-page', component: LandingPageComponent },
  { path: '', redirectTo:'landing-page', pathMatch:'full' },
  { path: '**', pathMatch: 'full', component: PageNotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
