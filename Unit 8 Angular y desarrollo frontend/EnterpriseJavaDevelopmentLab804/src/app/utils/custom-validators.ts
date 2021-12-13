import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";

export class CustomValidators {

    static isSpecialEditionAndArtistCollaboratorMustBeInformed(control: AbstractControl): ValidationErrors | null {

        const specialEditionInput: string = control.get('specialEdition')?.value;
        const artistCollaboratorInput: string = control.get('artistCollaborator')?.value;
        
        if ((specialEditionInput == 'true') && (artistCollaboratorInput == '')) {
            return {
                isSpecialEditionAndArtistCollaboratorMustBeInformed: true
            };
        }
        return null;
    }

}