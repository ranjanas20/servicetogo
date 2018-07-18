import { Component, OnInit, Injectable } from '@angular/core';
import { MyRequestService } from '../shared/myrequest.service';
import { NgForm } from '@angular/forms';
import { SearchResponseModel } from '../shared/searchresponse.model';
import { CarServiceRequestTrackerModel } from '../shared/careervicerequesttracker.model';

@Component({
  selector: 'app-my-requests',
  templateUrl: './my-requests.component.html',
  styleUrls: ['./my-requests.component.css']
})

export class MyRequestsComponent implements OnInit {
  currentPage: number=1;
  totalPages: number=3;  
  myRequests: CarServiceRequestTrackerModel[];
  pageArray: number[];
  constructor(private myReqSvc: MyRequestService) { }
  getPageArray(): number[]{
    if(!this.pageArray){
      this.pageArray = new Array();
      for (let i = 1; i <= this.totalPages; i++) {
        this.pageArray.push(i);
     }
    }
    return this.pageArray;
  } 
  onSubmit(form: NgForm){
    let searchForm: CarServiceRequestTrackerModel = new CarServiceRequestTrackerModel();
    this.myReqSvc.search(1, 20, searchForm).subscribe(
      (resp: SearchResponseModel)=>{
        this.myRequests=resp.data;
        this.currentPage=resp.pageNumber;
        this.totalPages=resp.totalPapges
      }, 
      (error)=>{
        console.log(error);
      }
    );
  }
  ngOnInit() {
    let searchForm: CarServiceRequestTrackerModel = new CarServiceRequestTrackerModel();
    this.myReqSvc.search(1, 20, searchForm).subscribe(
      (resp: SearchResponseModel)=>{
        this.myRequests=resp.data;        
        this.currentPage=resp.pageNumber;
        this.totalPages=resp.totalPapges
      }, 
      (error)=>{
        console.log(error);
      }
    );
  }

}
