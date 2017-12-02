import {Component, OnInit} from '@angular/core';
import {$} from "protractor";
import {IUser} from "../allusers/IUser";
import {UserService} from "../allusers/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registeration',
  templateUrl: './registeration.component.html',
  styleUrls: ['./registeration.component.css']
})
export class RegisterationComponent implements OnInit {

  user: IUser = {
    'name': null,
    'userId': null,
    'dateOfBirth': null,
    'contactNumber': null,
    'accountBalance': null,
    'email': null,
    'id':null
  };


  constructor(private _userService: UserService,private _router: Router) {
  }

  ngOnInit() {

  }

  register(data) {
    this._userService.postUser(data).subscribe(data=>location.reload());
    alert('user has been registered');
    this._router.navigate(['/users']);
  }
}
