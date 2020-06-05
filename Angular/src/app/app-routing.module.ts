import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {TrendsComponent} from './trends/trends.component';
 import {HomeComponent} from './home/home.component';
import {OpportunityComponent} from './opportunity/opportunity.component';
import {LoginComponent} from './login/login.component';


const routes: Routes = [
  { path: '' ,redirectTo:'/login', pathMatch:'full'},
    {path:'login',component:LoginComponent},
  // { path: 'home', component: HomeComponent },
   { path: 'trends', component: TrendsComponent },
   { path: 'opportunity', component: OpportunityComponent }
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
