import { Injectable } from "@angular/core";

@Injectable()
export class Environment{
    public REST_URL: string = "http://localhost:8080";

    public ROLE_CUSTOMER: string = 'role_customer';
    public ROLE_MANAGER: string = 'role_manager';
    public ROLE_EMPLOYEE: string = 'role_employee';

}
