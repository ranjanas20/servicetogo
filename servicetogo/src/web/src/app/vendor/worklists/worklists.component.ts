import { Component, OnInit } from '@angular/core';
import { CarServiceRequestTrackerModel } from '../../shared/model/carservicerequesttracker.model';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MyRequestService } from '../../shared/myrequest.service';
import { Router } from '@angular/router';
import { SearchResponseModel } from '../../shared/model/searchresponse.model';

@Component({
  selector: 'app-worklists',
  templateUrl: './worklists.component.html',
  styleUrls: ['./worklists.component.css']
})
export class WorklistsComponent implements OnInit {
  collapsed: boolean = true;
  tabname: string = 'notinworklist';
  currentPage: number = 1;
  totalPages: number = 1;
  pageSize: number = 10;
  myRequests: CarServiceRequestTrackerModel[];
  requestIdSelected: number;
  pageArray: number[];
  reqSelected: CarServiceRequestTrackerModel = new CarServiceRequestTrackerModel();
  searchFormModel: CarServiceRequestTrackerModel = new CarServiceRequestTrackerModel();

  alertMessage: string = "No message";
  hideAlertFlag: boolean = true;
  showProgressBar: boolean = false;

  searchFormGroup: FormGroup;

  constructor(private myReqSvc: MyRequestService, private router: Router) { }

  ngOnInit() {
    this.initSearchFormGroup();
    this.search();
  }
  selectRow(reqId: number) {
    this.requestIdSelected = reqId;
    let i: number;
    for (i = 0; i < this.myRequests.length; i++) {
      if (reqId === this.myRequests[i].requestId) {
        this.reqSelected = this.myRequests[i];
        break;
      }
    }
  }
  initSearchFormGroup() {
    this.searchFormGroup = new FormGroup({
      'email': new FormControl('', [Validators.maxLength(100)]),
      'customerFirstName': new FormControl('', [Validators.maxLength(50)]),
      'customerLastName': new FormControl('', [Validators.maxLength(50)]),
      'customerPhone': new FormControl('', [Validators.maxLength(10)]),
      'addressCity': new FormControl('', [Validators.maxLength(100)]),
      'addressZip': new FormControl('', [Validators.maxLength(5)]),
      'addressState': new FormControl('', [Validators.maxLength(50)])
    });
  }
  onSubmit() {
    this.search();
  }
  clearSearchForm() {
    this.searchFormGroup.reset();
  }
  setPageArray() {
    this.pageArray = new Array();
    for (let i = 1; i <= this.totalPages; i++) {
      this.pageArray.push(i);
    }
  }
  setSearchFormModel() {
    this.searchFormModel.email = this.searchFormGroup.get('email').value;
    this.searchFormModel.customerFirstName = this.searchFormGroup.get('customerFirstName').value;
    this.searchFormModel.customerLastName = this.searchFormGroup.get('customerLastName').value;
    this.searchFormModel.customerPhone = this.searchFormGroup.get('customerPhone').value;
    this.searchFormModel.addressCity = this.searchFormGroup.get('addressCity').value;
    this.searchFormModel.addressZip = this.searchFormGroup.get('addressZip').value;
    this.searchFormModel.addressState = this.searchFormGroup.get('addressState').value;
  }
  search() {
    this.showProgressBar = true;
    switch (this.tabname) {
      case 'notinworklist':
        this.searchFormModel.serviceStatus = 'NEW';
        break;
      case 'myworklist':
        this.searchFormModel.serviceStatus = 'ASSIGNED';
        break;
      case 'allworklist':
        this.searchFormModel.serviceStatus = 'ASSIGNED';
        break; 
      default:
        this.searchFormModel.serviceStatus = 'COMPLETED';
    }

    this.setSearchFormModel();
    this.myReqSvc.search(this.currentPage, this.pageSize, this.searchFormModel).subscribe(
      (resp: SearchResponseModel) => {
        this.myRequests = resp.data;
        this.currentPage = resp.pageNumber;
        this.totalPages = resp.totalPapges;
        this.setPageArray();
        if (this.myRequests.length > 0) {
          this.reqSelected = this.myRequests[0];
          this.requestIdSelected = this.reqSelected.requestId;
        }else{
          this.reqSelected = new CarServiceRequestTrackerModel();
          this.requestIdSelected = 0;
        }       
        this.showProgressBar = false;
      },
      (error) => {
        console.log(error);
        this.showProgressBar = false;
      }
    );
  }
  toggleIcon() {
    this.collapsed = !this.collapsed;
  }

  onClickTab(event, tabNameNew: string) {
    this.tabname = tabNameNew;
    this.search();
    event.preventDefault();
  }
  hideAlert() {
    this.hideAlertFlag = true;
  }

  previous(event) {
    if (this.currentPage != 1) {
      this.currentPage = this.currentPage - 1;
      this.search();
    }
    event.preventDefault();
  }
  next(event) {
    if (this.currentPage != this.totalPages) {
      this.currentPage = this.currentPage + 1;
      this.search();
    }
    event.preventDefault();
  }
}
