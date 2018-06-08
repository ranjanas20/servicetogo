import { Inject, Injectable } from "@angular/core";

import { Http, Headers, Response } from "@angular/http";
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Environment } from "./environment.service";

@Injectable()
export class MyRequestService{
    constructor(private env:Environment, private http: Http){ }
    getAllRequests(){
        return this.http.get(this.env.REST_URL+'/requestHeaders')
        .map(
            (response: Response)=>{
                const data = response.json();
                return data;
            }
        ).catch((error: Response)=>{
            console.log(error);
            return Observable.throw("Something went wrong");
            
        });
    }
}