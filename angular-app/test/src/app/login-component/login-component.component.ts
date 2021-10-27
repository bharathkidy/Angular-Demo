import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { LoginServiceService } from '../login-service.service';
import { User } from '../user';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  @Output() actionTypeEventEmitter = new EventEmitter<User>();
  isLoggedIn: boolean = false;
  error: boolean =false;
  password: string = '';
  userName: string = ''
  constructor(private loginService: LoginServiceService) { }

  ngOnInit(): void {
  }

  async validateLogin() {
    let loginPromise = this.loginService.validateLogin(this.userName, this.password);
    await loginPromise.then(res => {
      this.isLoggedIn = true;
      this.error = false;
      this.actionTypeEventEmitter.emit(res);
    }).catch(err => {
      this.error = true;
      console.log(err);
    })
  }

}
