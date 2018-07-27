import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../shared/auth.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { CustomerProfileModel } from '../shared/customerprofile.model';
import { UserCredentialModel } from '../shared/usercredential.model';
import { CustomerService } from '../shared/customer.service';

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
  profile: CustomerProfileModel = new CustomerProfileModel();
  cred: UserCredentialModel = new UserCredentialModel();

  constructor(private authsvc: AuthService, private custsvc: CustomerService, private router: Router) { }
  initForms(){
    this.profileForm = new FormGroup({
      'loginId': new FormControl('', [Validators.required]),
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

    this.loginForm = new FormGroup({
      'loginId': new FormControl('', [Validators.required]),
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
  ngOnInit() {
    this.initForms();
    this.username=this.authsvc.loginId;
    this.authsvc.username.subscribe(
      (name)=>{
        this.username=name;
      }
    );
    this.loadProfileFromServer();

  }
  loadProfileFromServer(){
    this.custsvc.getCustProfile(this.username).subscribe(
      (data: CustomerProfileModel)=>{
        this.profile=data;
        this.displayProfile();
      }, 
      (error)=>{
        console.log(error);
      } 
    );
  }
  displayProfile(){
    this.loginForm.get('loginId').setValue(this.profile.loginId);

    this.profileForm.get('loginId').setValue(this.profile.loginId);

    this.profileForm.get('email').setValue(this.profile.email);
    this.profileForm.get('customerFirstName').setValue(this.profile.customerFirstName);
    this.profileForm.get('customerLastName').setValue(this.profile.customerLastName);
    this.profileForm.get('customerMiddleName').setValue(this.profile.customerMiddleName);
    this.profileForm.get('customerPhone').setValue(this.profile.customerPhone);
    this.profileForm.get('addressLine1').setValue(this.profile.addressLine1);
    this.profileForm.get('addressLine2').setValue(this.profile.addressLine2);

    this.profileForm.get('addressCity').setValue(this.profile.addressCity);
    this.profileForm.get('addressZip').setValue(this.profile.addressZip);
    this.profileForm.get('addressState').setValue(this.profile.addressState);


  }
  resetFormProfileForm(){
    this.profileForm.reset();
  }
  resetFormLoginForm(){
    this.loginForm.reset();
  }
  activateTab(event,tabName:string){
    this.tabname=tabName;
    event.preventDefault();
  }

  onSubmitProfileForm(){
    
  }
  onSubmitLoginForm(){
    
  }
  toCustomerProfileModel(){

  }
  ngOnDestroy(){
    if(this.subscription){
      this.subscription.unsubscribe();
    }
  }
}
