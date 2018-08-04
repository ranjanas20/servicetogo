import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../shared/auth.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { CustomerProfileModel } from '../shared/customerprofile.model';
import { UserCredentialModel } from '../shared/usercredential.model';
import { CustomerService } from '../shared/customer.service';
import { ResponseModel } from '../shared/response.model';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']

})
export class MyProfileComponent implements OnInit {
  message: string = "No message from my profile";
  showMessage: boolean = false;

  showProgressBar: boolean=false;

  tabname: string = 'PROFILE';
  profileForm: FormGroup;
  loginForm: FormGroup;
  username: string = '';
  subscription: Subscription;
  profile: CustomerProfileModel = new CustomerProfileModel();
  cred: UserCredentialModel = new UserCredentialModel();

  constructor(private authsvc: AuthService, private custsvc: CustomerService, private router: Router) { }
  onMessageHidden() {
    this.showMessage = false;
  }
  showMessageNow(msg:string){
    this.message = msg;
    this.showMessage = true;
  }
  initForms() {
    this.profileForm = new FormGroup({
      'loginId': new FormControl('', [Validators.required]),
      'email': new FormControl('', [Validators.required, Validators.email, Validators.maxLength(100)]),
      'customerFirstName': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'customerLastName': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'customerMiddleName': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'customerPhone': new FormControl('', [Validators.required, Validators.maxLength(10)]),
      'addressLine1': new FormControl('', [Validators.required, Validators.maxLength(100)]),
      'addressLine2': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'addressCity': new FormControl('', [Validators.required, Validators.maxLength(100)]),
      'addressZip': new FormControl('', [Validators.required, Validators.maxLength(5)]),
      'addressState': new FormControl('', [Validators.required, Validators.maxLength(50)])
    });

    this.loginForm = new FormGroup({
      'loginId': new FormControl('', [Validators.required]),
      'loginPassword': new FormControl('', [Validators.required, Validators.maxLength(20)]),
      'retypePassword': new FormControl('', [Validators.required, Validators.maxLength(20)]),
      'oldPassword': new FormControl('', [Validators.required, Validators.maxLength(20)]),
      'secretQuestion1CodeId': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'secretQuestion2CodeId': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'secretAnswer1': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'secretAnswer2': new FormControl('', [Validators.required, Validators.maxLength(50)])
    });
  }
  ngOnInit() {
    this.initForms();
    this.authsvc.username.subscribe(
      (name) => {
        this.username = name;
      }
    );
    this.loadProfileFromServer();

  }
  loadProfileFromServer() {
    this.custsvc.getCustProfile(this.username).subscribe(
      (data: CustomerProfileModel) => {
        this.profile = data;
        this.displayProfile();
      },
      (error) => {
        console.log(error);
      }
    );
  }
  displayProfile() {
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
  resetFormProfileForm() {
    this.profileForm.reset();
  }
  resetFormLoginForm() {
    this.loginForm.reset();
  }
  activateTab(event, tabName: string) {
    this.tabname = tabName;
    event.preventDefault();
  }
  populateProfileModel() {
    this.profile.loginId = this.profileForm.get('loginId').value;

    this.profile.email = this.profileForm.get('email').value;
    this.profile.customerFirstName = this.profileForm.get('customerFirstName').value;
    this.profile.customerLastName = this.profileForm.get('customerLastName').value;
    this.profile.customerMiddleName = this.profileForm.get('customerMiddleName').value
    this.profile.customerPhone = this.profileForm.get('customerPhone').value;
    this.profile.addressLine1 = this.profileForm.get('addressLine1').value;
    this.profile.addressLine2 = this.profileForm.get('addressLine2').value;

    this.profile.addressCity = this.profileForm.get('addressCity').value;
    this.profile.addressZip = this.profileForm.get('addressZip').value;
    this.profile.addressState = this.profileForm.get('addressState').value;
  }
  
  onSubmitProfileForm() {
    this.populateProfileModel() ;
    this.showProgressBar=true;
    this.custsvc.updateProfile(this.profile).subscribe(
      (resp: ResponseModel) => {
        this.profile = resp.data;
        this.displayProfile();
        this.showMessageNow("Saved successfuly");
        this.showProgressBar=false;
      },
      (error) => {
        console.log(error);
        this.showMessageNow("Error saving profile");
        this.showProgressBar=false;
      }
    );
  }
  onSubmitLoginForm() {

  }
  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
