import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { RequestCrudService } from '../shared/requestcrud.service';
import { CarServiceRequestTrackerModel } from '../shared/carservicerequesttracker.model';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-free-estimate-wizard',
  templateUrl: './free-estimate-wizard.component.html',
  styleUrls: ['./free-estimate-wizard.component.css']
})
export class FreeEstimateWizardComponent implements OnInit {
  currentStep: string = 'contact';
  stepCarOK: boolean = false;
  stepContactOK: boolean = false;
  mode: string = 'NEW';
  showMessage: boolean = false;
  alertMessage: string = "No message";
  req: CarServiceRequestTrackerModel = new CarServiceRequestTrackerModel();
  requestId: number;
  wizardForm: FormGroup;

  requestIdSubscription: Subscription;
  selectRequestSubscription: Subscription;

  constructor(private router: Router,
    private reqCrudSvc: RequestCrudService,
    private activatedRoute: ActivatedRoute) { }
  initForm() {
    this.wizardForm = new FormGroup({
      'requestId': new FormControl('', [Validators.required]),
      'customerId': new FormControl('', [Validators.required]),
      'requestedDate': new FormControl('', [Validators.required]),
      'email': new FormControl('', [Validators.required, Validators.email, Validators.maxLength(100)]),
      'customerFirstName': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'customerLastName': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'customerMiddleName': new FormControl('', [Validators.maxLength(50)]),
      'customerPhone': new FormControl('', [Validators.required, Validators.maxLength(10)]),
      'preferredContactMethod': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'addressLine1': new FormControl('', [Validators.maxLength(100)]),
      'addressLine2': new FormControl('', [Validators.maxLength(50)]),
      'addressCity': new FormControl('', [Validators.required, Validators.maxLength(100)]),
      'addressZip': new FormControl('', [Validators.required, Validators.maxLength(5)]),
      'addressState': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'vehicleMake': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'vehicleModel': new FormControl('', [Validators.required, Validators.maxLength(50)]),
      'vehicleYear': new FormControl('', [Validators.required, Validators.maxLength(4)]),
      'vehicleVin': new FormControl('', [Validators.required, Validators.maxLength(16)]),
      'symptoms': new FormControl('', [Validators.required, Validators.maxLength(100)]),
      'userComments': new FormControl('', [Validators.required, Validators.maxLength(100)]),
      'vehicleLocation': new FormControl('', [Validators.required, Validators.maxLength(50)])

    });
  }
  updateForm() {
    this.wizardForm.get("requestId").setValue(this.req.requestId);
    this.wizardForm.get("customerId").setValue(this.req.customerId);
    this.wizardForm.get("customerFirstName").setValue(this.req.customerFirstName);
    this.wizardForm.get("customerLastName").setValue(this.req.customerLastName);
    this.wizardForm.get("customerMiddleName").setValue(this.req.customerMiddleName);
    this.wizardForm.get("email").setValue(this.req.email);
    this.wizardForm.get("customerPhone").setValue(this.req.customerPhone);
    this.wizardForm.get("addressLine1").setValue(this.req.addressLine1);
    this.wizardForm.get("addressLine2").setValue(this.req.addressLine2);
    this.wizardForm.get("addressCity").setValue(this.req.addressCity);
    this.wizardForm.get("addressState").setValue(this.req.addressState);
    this.wizardForm.get("addressZip").setValue(this.req.addressZip);
    this.wizardForm.get("requestedDate").setValue(this.req.requestedDate);

    this.wizardForm.get("vehicleMake").setValue(this.req.vehicleMake);
    this.wizardForm.get("vehicleModel").setValue(this.req.vehicleModel);
    this.wizardForm.get("vehicleYear").setValue(this.req.vehicleYear);
    this.wizardForm.get("vehicleVin").setValue(this.req.vehicleVin);
    this.wizardForm.get("symptoms").setValue(this.req.symptoms);
    this.wizardForm.get("userComments").setValue(this.req.userComments);
    this.wizardForm.get("preferredContactMethod").setValue(this.req.preferredContactMethod);
    this.wizardForm.get("vehicleLocation").setValue(this.req.vehicleLocation);
  }
  updateModel() {
    this.req.requestId = this.wizardForm.get("requestId").value;
    this.req.customerId = this.wizardForm.get("customerId").value;
    this.req.customerFirstName = this.wizardForm.get("customerFirstName").value;
    this.req.customerLastName = this.wizardForm.get("customerLastName").value;
    this.req.customerMiddleName = this.wizardForm.get("customerMiddleName").value;
    this.req.email = this.wizardForm.get("email").value;
    this.req.customerPhone = this.wizardForm.get("customerPhone").value;
    this.req.addressLine1 = this.wizardForm.get("addressLine1").value;
    this.req.addressLine2 = this.wizardForm.get("addressLine2").value;
    this.req.addressCity = this.wizardForm.get("addressCity").value;
    this.req.addressState = this.wizardForm.get("addressState").value;
    this.req.addressZip = this.wizardForm.get("addressZip").value;
    this.req.requestedDate = this.wizardForm.get("requestedDate").value;

    this.req.vehicleMake = this.wizardForm.get("vehicleMake").value;
    this.req.vehicleModel = this.wizardForm.get("vehicleModel").value;
    this.req.vehicleYear = this.wizardForm.get("vehicleYear").value;
    this.req.vehicleVin = this.wizardForm.get("vehicleVin").value;
    this.req.symptoms = this.wizardForm.get("symptoms").value;
    this.req.userComments = this.wizardForm.get("userComments").value;
    this.req.preferredContactMethod = this.wizardForm.get("preferredContactMethod").value;
    this.req.vehicleLocation = this.wizardForm.get("vehicleLocation").value;
  }
  ngOnInit() {
    this.initForm();
    this.requestIdSubscription = this.activatedRoute.params.subscribe((params: Params) => {
      let paramMode = params['mode'];
      if (paramMode) {
        this.mode = paramMode;
      }
      let requestIdLocal = params['requestId'];
      if (requestIdLocal) {
        this.requestId = requestIdLocal;
      }
      console.log(this.mode);
    });
    if (this.requestId && this.mode != 'NEW') {
      this.selectRequestSubscription = this.reqCrudSvc.getRequest(this.requestId).subscribe(
        (record: CarServiceRequestTrackerModel) => {
          this.req = record;
          console.log(record);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
  ngOnDestroy() {
    if (this.requestIdSubscription) {
      this.requestIdSubscription.unsubscribe();
    }
    if (this.selectRequestSubscription) {
      this.selectRequestSubscription.unsubscribe();
    }

  }
  next() {
    if (this.currentStep == 'car') {
      this.currentStep = 'finish';
      this.stepCarOK = true;
    }
    if (this.currentStep == 'contact') {
      this.currentStep = 'car'
      this.stepContactOK = true;
    }
  }
  previous() {
    if (this.currentStep == 'car') {
      this.currentStep = 'contact';
    }
    if (this.currentStep == 'finish') {
      this.currentStep = 'car'
    }
  }
  cancel() {
    if (this.mode == 'NEW') {
      this.router.navigate(['/home']);
    } else {
      this.router.navigate(['/my-requests']);
    }
  }

  edit() {
    this.mode = 'EDIT';
    this.hideAlert();
  }
  hideAlert() {
    this.showMessage = false;
  }
  showAlert(msg: string) {
    this.alertMessage = msg;
    this.showMessage = true;
  }
  onSubmit() {
    this.updateModel();
    if (this.mode == 'EDIT') {
      this.reqCrudSvc.updateRequest(this.req).subscribe(
        (response) => {
          this.req = response.data;
          this.mode = 'VIEW';
          this.showAlert('Saved successfully');
        },
        (error) => {
          console.log(error);
        }
      );
    } else {
      this.reqCrudSvc.newRequest(this.req).subscribe(
        (response) => {
          this.req = response.data;
          this.mode = 'VIEW';
          this.showAlert('Created a new estimate request successfully, Request Id: ' + this.req.requestId);
        },
        (error) => {
          console.log(error);
        });
    }
  }
  toModel(form: NgForm): CarServiceRequestTrackerModel {
    let req: CarServiceRequestTrackerModel = new CarServiceRequestTrackerModel();
    req.customerFirstName = form.value.customerFirstName;
    req.customerLastName = form.value.customerLastName;
    req.email = form.value.email;
    req.customerPhone = form.value.customerPhone;
    req.addressCity = form.value.addressCity;
    req.addressState = form.value.addressState;
    req.addressZip = form.value.addressZip;
    req.vehicleMake = form.value.vehicleMake;
    req.vehicleModel = form.value.vehicleModel;
    req.vehicleYear = form.value.vehicleYear;
    req.preferredContactMethod = form.value.preferredContactMethod;
    req.vehicleLocation = form.value.vehicleLocation;
    req.symptoms = form.value.symptoms;
    req.userComments = form.value.userComments;
    req.requestedDate = form.value.requestedDate;
    req.vehicleVin = form.value.vehicleVin;
    req.addressLine1 = form.value.addressLine1;
    req.addressLine2 = form.value.addressLine2;
    return req;
  }
}
