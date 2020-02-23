import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {IntroComponent} from "./intro/intro.component";
import {UserComponent} from "./features/user/user.component";
import {OktaCallbackComponent} from "@okta/okta-angular";


const routes: Routes = [
  {
    path: 'intro',
    component: IntroComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'implicit/callback',
    component: OktaCallbackComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
