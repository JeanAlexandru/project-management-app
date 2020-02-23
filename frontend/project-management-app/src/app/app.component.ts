import { Component } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';
import {UserService} from "./features/user/user.service";
import {IUser, User} from "../shared/model/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'project-management-app';
  isAuthenticated: boolean;

  constructor(public oktaAuth: OktaAuthService,
              private userService: UserService) {
    // Subscribe to authentication state changes
    this.oktaAuth.$authenticationState.subscribe(
      (isAuthenticated: boolean)  => {this.isAuthenticated = isAuthenticated;

        if (this.isAuthenticated) {
          this.oktaAuth.getUser().then(userInfo =>

            this.userService.findUserByUsername(userInfo.sub)
              .subscribe(
                user => console.log(user),
                errorResponse => {
                  if (errorResponse.status === 404) {
                    const user: IUser = new User(
                      userInfo.sub,
                      userInfo.firstName,
                      userInfo.lastName,
                      'DEVELOPER'
                    );

                    this.userService.saveUser(user)
                      .subscribe(
                        _ => console.log('Save user successfully'),
                        _ => console.log('Failed to save user')
                      );
                  }
                }
              )
          );


        }
      }
    );
  }

  async ngOnInit() {
    // Get the authentication state for immediate use
    this.isAuthenticated = await this.oktaAuth.isAuthenticated();


  }

  login() {
    this.oktaAuth.loginRedirect('/');
  }

  logout() {
    this.oktaAuth.logout('/');
  }
}
