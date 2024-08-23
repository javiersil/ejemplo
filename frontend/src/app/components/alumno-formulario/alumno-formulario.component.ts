import { Component } from '@angular/core';
import {  FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AlumnosService } from '../../services/alumnos.service';
import {  NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { Validadores } from '../../Validadores';


@Component({
  selector: 'app-alumno-formulario',
  standalone: true,
  imports: [ReactiveFormsModule, NgbAlertModule, CommonModule],
  templateUrl: './alumno-formulario.component.html',
  styleUrl: './alumno-formulario.component.scss'
})
export class AlumnoFormularioComponent {

  alumnoFormulario: FormGroup;

	AlertClosed = false;
	message = '';



  public constructor(private alumnosService: AlumnosService) {

    let este_es_un_objeto = {id: 1};

    this.alumnoFormulario = new FormGroup({
      nombre: new FormControl(null, Validators.required ),
      apellidoPaterno: new FormControl(null, Validators.required,),
      apellidoMaterno: new FormControl(null,  Validators.required),
      curp: new FormControl(null, [
        Validators.required,
        Validators.minLength(16),
        Validators.maxLength(20)]),
      numeroControl: new FormControl(null, [Validators.required, Validadores.numeroControl])
    });
  }

 
  public guardar() {
    console.log(this.alumnoFormulario)

    if(this.alumnoFormulario.valid) {
      this.alumnosService.guardar(this.alumnoFormulario.value).subscribe(
        (respuesta) => console.log(respuesta),
        (error) =>  {
          const errores: any[] = error.error.errors;
          for (let index = 0; index < errores.length; index++) {
            this.alerta(errores[index].defaultMessage);          
          }
        }
      );
    } else {
      Object.keys(this.alumnoFormulario.controls).map(
        control =>  this.alumnoFormulario.controls[control].markAllAsTouched()
      );
    }    
  }


  private alerta(mensaje: string) {
    this.message = mensaje;
    this.AlertClosed = true;
  }
}
