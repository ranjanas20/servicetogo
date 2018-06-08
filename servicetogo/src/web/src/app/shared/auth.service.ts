import {Subject} from 'rxjs/Subject'
import { Injectable, Inject } from '@angular/core';
import { Environment } from './environment.service';

@Injectable()
export class AuthService{
    private url: string = this.env.REST_URL;
    loggedin: Subject<boolean> = new Subject();

    constructor(private env:Environment){ }
    signup(username: String, password: string, email: String){

    } 
    login(username: string, password: string){

        this.loggedin.next(true);
    }  
    logout(){
        this.loggedin.next(false);
    } 
}