import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {from, Observable} from "rxjs";
import {filter, map, mergeMap} from "rxjs/operators";
import {Injectable} from "@angular/core";
import {OktaAuthService} from "@okta/okta-angular";

@Injectable({providedIn: 'root'})
export class AuthInterceptor implements HttpInterceptor {

  constructor(private oktaAuthService: OktaAuthService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const isAuthenticatedPromise = this.oktaAuthService.isAuthenticated();

    return from(isAuthenticatedPromise).pipe(
      mergeMap(isAuthenticated => {
        if (isAuthenticated) {
          const accessTokenPromise = this.oktaAuthService.getAccessToken();
          return from(accessTokenPromise).pipe(
            map(accessToken => this.addAuthorizationHeader(req, accessToken)),
            mergeMap(req => next.handle(req)))
        } else {
          return next.handle(req)
        }
      })
    );
  }
  private addAuthorizationHeader(req: HttpRequest<any>, accessToken: string) {
    return req.clone({
      setHeaders: {
        Authorization: `Bearer ${accessToken}`
      }
    });
  }
}
