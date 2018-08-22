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

    private url: string = this.env.REST_URL;
    loggedin: BehaviorSubject<boolean> = new BehaviorSubject(false);
    username: BehaviorSubject<string> = new BehaviorSubject('');
    userroles: BehaviorSubject<RoleModel[]> = new BehaviorSubject([]);

    constructor(private env: Environment, private http: HttpClient) { }
    signup(cred: UserCredentialModel) {
        return this.http.post<ResponseModel>(this.env.REST_URL + '/signup', cred, {
            observe: 'body',
            responseType: 'json',
            withCredentials: true
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
            responseType: 'json',
            withCredentials: true
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
      getUserRoles(username: string) {

        return this.http.get<RoleResponseModel>(this.env.REST_URL + '/getroles', {
            observe: 'body',
            responseType: 'json',
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
        return this.http.get(this.env.REST_URL + '/basiclogin',
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
