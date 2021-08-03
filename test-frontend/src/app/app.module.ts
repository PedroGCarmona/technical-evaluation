import { NgModule } from '@angular/core';
import { AngularFireModule } from '@angular/fire';
import { AngularFireAuthModule } from '@angular/fire/auth';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { HomeComponent } from './components/home/home.component';

var firebaseConfig = {
  apiKey: "AIzaSyDIYDVRPor5dPEbh8JInlcDXKs0k7WRezo",
  authDomain: "fir-poc-9bfa8.firebaseapp.com",
  projectId: "fir-poc-9bfa8",
  storageBucket: "fir-poc-9bfa8.appspot.com",
  messagingSenderId: "137185870337",
  appId: "1:137185870337:web:fb1d3cf6a9e33a6a42f600"
}

@NgModule({
  declarations: [
    AppComponent,
    AuthenticationComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AngularFireModule.initializeApp(firebaseConfig),
    AngularFireAuthModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
