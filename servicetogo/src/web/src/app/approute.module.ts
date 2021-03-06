import { Routes, RouterModule} from '@angular/router';
import { NgModule } from '@angular/core';
import { FaqComponent } from './home/faq/faq.component';
import { FreeEstimateComponent } from './estimates/free-estimate/free-estimate.component';
import { MyRequestsComponent } from './my-requests/my-requests.component';
import { HowitworksComponent } from './home/howitworks/howitworks.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { AuthGuard } from './shared/auth-guard.service';
import { FreeEstimateWizardComponent } from './estimates/free-estimate-wizard/free-estimate-wizard.component';
import { WorklistsComponent } from './vendor/worklists/worklists.component';
import { DashboardComponent } from './vendor/dashboard/dashboard.component';

const appRoutes: Routes=[
  {path:'',  redirectTo: 'home',pathMatch:'full' },
  {path: 'home', component: HomeComponent},
  {path:'faq', component: FaqComponent},
  {path:'free-estimate', component: FreeEstimateComponent},
  {path:'estimate-wizard', component: FreeEstimateWizardComponent},
  {path:'estimate-wizard/:requestId/:mode', component: FreeEstimateWizardComponent},
  {path:'free-estimate/:requestId/:mode', component: FreeEstimateComponent},
  {path: 'my-requests', component: MyRequestsComponent, canActivate: [AuthGuard]},
  {path: 'worklist', component: WorklistsComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'howitworks', component: HowitworksComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'my-profile', component: MyProfileComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, {useHash: true} )
  ],
  exports: [RouterModule]
})
export class AppRouteModule{

}
