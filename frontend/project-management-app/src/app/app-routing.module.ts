import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {IntroComponent} from "./intro/intro.component";
import {UserComponent} from "./features/user/user.component";
import {OktaCallbackComponent} from "@okta/okta-angular";
import {DragListComponent} from "./drag-list/drag-list.component";


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
  },
  {
    path: 'dashboard',
    component: DragListComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
