import { Component } from '@angular/core';
import { AlumnosService } from '../../services/alumnos.service';
import { CommonModule } from '@angular/common';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-alumnos',
  standalone: true,
  imports: [CommonModule, NgbPaginationModule],
  templateUrl: './alumnos.component.html',
  styleUrl: './alumnos.component.scss'
})
export class AlumnosComponent {
  alumnos: any[];
  page: number;
  pageSize: number;
  cantidad: number;
  public constructor(private alumnosService: AlumnosService) {
    this.page = 0;
    this.pageSize = 2;
    this.cantidad = 0;
    this.alumnos = [];
    
  }

  paginar(pagina: number) {
    this.obtenerAlumnos(pagina - 1);
  }


  obtenerAlumnos(pagina: number) {
    if (pagina >= 0) {
      this.alumnosService.obtenerAlumnos(pagina, this.pageSize).subscribe(
        (respuesta: any) => {
          this.alumnos =  respuesta.content;
          this.page = respuesta.page;
          this.cantidad = respuesta.totalElements;
        }
      );
    }
    
  }
}
