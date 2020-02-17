export interface IUser {
  firstName: string;
  lastName: string;
  email: string;
    invalid: string;
  password: string;
}

export class User implements IUser {


  constructor (
    public firstName: string = '',
    public lastName: string = '',
    public email: string = '',
    public password: string = '') {
  }

  invalid: string;


}
