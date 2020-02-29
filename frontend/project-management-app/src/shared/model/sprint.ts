import {IUser, User} from "./user";
import { Task } from './task';

export class Sprint {
  constructor (
    public name: string = '',
    public description: string = '',
    public tasks: Task) {
  }
}
