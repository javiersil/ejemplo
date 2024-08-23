import { Component } from '@angular/core';
import { AlumnosService } from '../../services/alumnos.service';
import { CommonModule } from '@angular/common';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { AlumnoFormularioComponent } from '../alumno-formulario/alumno-formulario.component';

@Component({
  selector: 'app-alumnos',
  standalone: true,
  imports: [CommonModule, NgbPaginationModule, AlumnoFormularioComponent],
  templateUrl: './alumnos.component.html',
  styleUrl: './alumnos.component.scss'
})
export class AlumnosComponent {
  alumnos: any[];
  page: number;
  pageSize: number;
  cantidad: number;
  formulario: boolean;

  public constructor(private alumnosService: AlumnosService) {
    this.page = 0;
    this.pageSize = 2;
    this.cantidad = 0;
    this.alumnos = [];
    this.formulario = false;
  }

  public paginar(pagina: number) {
    this.obtenerAlumnos(pagina - 1);
  }

  public nuevoAlumno() {
    this.formulario =  true;
  }

  private obtenerAlumnos(pagina: number) {
    if (pagina >= 0) {
      this.alumnosService.obtener(pagina, this.pageSize).subscribe(
        (respuesta: any) => {
          this.alumnos =  respuesta.content;
          this.page = respuesta.number + 1;
          this.cantidad = respuesta.totalElements;
        }
      );
    }
    
  }
}
