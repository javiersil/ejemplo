import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlumnosService {

  constructor(private httpClient: HttpClient) { }

  obtener(pagina: number, cantidad: number): Observable<any> {
    return this.httpClient.get('http://localhost:9090/alumnos?cantidad=' + cantidad + '&pagina=' + pagina);
  }

  guardar(alumno: any): Observable<any> {
    return this.httpClient.post('http://localhost:9090/alumnos', alumno);
  }
}
