import {Component, OnInit} from '@angular/core';
import {UserService} from "./user.service";
import {IUser} from "./IUser";

@Component({
  selector: 'app-allusers',
  templateUrl: './allusers.component.html',
  styleUrls: ['./allusers.component.css']
})
export class AllusersComponent implements OnInit {

  users: IUser[];
  errorMessage: string;
  userId:number;
  user;
  rechargeValue: number=0;

  constructor(private _userService: UserService) {
  }

  ngOnInit() {
    this._userService.getUsers().subscribe(users => {
        this.users = users;
      },
      error => this.errorMessage = <any>error); //typecasting to any type of error
  }

  setUserId(id) {
    console.log('id is ',id);
    this.userId=id;
  }

  recharge(value) {
    this._userService.getUser(this.userId).subscribe(user => {
      this.user = user;
      this.user.accountBalance+= value;
      this._userService.updateUser(this.user, this.userId).subscribe(data=> location.reload());
    });
  }

}
