import { Injectable } from '@angular/core';
import { RoleModel } from './model/role.model';

@Injectable()
export class UtilService {

  getRoleNamesList(rolesModelArray: RoleModel[]){
    let roleList: Array<string> = [];
    for (var i = 0; i < rolesModelArray.length; i++) {
      roleList[i] = rolesModelArray[i].roleName ;
    }
    return roleList;
  }



}
