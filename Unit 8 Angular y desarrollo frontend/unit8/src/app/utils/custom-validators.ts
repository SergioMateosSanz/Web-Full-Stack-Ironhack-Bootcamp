import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";

export class CustomValidators {

    static noPepito(control: AbstractControl): ValidationErrors | null {

        const value = control.value;
        if (value === 'Pepito') {
            return {
                noPepito: true
            };
        }
        return null;
    }

    static noContainDigits(control: AbstractControl): ValidationErrors | null {

        const regex = /[0-9]/;
        if (regex.test(control.value)) {
            return {
                noContainDigits: true
            }
        }
        return null;
    }

    static validAge(min: number, max: number): ValidatorFn {

        return (control: AbstractControl): ValidationErrors | null => {
            const value = control.value;
            if ((value < min) || (value > max)) {
                return {
                    validAge: true
                };
            }
            return null;
        }
    }

    static passwordsEquals(control: AbstractControl): ValidationErrors | null {

        const password: string = control.get('password')?.value;
        const passwordConfirmation: string = control.get('passwordConfirmation')?.value;
//        type CustomType = ValidationErrors | null;
//        const result: CustomType = password !== passwordConfirmation ? {passwordsEquals: true} : null;
//        return result;
        return password !== passwordConfirmation ? {passwordsEquals: true} : null;
    }
}