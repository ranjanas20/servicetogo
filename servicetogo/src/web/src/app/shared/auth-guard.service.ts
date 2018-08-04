import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from "@angular/router";
import { AuthService } from "./auth.service";
import { Injectable } from "@angular/core";

@Injectable()
export class AuthGuard implements CanActivate{

  loggedIn: boolean = false;

  constructor (private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    this.authService.loggedin.subscribe(
      (value) => {
        this.loggedIn = value;
      }
    );

    if ( !this.loggedIn ) {
      this.router.navigate(['login']);
      return false;
    }

    return true;
  }
}
