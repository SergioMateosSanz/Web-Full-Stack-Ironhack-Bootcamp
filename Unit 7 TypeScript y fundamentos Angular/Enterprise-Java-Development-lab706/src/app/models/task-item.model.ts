export class TaskItem {

  constructor(private _description: string, private _backgroundColor: string) { 

  }

  public get description(): string {
    return this._description;
  }
  public set description(value: string) {
    this._description = value;
  }

  public get backgroundColor(): string {
    return this._backgroundColor;
  }
  public set backgroundColor(value: string) {
    this._backgroundColor = value;
  }

}
