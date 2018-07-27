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
  hide:number=1;
  alertMessage:string='';
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
  hideAlert(){
    this.hide=1;
  }
  onSubmit() {
    console.log(this.loginForm);
    this.authsvc.login(this.loginForm.value.username, this.loginForm.value.password).subscribe(
      (data: ResponseModel)=>{        
        if (data.success) {
          this.authsvc.loginId=this.loginForm.value.username;
          this.authsvc.loggedin.next(true);
          this.authsvc.username.next(this.loginForm.value.username);          
          this.router.navigate(['home']);
      } else {
          this.alertMessage="Login unsuccessful, try again.";
          this.hide=0;
          console.log(data.respMessage);
      }
      }, 
      (error)=>{
        console.log(error);
      } 
    );
  }
}
