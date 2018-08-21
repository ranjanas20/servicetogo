import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from '../../shared/auth.service';
import { Subscription } from 'rxjs/Subscription';
import { Router } from '@angular/router';
import { RoleModel } from '../../shared/model/role.model';

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
  constructor(private authsvc: AuthService, private router: Router) {

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
      }
    );
  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
  onLogout(){
    this.authsvc.loggedin.next(false);
    this.router.navigate(['home']);
  }
}
