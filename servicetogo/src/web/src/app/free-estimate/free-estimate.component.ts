import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-free-estimate',
  templateUrl: './free-estimate.component.html',
  styleUrls: ['./free-estimate.component.css']
})
export class FreeEstimateComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  onSubmit(ngForm: NgForm){
    
  }
}
