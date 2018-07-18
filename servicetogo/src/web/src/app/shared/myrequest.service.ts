import { Inject, Injectable } from "@angular/core";

import { Http, Headers, Response } from "@angular/http";
import {HttpClient, HttpResponse, HttpHeaders, HttpParams} from '@angular/common/http'

import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Environment } from "./environment.service";
import { SearchResponseModel } from "./searchresponse.model";
import { CarServiceRequestTrackerModel } from "./careervicerequesttracker.model";
@Injectable()
export class MyRequestService{
    constructor(private env:Environment, private http: HttpClient){ }
    
    search(pageNo: number, pageSize: number, searchForm: CarServiceRequestTrackerModel): Observable<SearchResponseModel> {
        return this.http.post<SearchResponseModel>(this.env.REST_URL+'/search',searchForm,{
            observe: 'body',
            responseType: 'json',
            headers: new HttpHeaders().set("token","Sanjay"),
            params: new HttpParams().set("pageNo",pageNo.toString()).set("pageSize",pageSize.toString())
        })
        .map(
            (data)=>{
                return data;
            }
        ).catch((error: Response)=>{
            console.log(error);
            return Observable.throw("Something went wrong");
            
        });
    }
}