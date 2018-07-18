import { Injectable, Inject } from "@angular/core";
import { Environment } from "./environment.service";
import { Http, Headers, Response } from "@angular/http";
import { Observable } from "rxjs/Observable";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { CarServiceRequestTrackerModel } from "./careervicerequesttracker.model";

@Injectable()
export class RequestCrudService{
    constructor(private env:Environment, private http: HttpClient ){ }
    newRequest(request: CarServiceRequestTrackerModel){
        const cheaders = new HttpHeaders({'Content-Type':'application/json'});
       return  this.http.post(this.env.REST_URL+'/requestHeaders',
                                request,
                                {headers: cheaders}
                                );
       
    }
    updateRequest(request: CarServiceRequestTrackerModel){
        const cheaders = new HttpHeaders({'Content-Type':'application/json'});
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