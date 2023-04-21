import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users!: User[];
  constructor(private userService:UserService){
    this.users=[];
  }
  ngOnInit(): void {
    this.userService.getUser().subscribe((data:User[])=>{
      this.users=data;
    })
  }

}
