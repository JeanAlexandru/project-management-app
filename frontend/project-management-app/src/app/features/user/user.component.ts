import { Component, OnInit } from '@angular/core';
import {IUser, User} from "../../../shared/model/user";
import {UserService} from "./user.service";
import {FormControl, Validators} from '@angular/forms';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: IUser;
  email = new FormControl('', [Validators.required, Validators.email]);
  hide: boolean;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.user = new User();
  }

  saveUser() {
    console.log('Save user ' + JSON.stringify(this.user));
    this.userService
      .saveUser(this.user)
      .subscribe(
        () => console.log('OK'),
        () => console.log('Could not save user')
  );
  }

  getErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
      this.email.hasError('email') ? 'Not a valid email' : '';
  }
}
