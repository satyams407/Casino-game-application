import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {RegisterationComponent} from './registeration/registeration.component';
import {AllusersComponent} from './allusers/allusers.component';
import {WelcomeComponent} from './welcome/welcome.component';
import {UserService} from './allusers/user.service';
import {HttpClientModule} from "@angular/common/http";
import {HttpModule} from "@angular/http";
import { FormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { FilterByNamePipe } from './Shared/filter-by-name.pipe';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RegisterationComponent,
    AllusersComponent,
    WelcomeComponent,
    FilterByNamePipe
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    HttpModule,
    BrowserAnimationsModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'register', component: RegisterationComponent},
      {path: 'welcome', component: WelcomeComponent},
      {path: 'users', component: AllusersComponent},
      {path: '', redirectTo: 'welcome', pathMatch: 'full'},
      {path: '**', redirectTo: 'welcome', pathMatch: 'full'}
    ])
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
