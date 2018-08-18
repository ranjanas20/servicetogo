import 'rxjs/Rx';
import { Injectable } from '@angular/core';
import { Environment } from './environment.service';
import { HttpClient, HttpResponse, HttpHeaders, HttpParams } from '@angular/common/http'
import { ResponseModel } from './model/response.model';
import { Observable } from 'rxjs/Observable';
import { UserCredentialModel } from './model/usercredential.model';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';


@Injectable()
export class AuthService {
    private url: string = this.env.REST_URL;
    loggedin: BehaviorSubject<boolean> = new BehaviorSubject(false);
    username: BehaviorSubject<string>=new BehaviorSubject('');
    constructor(private env: Environment, private http: HttpClient) { }
    signup(cred: UserCredentialModel) {
        return this.http.post<ResponseModel>(this.env.REST_URL + '/signup',cred, {
            observe: 'body',
            responseType: 'json'
        })
        .map(
            (data) => {
                return data;
            }
        ).catch((error) => {
            console.log(error);
            return Observable.throw("Something went wrong");

        });
    }
    changeCredentials(cred: UserCredentialModel){
        return this.http.post<ResponseModel>(this.env.REST_URL + '/credupdate',cred, {
            observe: 'body',
            responseType: 'json'
        })
        .map(
            (data) => {
                return data;
            }
        ).catch((error) => {
            console.log(error);
            return Observable.throw("Something went wrong");

        });
    }
    logout() {
        this.loggedin.next(false);
        this.username.next('');
    }
    login(user: string, pwd: string) {
      let body = new URLSearchParams();
      body.set('username', user);
      body.set('password', pwd);
      body.set('submit', 'Login');
      let options = {
        responseType: 'json',
        headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
      };
      console.log(body.toString());
       return this.http.post(this.env.REST_URL + '/login',body.toString(), {
        observe: 'body',
        responseType: 'text',
        headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
      }).map(
               (resp) => {
                   if ( resp.indexOf("Your login attempt was not successful")>0){
                     return Observable.throw("You user or password not valid");
                   }
                   return user;
               }
           ).catch((error) => {
               console.log(error);
               return Observable.throw("Something went wrong");

           });
   }
    login2(user: string, pwd: string) {

       let cred: UserCredentialModel = new UserCredentialModel();
        cred.loginId=user;
        cred.loginPassword=pwd;
      return this.http.post<ResponseModel>(this.env.REST_URL + '/applogin',cred).map(
                (data) => {
                    return data;
                }
            ).catch((error) => {
                console.log(error);
                return Observable.throw("Something went wrong");

            });
    }
}
