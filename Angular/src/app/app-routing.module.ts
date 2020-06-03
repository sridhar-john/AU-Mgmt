import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {TrendsComponent} from './trends/trends.component';
 import {HomeComponent} from './home/home.component';
import {OpportunityComponent} from './opportunity/opportunity.component';
//import {LoginComponent} from './login/login.component';


const routes: Routes = [
  
  //{ path: '', component: HomeComponent },
   { path: 'trends', component: TrendsComponent },
   { path: 'opportunity', component: OpportunityComponent }
  
  //{path : '', component : LoginComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
