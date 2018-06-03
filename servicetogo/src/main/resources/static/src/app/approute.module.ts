import { Routes, RouterModule} from '@angular/router';
import { NgModule } from '@angular/core';
import { FaqComponent } from './faq/faq.component';
import { FreeEstimateComponent } from './free-estimate/free-estimate.component';
import { MyRequestsComponent } from './my-requests/my-requests.component';
import { HowitworksComponent } from './howitworks/howitworks.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { config } from 'process';
import { MyProfileComponent } from './my-profile/my-profile.component';
const appRoutes: Routes=[
  {path:'',  redirectTo: 'home',pathMatch:'full' },
  {path: 'home', component: HomeComponent},
  {path:'faq', component: FaqComponent},
  {path:'free-estimate', component: FreeEstimateComponent},
  {path: 'my-requests', component: MyRequestsComponent},
  {path: 'howitworks', component: HowitworksComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'my-profile', component: MyProfileComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, {useHash: true} )
  ],
  exports: [RouterModule]
})
export class AppRouteModule{

}