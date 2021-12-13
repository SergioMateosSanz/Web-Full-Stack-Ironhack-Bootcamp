export class Sneaker {

    constructor(private _modelName: string, private _price: number, private _specialEdition: boolean, private _author: string,
        private _creationDate: Date, private _artistCollaborator: string) { }

        public get artistCollaborator(): string {
            return this._artistCollaborator;
        }
        public set artistCollaborator(value: string) {
            this._artistCollaborator = value;
        }
        public get creationDate(): Date {
            return this._creationDate;
        }
        public set creationDate(value: Date) {
            this._creationDate = value;
        }
        public get author(): string {
            return this._author;
        }
        public set author(value: string) {
            this._author = value;
        }
        public get specialEdition(): boolean {
            return this._specialEdition;
        }
        public set specialEdition(value: boolean) {
            this._specialEdition = value;
        }
        public get price(): number {
            return this._price;
        }
        public set price(value: number) {
            this._price = value;
        }
        public get modelName(): string {
            return this._modelName;
        }
        public set modelName(value: string) {
            this._modelName = value;
        }
}