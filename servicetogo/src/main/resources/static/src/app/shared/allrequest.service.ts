import { Inject, Injectable } from "@angular/core";
import { REST_URL } from "../app.module";

@Injectable()
export class AllRequestService{
    constructor(@Inject(REST_URL) private url: string){ }
}