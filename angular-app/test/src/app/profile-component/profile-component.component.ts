import { Component, Input, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-profile-component',
  templateUrl: './profile-component.component.html',
  styleUrls: ['./profile-component.component.css']
})
export class ProfileComponentComponent implements OnInit {

  @Input()
  user!: User;
  constructor() { }

  ngOnInit(): void {
  }

}
