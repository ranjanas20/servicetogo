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