import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RequestCrudService } from '../shared/requestcrud.service';
import { CarServiceRequestTrackerModel } from '../shared/careervicerequesttracker.model';

@Component({
  selector: 'app-free-estimate',
  templateUrl: './free-estimate.component.html',
  styleUrls: ['./free-estimate.component.css']
})
export class FreeEstimateComponent implements OnInit {
  @ViewChild('f') feform : NgForm; 
  constructor(private router: Router, private reqCrudSvc: RequestCrudService) { }

  ngOnInit() {
  }
  resetForm(){
    this.feform.reset();
  }
  onSubmit(form: NgForm) {
    console.log(form);
    let req: CarServiceRequestTrackerModel = this.toModel(form);
   
    this.reqCrudSvc.newRequest(req)
      .subscribe(
        (response) => {
          console.log(response);
        },
        (error) => {
          console.log(error);
        }); 

        //form.reset();
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
