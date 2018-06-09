import { BrowserModule } from '@angular/platform-browser';
import { NgModule, InjectionToken } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FaqComponent } from './faq/faq.component';
import { HowitworksComponent } from './howitworks/howitworks.component';
import { FreeEstimateComponent } from './free-estimate/free-estimate.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { MyRequestsComponent } from './my-requests/my-requests.component';
import { AppRouteModule } from './approute.module';
import { AuthService } from './shared/auth.service';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { Environment } from './shared/environment.service';
import { MyRequestService } from './shared/myrequest.service';
import { RequestCrudService } from './shared/requestcrud.service';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FaqComponent,
    HowitworksComponent,
    FreeEstimateComponent,
    LoginComponent,
    SignupComponent,
    MyRequestsComponent,
    MyProfileComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpModule, AppRouteModule
  ],
  providers: [AuthService,Environment, MyRequestService, RequestCrudService],
  bootstrap: [AppComponent] 
})
export class AppModule { }