import { AbstractControl, ValidationErrors } from "@angular/forms";


export class Validadores {
    public static numeroControl(control: AbstractControl): ValidationErrors | null {
        if (control.value !== null) {
            let valor: string = control.value;
            if (valor.length > 3 && valor.charAt(4) === 'A') {
                return null;
            }
        }
        return { formato: "No cumple con el formato" };
    }

}
