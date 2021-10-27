import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../login-service.service';
import { User } from '../user';

@Component({
  selector: 'app-admin-component',
  templateUrl: './admin-component.component.html',
  styleUrls: ['./admin-component.component.css']
})
export class AdminComponentComponent implements OnInit {

  error: string = '';
  constructor(private loginService: LoginServiceService) { }

  users: User[] | undefined;

  ngOnInit(): void {
    this.loadUsers();
  }

  async loadUsers() {
    let promise = this.loginService.getUsers();
    await promise.then(res => {
      this.users = res;
      this.error = '';
    }).catch(err => {
      console.log(err);
      this.error = 'Error while loaing user Details';
    })
  }
}
