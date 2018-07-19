import { Component, OnInit, Injectable, ViewChild } from '@angular/core';
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
  searchForm: CarServiceRequestTrackerModel;
  @ViewChild('f') searchformView : NgForm; 
  constructor(private myReqSvc: MyRequestService) { }

  clearSearchForm(){
    this.searchformView.reset();
    this.searchForm = new CarServiceRequestTrackerModel();
  }
  previous(){
    if(this.currentPage!=1){
      this.currentPage = this.currentPage -1;
      this.myReqSvc.search(this.currentPage, 20, this.searchForm).subscribe(
        (resp: SearchResponseModel)=>{
          this.myRequests=resp.data;
          this.currentPage=resp.pageNumber;
          this.totalPages=resp.totalPapges;
          this.setPageArray();
        }, 
        (error)=>{
          console.log(error);
        } 
      );
    }
  }
  next(){
    if(this.currentPage!=this.totalPages){
      this.currentPage = this.currentPage +1;
      this.myReqSvc.search(this.currentPage, 20, this.searchForm).subscribe(
        (resp: SearchResponseModel)=>{
          this.myRequests=resp.data;
          this.currentPage=resp.pageNumber;
          this.totalPages=resp.totalPapges;
          this.setPageArray();
        }, 
        (error)=>{
          console.log(error);
        }
      );
    }
  }
  onSubmit(form: NgForm){
    this.setSearchForm(form);
    this.myReqSvc.search(this.currentPage, 20, this.searchForm).subscribe(
      (resp: SearchResponseModel)=>{
        this.myRequests=resp.data;
        this.currentPage=resp.pageNumber;
        this.totalPages=resp.totalPapges;
        this.setPageArray();
      }, 
      (error)=>{
        console.log(error);
      }
    );
  }
  ngOnInit() {
    this.searchForm = new CarServiceRequestTrackerModel();
    this.myReqSvc.search(this.currentPage, 20, this.searchForm).subscribe(
      (resp: SearchResponseModel)=>{
        this.myRequests=resp.data;        
        this.currentPage=resp.pageNumber;
        this.totalPages=resp.totalPapges;
        this.setPageArray();
      }, 
      (error)=>{
        console.log(error);
      }
    );
  }
  setSearchForm(form: NgForm){
    this.searchForm = new CarServiceRequestTrackerModel();
    this.searchForm.customerLastName = form.value.customerLastName;
    this.searchForm.customerFirstName = form.value.customerFirstName;
  }
  setPageArray(){
    this.pageArray = new Array();
      for (let i = 1; i <= this.totalPages; i++) {
        this.pageArray.push(i);
     }
  }
}
