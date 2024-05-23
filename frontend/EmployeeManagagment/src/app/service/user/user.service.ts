import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../model/user/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiURL: string;
  /* createURL: string;
  updateURL: string;
  deleteURL: string; */

  constructor(private http: HttpClient) {

    this.apiURL = "http://localhost:8080/employee/api/vi/users/login ";
    

   }

   login(user: User):Observable<User>{
    return this.http.post<User>(this.apiURL, user);
   }

}
