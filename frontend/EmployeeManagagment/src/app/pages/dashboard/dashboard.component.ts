import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Employee } from '../../model/employee/employee';
import { EmployeeService } from '../../service/employee/employee.service';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
    selector: 'app-dashboard',
    standalone: true,
    templateUrl: './dashboard.component.html',
    styleUrl: './dashboard.component.scss',
    imports: [HeaderComponent, FormsModule, HttpClientModule, CommonModule, RouterOutlet]
})
export class DashboardComponent implements OnInit{
    empArr: Employee[] = [];

    constructor(private empService: EmployeeService){

    }

   ngOnInit(): void {
       this.empArr = [];
       this.fetchAllEmployees();
   }

   fetchAllEmployees(){
    this.empService.getAllEmployee().subscribe(
        {
            next:(res:any)=>{
                this.empArr = res.data;
            },
            error:(err:any)=>{
                console.log(err);
            }
        })
   }
}
