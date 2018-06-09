import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RequestCrudService } from '../shared/requestcrud.service';
import { RequestModel } from '../shared/request.model';

@Component({
  selector: 'app-free-estimate',
  templateUrl: './free-estimate.component.html',
  styleUrls: ['./free-estimate.component.css']
})
export class FreeEstimateComponent implements OnInit {

  constructor(private router: Router,private reqCrudSvc: RequestCrudService) { }

  ngOnInit() {
  }
  onSubmit(form: NgForm){
    console.log(form);
    let req: RequestModel= new RequestModel();
    req.reqId=70;
    this.reqCrudSvc.newRequest(req)
    .subscribe(
      (response)=>{
        console.log(response);
      }, 
      (error)=>{
        console.log(error);
      });
  } 
}
