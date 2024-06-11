import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../../model/employee/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  apiUrl: string = "";

  constructor(private http: HttpClient) {
    this.apiUrl = "http://localhost:8080/employee-system/api/v1/employee";
   }

  getAllEmployee():Observable<Employee>{
  return this.http.get<Employee>(this.apiUrl+'/all');
} 
}


