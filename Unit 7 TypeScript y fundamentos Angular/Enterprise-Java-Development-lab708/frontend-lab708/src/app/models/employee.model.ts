export class Employee {

    constructor(private _id: number,
        private _name: string,
        private _phoneNumber: string,
        private _officeNumber: number,
        private _position: string,
        private _manager: string) { }

    public get manager(): string {
        return this._manager;
    }
    public set manager(value: string) {
        this._manager = value;
    }
    public get position(): string {
        return this._position;
    }
    public set position(value: string) {
        this._position = value;
    }
    public get officeNumber(): number {
        return this._officeNumber;
    }
    public set officeNumber(value: number) {
        this._officeNumber = value;
    }
    public get phoneNumber(): string {
        return this._phoneNumber;
    }
    public set phoneNumber(value: string) {
        this._phoneNumber = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
}