import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/auth.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ResponseModel } from '../shared/model/response.model';
import { RoleModel } from '../shared/model/role.model';
import { RoleResponseModel } from '../shared/model/roleresponse.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  showMessage: boolean = false;
  alertMessage: string = '';
  myRoles: RoleModel[];

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
  hideAlert() {
    this.showMessage = false;
  }
  onSubmit() {
    console.log(this.loginForm);
    this.authsvc.login(this.loginForm.value.username, this.loginForm.value.password).subscribe(
      (resp) => {
        if (typeof resp === 'string') {
          this.authsvc.loggedin.next(true);
          this.authsvc.username.next(this.loginForm.value.username);
          this.getRoles(this.loginForm.value.username);
          //this.router.navigate(['home']);
        } else {
          this.alertMessage = "Login unsuccessful, try again.";
          this.showMessage = true;
          console.log(resp);
        }
      },
      (error) => {
        this.alertMessage = "Login error, try again.";
        this.showMessage = true;
        console.log(error);
      }
    );
  }

  getRoles(username: string){
    console.log("username:" + username);
    this.authsvc.getUserRoles(username).subscribe(
      (resp: RoleResponseModel) => {
        this.myRoles=resp.data;
        console.log(this.myRoles);
        this.authsvc.userroles.next(this.myRoles);
        this.router.navigate(['home']);
      },
      (error)=>{
        console.log(error);
      }
    );
  }

  onSubmit2() {
    console.log(this.loginForm);
    this.authsvc.login(this.loginForm.value.username, this.loginForm.value.password).subscribe(
      (data: ResponseModel) => {
        if (data.success) {
          this.authsvc.loggedin.next(true);
          this.authsvc.username.next(this.loginForm.value.username);
          this.router.navigate(['home']);
        } else {
          this.alertMessage = "Login unsuccessful, try again.";
          this.showMessage = true;
          console.log(data.respMessage);
        }
      },
      (error) => {
        this.alertMessage = "Login error, try again.";
        this.showMessage = true;
        console.log(error);
      }
    );
  }
}
