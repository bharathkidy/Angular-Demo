import { Component, OnInit } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  user!: User;

  ngOnInit() {

  }
  
  updateUserInfo(user: User) {
    this.user = user;
  }
}
