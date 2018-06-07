import { Inject, Injectable } from "@angular/core";
import { REST_URL } from "../app.module";
import { Http, Headers, Response } from "@angular/http";
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";

@Injectable()
export class AllRequestService{
    constructor(@Inject(REST_URL) private url: string, private http: Http){ }
    getAllRequests(){
        return this.http.get(this.url+'/requestHeaders')
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