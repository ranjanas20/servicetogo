import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserCredentialModel } from '../shared/usercredential.model';
import { AuthService } from '../shared/auth.service';
import { Router } from '@angular/router';
import { ResponseModel } from '../shared/response.model';

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
      'loginId': new FormControl('', [Validators.required]),
      'loginPassword': new FormControl('', [Validators.required]),
      'retypePassword': new FormControl('', [Validators.required]),
      'email': new FormControl('', [Validators.required]),
      'userType': new FormControl('', [Validators.required]),
      'secretQuestion1CodeId': new FormControl('', [Validators.required]),
      'secretQuestion2CodeId': new FormControl('', [Validators.required]),
      'secretAnswer1': new FormControl('', [Validators.required]),
      'secretAnswer2': new FormControl('', [Validators.required])
    });
  }
  resetForm() {
    this.signupForm.reset();
  }
  onSubmit() {
    let model: UserCredentialModel= new UserCredentialModel();
    model.loginId = this.signupForm.value.loginId;
    model.loginPassword = this.signupForm.value.loginPassword;
    model.email = this.signupForm.value.email;
    model.secretQuestion1CodeId=this.signupForm.value.secretQuestion1CodeId;
    model.secretQuestion2CodeId=this.signupForm.value.secretQuestion2CodeId;
    model.secretAnswer1=this.signupForm.value.secretAnswer1;
    model.secretAnswer2=this.signupForm.value.secretAnswer2;
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
