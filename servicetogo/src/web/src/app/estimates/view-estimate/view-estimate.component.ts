import { Component, OnInit, Input } from '@angular/core';
import { CarServiceRequestTrackerModel } from '../../shared/model/carservicerequesttracker.model';

@Component({
  selector: 'app-view-estimate',
  templateUrl: './view-estimate.component.html',
  styleUrls: ['./view-estimate.component.css']
})
export class ViewEstimateComponent implements OnInit {
  @Input() request: CarServiceRequestTrackerModel;

  constructor() { }

  ngOnInit() {
  }

}
