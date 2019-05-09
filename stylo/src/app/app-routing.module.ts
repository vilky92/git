import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { StyloComponent } from './stylo/stylo.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { ErrorComponent } from './error/error.component';
import { AcceuilComponent } from './acceuil/acceuil.component';

const routes: Routes = [
  {path: 'stylo', component: StyloComponent},
  {path: 'authentification', component: AuthentificationComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'acceuil', component: AcceuilComponent},
  {path: '', redirectTo: '/stylo', pathMatch:'full'},
  {path: '**', redirectTo: '/error', pathMatch: 'full'},

];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes)]
})

export class AppRoutingModule {
  
 }