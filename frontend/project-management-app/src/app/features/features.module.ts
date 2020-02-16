import {NgModule} from "@angular/core";
import {UserComponent} from "./user/user.component";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    UserComponent
  ],
  imports: [
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [
    UserComponent
  ]
})
export class FeaturesModule {

}
