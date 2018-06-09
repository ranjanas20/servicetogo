import { Injectable, Inject } from "@angular/core";
import { Environment } from "./environment.service";
import { Http, Headers, Response } from "@angular/http";
import { RequestModel } from "./request.model";
import { Observable } from "rxjs/Observable";

@Injectable()
export class RequestCrudService{
    constructor(private env:Environment, private http: Http ){ }
    newRequest(request: RequestModel){
        const cheaders = new Headers({'Content-Type':'application/json'});
       return  this.http.post(this.env.REST_URL+'/requestHeaders',
                                request,
                                {headers: cheaders}
                                );
       
    }
    updateRequest(request: RequestModel){
        const cheaders = new Headers({'Content-Type':'application/json'});
       return  this.http.put(this.env.REST_URL+'/requestHeaders',
                                request,
                                {headers: cheaders}
                                );
       
    }
    getRequest(requestId: number){
       return  this.http.get(this.env.REST_URL+'/requestHeaders/'+requestId)
            .map(
                    (response: Response)=>{
                        const data = response.json();
                        return data;
                    }
                ).catch((error: Response)=>{
                    console.log(error);
                    return Observable.throw("Something went wrong");
                    
                });;
       
    }
}