import {IUser, User} from "./user";
import {Sprint} from "./sprint";

export interface IProject {
  id: number;
  name: string;
  description: string;
  user: IUser;
  sprints: Sprint;
}

export class Project implements IProject {
  constructor (
    public id: number,
    public name: string = '',
    public description: string = '',
    public user: IUser,
    public sprints: Sprint) {
  }
}
