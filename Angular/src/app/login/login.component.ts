import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

import {Router} from '@angular/router';
// import {FormControl, Validators,} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  auth2: any;
  public name:any;
 
  @ViewChild('loginRef', {static: true }) loginElement: ElementRef;
 
  constructor(public _router: Router) { }
 
  ngOnInit() {
 
   this.googleSDK();
  }


 
  prepareLoginButton() {
 
    this.auth2.attachClickHandler(this.loginElement.nativeElement, {},
      (googleUser) => {
 
        let profile = googleUser.getBasicProfile();
        console.log('Token || ' + googleUser.getAuthResponse().id_token);
        console.log('ID: ' + profile.getId());
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());
        
        this.name=profile.getName();
        this._router.navigateByUrl("/opportunity");
       
      }, (error) => {
        alert(JSON.stringify(error, undefined, 2));
      });
 
  }
  googleSDK() {
 
    window['googleSDKLoaded'] = () => {
      window['gapi'].load('auth2', () => {
        this.auth2 = window['gapi'].auth2.init({
          client_id: '447243278135-une39aofm0e0f5luu9vubl53h02om6hm.apps.googleusercontent.com',
          cookiepolicy: 'single_host_origin',
          scope: 'profile email'
        });
        this.prepareLoginButton();
      });
    }
 
    (function(d, s, id){
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) {return;}
      js = d.createElement(s); js.id = id;
      js.src = "https://apis.google.com/js/platform.js?onload=googleSDKLoaded";
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'google-jssdk'));
 
  }
  
}

  

