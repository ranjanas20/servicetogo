import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
  @ViewChild('f') feform : NgForm; 
  constructor() { }

  ngOnInit() {
  }
  resetForm(){
    this.feform.reset();
  }
  onSubmit( form: NgForm){
    
  }
}
