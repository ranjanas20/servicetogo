import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/auth.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ResponseModel } from '../shared/response.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  constructor(private authsvc: AuthService, private router: Router) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      'username': new FormControl('', [
        Validators.required
      ]),
      'password': new FormControl('',
        [
          Validators.required
        ])
    });
  }
  onSubmit() {
    console.log(this.loginForm);
    this.authsvc.login(this.loginForm.value.username, this.loginForm.value.password).subscribe(
      (data: ResponseModel)=>{        
        if (data.success) {
          this.authsvc.loggedin.next(true);
          this.authsvc.username.next(this.loginForm.value.username);          
          this.router.navigate(['home']);
      } else {
          console.log(data.respMessage);
      }
      }, 
      (error)=>{
        console.log(error);
      } 
    );
  }
}
