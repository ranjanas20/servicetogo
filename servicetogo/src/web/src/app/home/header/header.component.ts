import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from '../../shared/auth.service';
import { Subscription } from 'rxjs/Subscription';
import { Router } from '@angular/router';
import { RoleModel } from '../../shared/model/role.model';
import { Environment } from '../../shared/environment.service';
import { UtilService } from '../../shared/util.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  loggedIn: boolean;
  username:string='';
  userroles: RoleModel[];
  subscription: Subscription;
  subscription2: Subscription;
  roleList: Array<string> = [''];
  role_manager: string;
  role_customer: string;
  role_employee: string;

  constructor(private authsvc: AuthService,
        private router: Router,
        private env:Environment,
        private util:UtilService) {

   }

  ngOnInit() {
    this.subscription = this.authsvc.loggedin.subscribe((loggedin: boolean)=>{
      this.loggedIn = loggedin;
    });
    this.authsvc.username.subscribe(
      (name)=>{
        this.username=name;
      }
    );
    this.authsvc.userroles.subscribe(
      (roles)=>{
        console.log("role size from header component:"+roles.length);
        this.userroles=roles;
        this.roleList = this.util.getRoleNamesList(this.userroles);
        console.log("RoleList: "+this.roleList);
      }
    );

    //this.role_manager = this.env.ROLE_MANAGER;
    //this.role_customer = this.env.ROLE_CUSTOMER;
    //this.role_employee = this.env.ROLE_EMPLOYEE;

  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
  onLogout(){
    this.authsvc.loggedin.next(false);
    this.router.navigate(['home']);
  }
}
