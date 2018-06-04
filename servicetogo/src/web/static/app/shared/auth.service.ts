import {Subject} from 'rxjs/Subject'
import { Injectable, Inject } from '@angular/core';
import { REST_URL } from '../app.module';

@Injectable()
export class AuthService{
    private url: string = "http://localhost:3500";
    constructor(){ }
    loggedin: Subject<boolean> = new Subject();
    signup(username: String, password: string, email: String){

    } 
    login(username: string, password: string){

        this.loggedin.next(true);
    }  
    logout(){
        this.loggedin.next(false);
    } 
}