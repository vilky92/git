import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { AppRoutingModule } from './app-routing.module';
import { StyloComponent } from './stylo/stylo.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { StyloService } from './service/stylo.service';
import { ErrorComponent } from './error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    AcceuilComponent,
    StyloComponent,
    AuthentificationComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    StyloService,
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
