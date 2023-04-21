import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  user!: Observable<User[]>;
  showForm:boolean=false;
  constructor(private es: UserService
) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.user= this.es.getUser();
  }

  deleteUser(id: number) {
    this.es.deleteUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  toggle(){
    this.showForm=!this.showForm;
  }
  editUser(user:User){
    console.log(user.id +""+ user.name);
    this.es.updateUser(user).subscribe(()=>
      {
        this.reloadData();
      }
    );
  }
}
