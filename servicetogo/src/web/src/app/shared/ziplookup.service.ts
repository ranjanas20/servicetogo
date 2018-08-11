import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Environment } from "./environment.service";
import { ResponseModel } from "./model/response.model";
import { Observable } from "rxjs/Observable";

@Injectable()
export class ZipLookupService{
    constructor(private env: Environment, private http: HttpClient) { }

    getCityState(zipcode: string) {
        return this.http.get<ResponseModel>(this.env.REST_URL + '/citystate/'+zipcode, {
                observe: 'body',
                responseType: 'json',
                headers: new HttpHeaders().set("token", "Sanjay")
            })
            .map(
                (resp) => {
                    return resp;
                }
            ).catch((error) => {
                console.log(error);
                return Observable.throw("Something went wrong");

            });
    }

}
