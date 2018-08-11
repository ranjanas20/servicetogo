import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { RequestCrudService } from '../../shared/requestcrud.service';
import { CarServiceRequestTrackerModel } from '../../shared/model/carservicerequesttracker.model';
import { Subscription } from 'rxjs/Subscription';
import { ZipLookupService } from '../../shared/ziplookup.service';
import { ZipLookupModel } from '../../shared/model/ziplookup.model';
import { ResponseModel } from '../../shared/model/response.model';

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
  zipLookupSubscription: Subscription;
  zipLookupData: ZipLookupModel = new ZipLookupModel();

  showProgressBar: boolean=false;

  constructor(private router: Router,
    private reqCrudSvc: RequestCrudService,
    private activatedRoute: ActivatedRoute,
    private zipLookupSvc: ZipLookupService) { }
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
        if(this.requestId>0 && this.mode && this.mode != 'NEW'){
          this.loadData(requestIdLocal, paramMode);
        }
        
      });      
    }
  loadData(requestIdLocal:number, modeLocal: string){
    if (requestIdLocal>0 && modeLocal != 'NEW') {
      this.showProgressBar=true;
      this.selectRequestSubscription = this.reqCrudSvc.getRequest(this.requestId).subscribe(
        (record: CarServiceRequestTrackerModel) => {
          this.req = record;
          console.log(record);
          this.showProgressBar=false;
          this.updateForm(record);
        },
        (error) => {
          console.log(error);
          this.showProgressBar=false;
        }
      );
    }
  }
  initForm() {
    this.wizardForm = new FormGroup({
      contact: new FormGroup({
        'requestId': new FormControl('', []),
        'customerId': new FormControl('', []),
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
        'addressState': new FormControl('', [Validators.required, Validators.maxLength(50)])
      }),
      car: new FormGroup({
        'vehicleMake': new FormControl('', [Validators.required, Validators.maxLength(50)]),
        'vehicleModel': new FormControl('', [Validators.required, Validators.maxLength(50)]),
        'vehicleYear': new FormControl('', [Validators.required, Validators.maxLength(4)]),
        'vehicleVin': new FormControl('', [ Validators.maxLength(16)]),
        'symptoms': new FormControl('', [ Validators.maxLength(100)]),
        'userComments': new FormControl('', [Validators.maxLength(100)]),
        'vehicleLocation': new FormControl('', [ Validators.maxLength(50)])
      })
    });
  }
  updateForm(record:CarServiceRequestTrackerModel) {
    let contact = this.wizardForm.get('contact');
    let car = this.wizardForm.get('car');

    contact.get("requestId").setValue(record.requestId);
    contact.get("customerId").setValue(record.customerId);
    contact.get("customerFirstName").setValue(record.customerFirstName);
    contact.get("customerLastName").setValue(record.customerLastName);
    contact.get("customerMiddleName").setValue(record.customerMiddleName);
    contact.get("email").setValue(record.email);
    contact.get("customerPhone").setValue(record.customerPhone);
    contact.get("addressLine1").setValue(record.addressLine1);
    contact.get("addressLine2").setValue(record.addressLine2);
    contact.get("addressCity").setValue(record.addressCity);
    contact.get("addressState").setValue(record.addressState);
    contact.get("addressZip").setValue(record.addressZip);
    contact.get("requestedDate").setValue(record.requestedDate);
    contact.get("preferredContactMethod").setValue(record.preferredContactMethod);

    car.get("vehicleMake").setValue(record.vehicleMake);
    car.get("vehicleModel").setValue(record.vehicleModel);
    car.get("vehicleYear").setValue(record.vehicleYear);
    car.get("vehicleVin").setValue(record.vehicleVin);
    car.get("symptoms").setValue(record.symptoms);
    car.get("userComments").setValue(record.userComments);
    car.get("vehicleLocation").setValue(record.vehicleLocation);
  }
  updateModel() {
    let contact = this.wizardForm.get('contact');
    let car = this.wizardForm.get('car');

    this.req.requestId = contact.get("requestId").value;
    this.req.customerId = contact.get("customerId").value;
    this.req.customerFirstName = contact.get("customerFirstName").value;
    this.req.customerLastName = contact.get("customerLastName").value;
    this.req.customerMiddleName = contact.get("customerMiddleName").value;
    this.req.email = contact.get("email").value;
    this.req.customerPhone = contact.get("customerPhone").value;
    this.req.addressLine1 = contact.get("addressLine1").value;
    this.req.addressLine2 = contact.get("addressLine2").value;
    this.req.addressCity = contact.get("addressCity").value;
    this.req.addressState = contact.get("addressState").value;
    this.req.addressZip = contact.get("addressZip").value;
    this.req.requestedDate = contact.get("requestedDate").value;
    this.req.preferredContactMethod = contact.get("preferredContactMethod").value;

    this.req.vehicleMake = car.get("vehicleMake").value;
    this.req.vehicleModel = car.get("vehicleModel").value;
    this.req.vehicleYear = car.get("vehicleYear").value;
    this.req.vehicleVin = car.get("vehicleVin").value;
    this.req.symptoms = car.get("symptoms").value;
    this.req.userComments = car.get("userComments").value;
    this.req.vehicleLocation = car.get("vehicleLocation").value;
  }
  

  ngOnDestroy() {
    if (this.requestIdSubscription) {
      this.requestIdSubscription.unsubscribe();
    }
    if (this.selectRequestSubscription) {
      this.selectRequestSubscription.unsubscribe();
    }
    if (this.zipLookupSubscription) {
      this.zipLookupSubscription.unsubscribe();
    }
  }

  isStepValid(){
    if(this.currentStep == 'contact'){
        return this.wizardForm.get("contact").valid
    }else if(this.currentStep == 'car'){
      return this.wizardForm.get("car").valid;
    }else{
      return true;
    }
  }
  next() {
    this.updateModel();
    if (this.currentStep == 'car') {
      this.currentStep = 'finish';
      this.stepCarOK = true;
    }
    if (this.currentStep == 'contact') {
      this.currentStep = 'car'
      this.stepContactOK = true;
    }
    console.log(this.wizardForm);

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
    this.currentStep='contact';
    this.updateForm(this.req);
  }
  hideAlert() {
    this.showMessage = false;
  }
  showAlert(msg: string) {
    this.alertMessage = msg;
    this.showMessage = true;
  }
  onSubmit() {
    this.showProgressBar=true;
    this.updateModel();
    if (this.mode == 'EDIT') {
      this.reqCrudSvc.updateRequest(this.req).subscribe(
        (response) => {
          this.req = response.data;
          this.mode = 'VIEW';
          this.currentStep='done';
          this.showAlert('Saved successfully');
          this.showProgressBar=false;
        },
        (error) => {
          console.log(error);
          this.showProgressBar=false;
        }
      );
    } else {
      this.reqCrudSvc.newRequest(this.req).subscribe(
        (response) => {
          this.req = response.data;
          this.mode = 'VIEW';
          this.currentStep='done';
          this.showAlert('Created a new estimate request successfully, Request Id: ' + this.req.requestId);
          this.showProgressBar=false;
        },
        (error) => {
          console.log(error);
          this.showProgressBar=false;
        });
    }
  }

  populateCityState(event){
    console.log("lookup service called");
    let zipcode: string = this.wizardForm.get('contact').get("addressZip").value;
    console.log("zipcode:" + zipcode);
    this.zipLookupSubscription = this.zipLookupSvc.getCityState(zipcode).subscribe(
      (resp: ResponseModel) => {
        if(resp.success) {
          this.zipLookupData = resp.data;
          this.displayCityState();
        } else {
          this.resetZipLookupData();
          this.displayCityState();
        }
      },
      (error) => {
        console.log(error);
      }
    );
    event.preventDefault();
  }

  displayCityState() {
    this.wizardForm.get('contact').get('addressCity').setValue(this.zipLookupData.city);
    this.wizardForm.get('contact').get('addressState').setValue(this.zipLookupData.stateCode);
  }

  resetZipLookupData(){
    this.zipLookupData.city='';
    this.zipLookupData.stateCode='';
    this.zipLookupData.stateName='';
  }

}
