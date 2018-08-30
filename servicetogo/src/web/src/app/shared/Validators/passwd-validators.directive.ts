import {AbstractControl, ValidatorFn, FormGroup, ValidationErrors} from '@angular/forms';
/*
export class PasswordValidation {
    static MatchPassword(AC: AbstractControl)
    {
       let password = AC.get('loginPassword').value; // to get value in input tag
       let confirmPassword = AC.get('retypePassword').value; // to get value in input tag
        if(password != confirmPassword) {
            console.log('false');
            AC.get('retypePassword').setErrors( {MatchPassword: true} )
        } else {
            console.log('true');
            return null
        }
    }
*/

export const PasswordValidator: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
  const passwd = control.get('loginPassword');
  const retypePasswd = control.get('retypePassword');

  return passwd && retypePasswd && passwd.value === retypePasswd.value ? null : { 'matchPasswordError': true };
};

