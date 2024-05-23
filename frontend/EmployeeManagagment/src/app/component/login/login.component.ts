import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user/user';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../service/user/user.service';
import { HttpClientModule } from '@angular/common/http';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,HttpClientModule,RouterOutlet],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit{

  userObj: User = new User();
  message!: string;
  progress: boolean = false;

  constructor(private UserService: UserService, private router: Router){
    
  }


  ngOnInit(): void {
    //this.message = '';
    this.userObj = new User();
    this.progress = false;
  }



  onLogin() {
    if (!this.userObj.username) {
        this.message = "Username required!";
        return;
    }

    if (!this.userObj.password) {
        this.message = "Password required!";
        return;
    }
    this.progress = true;
    this.UserService.login(this.userObj).subscribe({
        next: (res: any) => {
            console.log(res.message);
            this.message = res.message;
            this.router.navigateByUrl('/dashboard');
            this.progress = false;
        },
        error: (err: any) => {
          this.progress = false;
            console.log(err);
            switch (err.error.httpStatus) {
                case "UNAUTHORIZED":
                    this.message = 'Incorrect Password!';
                    break;
                case "NOT_FOUND":
                    this.message = `User doesn't exist!`;
                    break;
                default:
                    this.message = 'Connection Error...!';
            }
        }
    });
  }

     

}
