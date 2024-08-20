import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlumnosService {

  constructor(private httpClient: HttpClient) { }

  obtenerAlumnos(pagina: number, cantidad: number): Observable<any> {
    return this.httpClient.get('http://localhost:9090/alumnos?cantidad=' + cantidad + '&pagina=' + pagina);
  }

}
