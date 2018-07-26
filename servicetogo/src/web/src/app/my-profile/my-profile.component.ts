import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../shared/auth.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
  tabname:string='PROFILE';
  profileForm: FormGroup;
  loginForm: FormGroup;
  username:string='';
  subscription: Subscription;
  constructor(private authsvc: AuthService, private router: Router) { }

  ngOnInit() {
    this.profileForm = new FormGroup({
      'loginId': new FormControl(this.authsvc.loginId, [Validators.required]),
      'email': new FormControl('', [Validators.required]),
      'customerFirstName': new FormControl('', [Validators.required]),
      'customerLastName': new FormControl('', [Validators.required]),
      'customerMiddleName': new FormControl('', [Validators.required]),
      'customerPhone': new FormControl('', [Validators.required]),
      'addressLine1': new FormControl('', [Validators.required]),
      'addressLine2': new FormControl('', [Validators.required]),
      'addressCity': new FormControl('', [Validators.required]),
      'addressZip': new FormControl('', [Validators.required]),
      'addressState': new FormControl('', [Validators.required])
    });
    this.subscription = this.authsvc.username.subscribe((username: string)=>{
      this.username = username;
    });
    this.username = this.authsvc.loginId;
    this.loginForm = new FormGroup({
      'loginId': new FormControl(this.authsvc.loginId, [Validators.required]),
      'loginPassword': new FormControl('', [Validators.required]),
      'retypePassword': new FormControl('', [Validators.required]),
      'oldPassword': new FormControl('', [Validators.required]),
      'userType': new FormControl('', [Validators.required]),
      'secretQuestion1CodeId': new FormControl('', [Validators.required]),
      'secretQuestion2CodeId': new FormControl('', [Validators.required]),
      'secretAnswer1': new FormControl('', [Validators.required]),
      'secretAnswer2': new FormControl('', [Validators.required])
    });
  }
  resetForm(){
    this.profileForm.reset();
  }
  activateTab(event,tabName:string){
    this.tabname=tabName;
    event.preventDefault();
  }

  onSubmit(){
    
  }
  ngOnDestroy(){
    if(this.subscription){
      this.subscription.unsubscribe();
    }
  }
}
