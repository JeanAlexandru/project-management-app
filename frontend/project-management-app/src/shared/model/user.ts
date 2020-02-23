export interface IUser {
  userName: string;
  firstName: string;
  lastName: string;
  email: string;
    /*invalid: string;*/
  role: string;
}

export class User implements IUser {


  constructor (
    public userName: string = '',
    public firstName: string = '',
    public lastName: string = '',
    public role: string = '',
    public email: string = '') {
  }

  invalid: string;


}
