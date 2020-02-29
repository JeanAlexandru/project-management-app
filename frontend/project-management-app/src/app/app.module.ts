import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {IntroComponent} from "./intro/intro.component";
import {FeaturesModule} from "./features/features.module";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {ReactiveFormsModule} from "@angular/forms";
import {OktaAuthModule, OktaCallbackComponent} from "@okta/okta-angular";
import { AuthComponent } from './auth/auth.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AuthInterceptor} from "./auth.interceptor";
import { DragListComponent } from './drag-list/drag-list.component';

const config = {
  issuer: 'https://dev-222266.okta.com/oauth2/default',
  redirectUri: 'http://localhost:4200/implicit/callback',
  clientId: '0oa2h3419HCWJmHvB4x6',
  pkce: true
};

@NgModule({
  declarations: [
    IntroComponent,
    AppComponent,
    AuthComponent,
    DragListComponent
  ],
  imports: [
    OktaAuthModule.initAuth(config),
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FeaturesModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
    MatToolbarModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
