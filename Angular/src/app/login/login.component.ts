import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';
import {FormControl, Validators,} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  password:String;
  constructor(private router: Router) { }
  
  ngOnInit(): void {
  }
  email = new FormControl('', [Validators.required, Validators.email]);
  // password= new FormControl('', []);
  
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }

  
  login() : void {
    console.warn(this.email.value);
    if(this.email.value == 'sridharmay1@gmail.com' && this.password == '123456'){
     this.router.navigate([" "]);
    }else {
      alert("Invalid credentials");
    }
  }


}
