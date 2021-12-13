import { Component } from "@angular/core";
import { ShoppingItem } from "../models/shopping-item.model";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent {

    public name: string;
    public lastName: string;
    public address: string;
    public isDisabled: boolean;
    public secretMessageBackgroundColor: string;
    public shoppingList: Array<string>;
    public newItem: string;
    public itemIsRegistered: boolean;
    public shoppingListObject: Array<ShoppingItem>
    public shoppingItemObject: string;
    public quantity: number;

    constructor() {
        this.name = 'Pepe';
        this.lastName = 'García';
        this.address = "";
        this.isDisabled = false;
        this.secretMessageBackgroundColor = "darkorchid";
        this.shoppingList = ['milk', 'eggs', 'cheese', 'cookies'];
        this.newItem = "";
        this.itemIsRegistered = false;
        this.shoppingListObject = [new ShoppingItem('car', 2), new ShoppingItem('bus', 4)];
        this.shoppingItemObject = "";
        this.quantity = 0;
    }

    sayHello(): void {
        alert(`Hello ${this.name} ${this.lastName} , you live in ${this.address}`);
    }

    changeName(event: Event): void {
        console.log(event);
        const currentInput = event.target as HTMLInputElement;
        this.lastName = currentInput.value;
    }

    isBoss(): boolean {

        return this.lastName === "boss";
    }

    changeColor(): void {
        this.secretMessageBackgroundColor = "black";
    }

    hiddenMessage(): void {
        this.lastName = "intruso";
    }

    addShoppingItem(): void {
        this.itemIsRegistered = false;
        let registerPreviously = false;
        if (this.newItem !== "") {
            for (let item of this.shoppingList) {
                if (item === this.newItem) {
                    registerPreviously = true;
                }
            }
            if (!registerPreviously) {
                this.shoppingList.push(this.newItem);
                this.newItem = "";
            } else {
                this.newItem = "";
                this.itemIsRegistered = true;
            }

        }
    }

    isShoppingButtonDisabled(): boolean {
        return this.newItem.length === 0;
    }

    addShoppingItemObject(): void {
        if ((this.quantity !== 0) && (this.shoppingItemObject !== "")) {
            this.shoppingListObject.push(new ShoppingItem(this.shoppingItemObject, this.quantity));
            this.shoppingItemObject = "";
            this.quantity = 0;
        }
    }

    isShoppingObjectButtonDisabled(): boolean {
        if ((this.quantity === 0) || (this.shoppingItemObject === "")) {
            return true;
        } else {
            return false;
        }
    }

}