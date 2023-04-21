import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit{
  user: User = new User();
  submitted = false;
  login!: FormGroup;
constructor(private es: UserService
    ) { }
ngOnInit() {
  }
newEmployee(): void {
    this.submitted = false;
    this.user = new User();
  }
save() {
    this.es.createUser(this.user)
      .subscribe(data => console.log(data), error => console.log(error));
    this.user= new User();
    
  }
onSubmit(loginform:any) {
    this.submitted = true;
    this.save();    
  }

  reset(){
    this.login.reset();
  }
}
