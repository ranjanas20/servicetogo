import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'
import { AppComponent } from './app.component';
import { HeaderComponent } from './home/header/header.component';
import { HomeComponent } from './home/home.component';
import { FaqComponent } from './home/faq/faq.component';
import { HowitworksComponent } from './home/howitworks/howitworks.component';
import { FreeEstimateComponent } from './estimates/free-estimate/free-estimate.component';
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
import { MsgUtilComponent } from './util/msg-util/msg-util.component';
import { ProgressMaskComponent } from './util/progress-mask/progress-mask.component';
import { AuthGuard } from './shared/auth-guard.service';
import { FreeEstimateWizardComponent } from './estimates/free-estimate-wizard/free-estimate-wizard.component';
import { ViewEstimateComponent } from './estimates/view-estimate/view-estimate.component';
import { WorklistsComponent } from './vendor/worklists/worklists.component';
import { SkillQueueComponent } from './vendor/skill-queue/skill-queue.component';
import { ZipLookupService } from './shared/ziplookup.service';
import { ConfirmationDialogComponent } from './util/confirmation-dialog/confirmation-dialog.component';
import { Ng2GoogleChartsModule } from 'ng2-google-charts';
import { DashboardComponent } from './vendor/dashboard/dashboard.component';

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
    FreeEstimateWizardComponent,
    ViewEstimateComponent,
    WorklistsComponent,
    SkillQueueComponent,
    ConfirmationDialogComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, AppRouteModule, ReactiveFormsModule,
    Ng2GoogleChartsModule
  ],
  providers: [AuthService,Environment, MyRequestService, RequestCrudService,
  CustomerService, AuthGuard, ZipLookupService],
  bootstrap: [AppComponent]
})
export class AppModule { }
