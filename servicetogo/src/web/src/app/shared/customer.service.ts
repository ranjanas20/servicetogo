import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Environment } from "./environment.service";
import { ResponseModel } from "./response.model";
import { Observable } from "rxjs/Observable";

@Injectable()
export class CustomerService{
    constructor(private env: Environment, private http: HttpClient) { }

    getCustProfile(username: string) {       
        return this.http.get<ResponseModel>(this.env.REST_URL + '/profilebyid', {
                observe: 'body',
                responseType: 'json',
                params: new HttpParams().append('loginId',username),
                headers: new HttpHeaders().set("token", "Sanjay")
            })
            .map(
                (resp) => {
                    return resp.data;
                }
            ).catch((error) => {
                console.log(error);
                return Observable.throw("Something went wrong");

            });
    }
}