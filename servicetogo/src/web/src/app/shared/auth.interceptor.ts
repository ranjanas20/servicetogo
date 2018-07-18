import { HttpInterceptor, HttpRequest, HttpHandler, HttpSentEvent, 
    HttpHeaderResponse, HttpProgressEvent, HttpResponse,HttpUserEvent } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

export class AuthInterceptor implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpSentEvent | HttpHeaderResponse | HttpProgressEvent | HttpResponse<any> | HttpUserEvent<any>> {
        console.log("Auth Interceptor");
        return next.handle(req);
    }
}