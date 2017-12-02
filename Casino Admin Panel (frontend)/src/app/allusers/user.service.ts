import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http"
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import "rxjs/add/operator/map";
import "rxjs/add/operator/map";
import {IUser} from "./IUser";
import {Headers, Http} from "@angular/http";

const header = {header: new Headers({'Content-Type': 'application/json'})};

@Injectable()
export class UserService {
  private _userUrl = 'http://localhost:8080/users';

  constructor(private _httpClient: HttpClient, private _http: Http) {
  }

  getUsers(): Observable<IUser[]> {
    return this._httpClient.get<IUser[]>(this._userUrl).catch(this.handleError);
  }

  getUser(id: number): Observable<IUser> {
    return this.getUsers().map((user: IUser[]) => user.find(item => item.id === id)).catch(this.handleError);
  }

  postUser(data) {
    console.log('from service', data);
    return this._http.post(this._userUrl , data, header).do(data => console.log(data)).catch(this.handleError);
  }

  updateUser(data,id){
    console.log(data);
    return this._http.post(this._userUrl+  "/" + id ,data,header ).catch(this.handleError);
  }

  private handleError(err: HttpErrorResponse) {
    console.log(err.message);
    console.log("in handle error");
    return Observable.throw(err.message);
  }
}
