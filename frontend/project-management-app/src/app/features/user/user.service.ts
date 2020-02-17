import {IUser} from "../../../shared/model/user";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private static USERS_API = "../api/user";

  constructor(private httpClient: HttpClient) {
  }

  saveUser(user: IUser): Observable<IUser> {
    return this.httpClient.post<IUser>(UserService.USERS_API, user)
  }
}
