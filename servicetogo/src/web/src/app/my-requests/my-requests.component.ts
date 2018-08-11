import { Component, OnInit, Injectable, ViewChild } from '@angular/core';
import { MyRequestService } from '../shared/myrequest.service';
import { NgForm } from '@angular/forms';
import { SearchResponseModel } from '../shared/model/searchresponse.model';
import { CarServiceRequestTrackerModel } from '../shared/model/carservicerequesttracker.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-requests',
  templateUrl: './my-requests.component.html',
  styleUrls: ['./my-requests.component.css']
})

export class MyRequestsComponent implements OnInit {
  currentPage: number=1;
  totalPages: number=1;  
  pageSize: number=5;
  myRequests: CarServiceRequestTrackerModel[];
  requestIdSelected: number;
  pageArray: number[];
  searchForm: CarServiceRequestTrackerModel;
  tabname:string='OPEN';
  alertMessage:string="No message";
  hide:number=1;
  showProgressBar: boolean=false;

  constructor(private myReqSvc: MyRequestService, private router: Router) { }
  hideAlert(){
    this.hide=1;
  }
  clearSearchForm(form: NgForm){
    form.reset();
    this.searchForm = new CarServiceRequestTrackerModel();
  }
  getRequests(event,status:string){
    this.currentPage=1;
    this.totalPages=1;  
    this.tabname = status;
    this.search();  
    event.preventDefault();
  }
  gotoPage(event,newPage:number){
   
    if(newPage!=this.currentPage){
      this.currentPage=newPage;
      this.search();
    }
    event.preventDefault();
  }
  confirmDelete(yes:boolean){
    console.log("Option:"+event);
    if(yes){
      this.deleteRequest(this.requestIdSelected);
    }
  }
  sort(event,field:string){
    event.preventDefault();
  }
  editRequest(event,requestId:number){
    this.router.navigate(['/estimate-wizard/'+requestId+'/EDIT']);
    event.preventDefault();
  }
  viewRequest(event,requestId:number){
    //this.router.navigate(['/free-estimate/'+requestId+'/VIEW']);
    this.router.navigate(['/estimate-wizard/'+requestId+'/VIEW']);
    event.preventDefault();
  }
  deleteRequest(requestId:number){
    this.showProgressBar=true;
    this.myReqSvc.delete(requestId).subscribe(
      (resp: string)=>{
        this.showProgressBar=false;
        this.alertMessage="Request Id "+requestId+" deleted successfully!";
        this.hide=0;
        this.search();
      }, 
      (error)=>{
        console.log(error);
        this.showProgressBar=false;

      } 
    );
  }
  deleteMe(event,requestId:number){
    this.requestIdSelected=requestId;
    event.preventDefault();
  }
  search(){
    this.showProgressBar=true;
    this.searchForm.serviceStatus=this.tabname;
    this.myReqSvc.search(this.currentPage, this.pageSize, this.searchForm).subscribe(
      (resp: SearchResponseModel)=>{
        this.myRequests=resp.data;
        this.currentPage=resp.pageNumber;
        this.totalPages=resp.totalPapges;
        this.setPageArray();
        this.showProgressBar=false;
      }, 
      (error)=>{
        console.log(error);
        this.showProgressBar=false;
      } 
    );
  }
  previous(event){
    if(this.currentPage!=1){
      this.currentPage = this.currentPage -1;
      this.search();
    }     
    event.preventDefault();
  }
  next(event){
    if(this.currentPage!=this.totalPages){
      this.currentPage = this.currentPage +1;
      this.search();      
    }
    event.preventDefault();
  }
  onSubmit(form: NgForm){
    this.setSearchForm(form);
    this.search();
  }
  ngOnInit() {
    this.searchForm = new CarServiceRequestTrackerModel();
    this.search();    
  }
  ngOnDestroy(){

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
