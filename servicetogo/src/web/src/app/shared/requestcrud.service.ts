import { Injectable, Inject } from "@angular/core";
import { Environment } from "./environment.service";

@Injectable()
export class RequestCrudService{
    constructor(private env:Environment ){ }
}