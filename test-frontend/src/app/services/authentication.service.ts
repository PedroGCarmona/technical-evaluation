import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import firebase from 'firebase/app';
import { AngularFireAuth } from '@angular/fire/auth';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private afAuth: AngularFireAuth,
    private router: Router
  ) { }

  public async signin() {
    const provider = new firebase.auth.GoogleAuthProvider();
    const credential = await this.afAuth.signInWithPopup(provider).then((result) => {
      console.log("Deu certo!");
    });
  }

  public async signOut() {
    await this.afAuth.signOut();
    this.router.navigate(['/']);
  }
}
