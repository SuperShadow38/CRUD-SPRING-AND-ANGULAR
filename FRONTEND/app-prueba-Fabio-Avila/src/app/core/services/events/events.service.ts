import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Evento } from '../../../evento.model'; // Asegúrate de importar correctamente el modelo Evento

@Injectable({
  providedIn: 'root'
})
export class EventsService {
  private apiUrl = 'http://localhost:8010'; // Cambia la URL base según tu API

  constructor(private http: HttpClient) {}

  getEvents(): Observable<Evento[]> {
    return this.http.get<Evento[]>(`${this.apiUrl}/evento`);
  }

  getEvent(id: number): Observable<Evento> {
    return this.http.get<Evento>(`${this.apiUrl}/evento/${id}`);
  }

  createEvent(evento: Evento): Observable<Evento> {
    return this.http.post<Evento>(`${this.apiUrl}/evento`, evento);
  }

  updateEvent(id: number, evento: Evento): Observable<Evento> {
    return this.http.put<Evento>(`${this.apiUrl}/evento/${id}`, evento);
  }

  deleteEvent(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/evento/${id}`);
  }
}
