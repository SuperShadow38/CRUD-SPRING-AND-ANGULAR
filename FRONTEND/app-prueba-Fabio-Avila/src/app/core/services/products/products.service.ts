import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Evento } from './../../../evento.model'; // Asegúrate de importar correctamente el modelo Evento
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from  './../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductsService { // Cambia el nombre del servicio a EventsService
  
  constructor(
    private http: HttpClient
  ) {}

  getAllEvents() { // Cambia el nombre del método a getAllEvents
    const url = environment.url_api;
    return this.http.get<Evento[]>("http://localhost:8010/eventos"); // Cambia el tipo a Evento[]
  }

  getEvent(id: string): Observable<Evento> { // Cambia el nombre del método a getEvent y el tipo a Evento
    const url = `${environment.url_api}/${id}`;
    return this.http.get<Evento>(url).pipe(
      catchError(error => {
        console.error('Error al obtener el evento:', error);
        return throwError('Ocurrió un error al obtener el evento.');
      }),
    );
  }

  createEvent(evento: Evento) { // Cambia el nombre del método a createEvent
    return this.http.post(environment.url_api, evento);
  }

  updateEvent(id: string, changes: Partial<Evento>) { // Cambia el nombre del método a updateEvent y el tipo a Evento
    return this.http.put<Evento>(`${environment.url_api}/${id}`, changes);
  }

  deleteEvent(id: string) { // Cambia el nombre del método a deleteEvent
    return this.http.delete(`${environment.url_api}/${id}`);
  }
}
