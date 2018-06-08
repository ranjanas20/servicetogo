import { Component, OnInit, Injectable } from '@angular/core';
import { MyRequestService } from '../shared/myrequest.service';
import { RequestModel } from '../shared/request.model';

@Component({
  selector: 'app-my-requests',
  templateUrl: './my-requests.component.html',
  styleUrls: ['./my-requests.component.css']
})

export class MyRequestsComponent implements OnInit {
  myRequests: RequestModel[];
  constructor(private myReqSvc: MyRequestService) { }

  ngOnInit() {
    this.myReqSvc.getAllRequests().subscribe(
      (requests: RequestModel[])=>{
        this.myRequests=requests;
      }, 
      (error)=>{
        console.log(error);
      }
    );
  }

}
