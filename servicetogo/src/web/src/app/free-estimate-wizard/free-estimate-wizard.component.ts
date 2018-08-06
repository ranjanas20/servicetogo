import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
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
  currentStep: string="contact";
  stepCarOK: boolean=false;
  stepContactOK: boolean=false;
  mode:string='NEW';  
  hide:number=1;
  alertMessage:string="No message";
  req: CarServiceRequestTrackerModel = new CarServiceRequestTrackerModel();
  requestId:number;
  @ViewChild('f') form;
  requestIdSubscription: Subscription;
  selectRequestSubscription: Subscription;

  constructor(private router: Router, 
    private reqCrudSvc: RequestCrudService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.requestIdSubscription = this.activatedRoute.params.subscribe((params: Params) => {
      let paramMode=params['mode'];
      if(paramMode){
        this.mode = paramMode;
      }
      let requestIdLocal = params['requestId'];
      if(requestIdLocal){
        this.requestId=requestIdLocal;
      }
      console.log(this.mode);
    });
    if(this.requestId && this.mode!='NEW'){
      this.selectRequestSubscription = this.reqCrudSvc.getRequest(this.requestId).subscribe(
        (record: CarServiceRequestTrackerModel) => {
          this.req=record;
          console.log(record);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
  ngOnDestroy(){
    if(this.requestIdSubscription){
      this.requestIdSubscription.unsubscribe();
    }
    if(this.selectRequestSubscription){
      this.selectRequestSubscription.unsubscribe();
    }
    
  }
  next(){
    if(this.currentStep=='car'){
      this.currentStep='finish';
      this.stepCarOK=true;
    }
    if(this.currentStep=='contact'){
      this.currentStep='car'
      this.stepContactOK=true;
    }
  }
  previous(){
    if(this.currentStep=='car'){
      this.currentStep='contact';
    }
    if(this.currentStep=='finish'){
      this.currentStep='car'
    }
  }
  cancel(){
    if(this.mode=='NEW'){
      this.router.navigate(['/home']);
    }else{
      this.router.navigate(['/my-requests']);
    }
  }
  resetForm(form: NgForm){
    form.reset();
  }
  edit(form){
    this.mode='EDIT';
    this.hideAlert();
  }
  hideAlert(){
    this.hide=1;
  }
  showAlert(msg:string){
    this.alertMessage=msg;
    this.hide=0;
  }
  onSubmit(form: NgForm) {
    if(this.mode=='EDIT'){
      this.reqCrudSvc.updateRequest(this.req).subscribe(
        (response) => {          
          this.req=response.data;
          this.mode='VIEW';
          this.showAlert('Saved successfully');
        },
        (error) => {
          console.log(error);
        }
      );
    }else{
      this.reqCrudSvc.newRequest(this.req).subscribe(
          (response) => {
            this.req=response.data;
            this.mode='VIEW';
            this.showAlert('Created a new estimate request successfully, Request Id: '+this.req.requestId);
          },
          (error) => {
            console.log(error);
          });  
    }
  }
  toModel(form: NgForm): CarServiceRequestTrackerModel{
    let req: CarServiceRequestTrackerModel = new CarServiceRequestTrackerModel();
    req.customerFirstName = form.value.customerFirstName;
    req.customerLastName = form.value.customerLastName;
    req.email=form.value.email;
    req.customerPhone=form.value.customerPhone;
    req.addressCity = form.value.addressCity;
    req.addressState= form.value.addressState;
    req.addressZip= form.value.addressZip; 
    req.vehicleMake= form.value.vehicleMake;
    req.vehicleModel=form.value.vehicleModel;
    req.vehicleYear=form.value.vehicleYear;
    req.preferredContactMethod=form.value.preferredContactMethod;
    req.vehicleLocation= form.value.vehicleLocation;
    req.symptoms=form.value.symptoms;
    req.userComments=form.value.userComments;
    req.requestedDate = form.value.requestedDate;
    req.vehicleVin= form.value.vehicleVin;
    req.addressLine1 = form.value.addressLine1;
    req.addressLine2= form.value.addressLine2;
    return req;
  }
}
