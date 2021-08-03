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
    await this.afAuth.signInWithPopup(provider).then((result) => {
      if(result){
        this.router.navigate(['/home'])
      }
    });
  }

  public async signOut() {
    await this.afAuth.signOut();
    this.router.navigate(['/']);
  }
}
