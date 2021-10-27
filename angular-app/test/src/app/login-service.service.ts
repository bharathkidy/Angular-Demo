import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { User } from './user';
import { ThrowStmt } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http: HttpClient) { }

  validateLogin(userName: string, password: string) : Promise<User> {
    return this.http.post<User>(environment.uri+"/login",{
      userName: userName,
      password: password
    }).toPromise();
  }

  getUsers(): Promise<User[]> {
    return this.http.get<User[]>(environment.uri+"/users").toPromise();
  }
}
