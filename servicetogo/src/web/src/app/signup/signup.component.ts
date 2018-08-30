import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserCredentialModel } from '../shared/model/usercredential.model';
import { AuthService } from '../shared/auth.service';
import { Router } from '@angular/router';
import { ResponseModel } from '../shared/model/response.model';
import { PasswordValidator } from '../shared/Validators/passwd-validators.directive';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;

  constructor(private authsvc: AuthService, private router: Router) { }

  ngOnInit() {
    this.signupForm = new FormGroup({
      'username': new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(10), Validators.pattern('^[a-zA-Z][a-zA-Z0-9_]+$')]),
      'loginPassword': new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(20)]),
      'retypePassword': new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(20)]),
      'email': new FormControl('', [Validators.required, Validators.email,Validators.maxLength(100)])
    }, {
      validators: PasswordValidator // custom validation method
    });
  }
  get username() { return this.signupForm.get('username'); }
  get loginPassword() { return this.signupForm.get('loginPassword'); }
  get retypePassword() { return this.signupForm.get('retypePassword'); }
  get email() { return this.signupForm.get('email'); }
  get formStatus() { console.log(this.signupForm); return this.signupForm.valid;}

  resetForm() {
    this.signupForm.reset();
  }
  onSubmit() {
    let model: UserCredentialModel= new UserCredentialModel();
    model.loginId = this.signupForm.value.username;
    model.loginPassword = this.signupForm.value.loginPassword;
    model.email = this.signupForm.value.email;
    model.userType='customer';

    this.authsvc.signup(model).subscribe(
      (data: ResponseModel)=>{
        if (data.success) {
          this.router.navigate(['login']);
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
