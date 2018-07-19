import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
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
