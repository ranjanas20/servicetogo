import 'rxjs/Rx';
import { Injectable } from '@angular/core';
import { Environment } from './environment.service';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'
import { ResponseModel } from './model/response.model';
import { Observable } from 'rxjs/Observable';
import { UserCredentialModel } from './model/usercredential.model';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { RoleResponseModel } from './model/roleresponse.model';
import { RoleModel } from './model/role.model';


@Injectable()
export class AuthService {
    userroles: BehaviorSubject<RoleModel[]>= new BehaviorSubject([]);
    private url: string = this.env.REST_URL;
    loggedin: BehaviorSubject<boolean> = new BehaviorSubject(false);
    username: BehaviorSubject<string> = new BehaviorSubject('');
    constructor(private env: Environment, private http: HttpClient) { }
    signup(cred: UserCredentialModel) {
        return this.http.post<ResponseModel>(this.env.REST_URL + '/signup', cred, {
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
    changeCredentials(cred: UserCredentialModel) {
        return this.http.post<ResponseModel>(this.env.REST_URL + '/credupdate', cred, {
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
    login3(user: string, pwd: string) {
        let body = new URLSearchParams();
        body.set('username', user);
        body.set('password', pwd);
        body.set('submit', 'Login');
        let options = {
            responseType: 'json',
            headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
        };
        console.log(body.toString());
        return this.http.post(this.env.REST_URL + '/login', body.toString(), {
            observe: 'body',
            responseType: 'text',
            headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
        }).map(
            (resp) => {
                if (resp.indexOf("Your login attempt was not successful") > 0) {
                    return Observable.throw("You user or password not valid");
                }
                return user;
            }
        ).catch((error) => {
            console.log(error);
            return Observable.throw("Something went wrong");

        });
    }
    getUserRoles(username: string) {

    return this.http.get<RoleResponseModel>(this.env.REST_URL + '/getroles', {
      observe: 'body',
      responseType: 'json',
      params: new HttpParams().append('loginId',username),
      headers: new HttpHeaders().set("token", "Sanjay"),
      withCredentials: true
    })
    .map(
      (resp) => {
          return resp;
      }
    ).catch((error) => {
      console.log(error);
      return Observable.throw("Error is getting Roles");

    });
    }
    login(user: string, pwd: string) {
        let ttk = 'Basic ' + btoa(user + ':' + pwd);
        console.log(ttk);
        const headers2 = new HttpHeaders().set(
            'authorization', ttk.toString()
        );
        console.log(headers2.toString());
        let cred: UserCredentialModel = new UserCredentialModel();
        cred.loginId = user;
        cred.loginPassword = pwd;
        return this.http.get(this.env.REST_URL + '/dummylogin',
                {
                    headers: headers2,
                    withCredentials: true

                }
            ).map(
            (resp) => {
                return "SUCCESS";
            }
        ).catch((error) => {
            console.log(error);
            return Observable.throw("Something went wrong");

        });
    }
}
