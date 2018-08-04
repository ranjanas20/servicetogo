import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'
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
import { CustomerService } from './shared/customer.service';
import { MsgUtilComponent } from './msg-util/msg-util.component';
import { ProgressMaskComponent } from './progress-mask/progress-mask.component';
import { AuthGuard } from './shared/auth-guard.service';
import { FreeEstimateWizardComponent } from './free-estimate-wizard/free-estimate-wizard.component';


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
    MyProfileComponent,
    MsgUtilComponent,
    ProgressMaskComponent,
    FreeEstimateWizardComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, AppRouteModule, ReactiveFormsModule
  ],
  providers: [AuthService,Environment, MyRequestService, RequestCrudService, CustomerService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
