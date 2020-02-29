import {IUser, User} from "./user";
import {State} from "./state";

export class Task {
  constructor (
    public name: string = '',
    public description: string = '',
    public state: State) {
  }
}
