import { Injectable, Inject } from "@angular/core";
import { REST_URL } from "../app.module";

@Injectable()
export class RequestCrudService{
    constructor(@Inject(REST_URL) private url: string){ }
}