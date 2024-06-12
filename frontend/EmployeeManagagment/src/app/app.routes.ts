import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HeaderComponent } from './pages/header/header.component';
import { EmployeeDetailComponent } from './pages/employee-detail/employee-detail.component';

export const routes: Routes = [
    {
        path: '', redirectTo: 'login', pathMatch: 'full'
    },
    {
        path: 'login', component: LoginComponent
    },
    {
        path: '', component: HeaderComponent,
        children:[
            {
                path: 'dashboard',
                component: DashboardComponent
            },
            {
                path: 'employee-detail',
                component: EmployeeDetailComponent
            }
        ]
    }
];
