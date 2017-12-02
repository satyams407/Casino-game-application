import { Pipe, PipeTransform } from '@angular/core';
import {IUser} from "../allusers/IUser";

@Pipe({
  name: 'filter'
})
export class FilterByNamePipe implements PipeTransform {

  transform(items: IUser[], searchText: string,searchContact: string,searchEmail: string): any[] {
    if (items && items.length){
      return items.filter(item =>{
        if (searchText && item.name.toLowerCase().indexOf(searchText.toLowerCase()) === -1){
          return false;
        }
        if (searchEmail && item.email.toLowerCase().indexOf(searchEmail.toLowerCase()) === -1){
          return false;
        }
        if (searchContact && item.contactNumber.toString().toLocaleLowerCase().indexOf(searchContact.toLowerCase()) === -1){
          return false;
        }
        return true;
      })
    }
    else{
      return items;
    }
  }
}
