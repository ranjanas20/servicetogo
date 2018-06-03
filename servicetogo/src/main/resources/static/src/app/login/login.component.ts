import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/auth.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authsvc: AuthService, private router: Router) { }

  ngOnInit() {
  }
  onSubmit(ngForm: NgForm){
    console.log(ngForm);
    console.log(ngForm.value.username);
    this.authsvc.login(ngForm.value.username,ngForm.value.password);
    this.router.navigate(['home']);
  }
}
