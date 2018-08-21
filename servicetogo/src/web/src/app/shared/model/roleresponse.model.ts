import { RoleModel } from "./role.model";

export class RoleResponseModel{
  success: boolean;
  respCode: string;
  respMessage: string;
  data: RoleModel[];
}
