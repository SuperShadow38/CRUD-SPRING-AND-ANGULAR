import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { EventsService } from './../core/services/events/events.service'; // Asegúrate de importar correctamente el servicio de eventos
import { Evento } from './../evento.model'; // Asegúrate de importar correctamente el modelo de evento

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent  {
  // events: Evento[] = [];
  // event: Evento;

  // constructor(
  //   private route: ActivatedRoute,
  //   private eventsService: EventsService
  // ) { }

  // ngOnInit() {
  //   this.route.params.subscribe((params: Params) => {
  //     const id = params['id'];
  //     this.fetchEvent(id);
  //   });

  //   this.fetchAllEvents();
  // }

  // fetchEvent(id: string) {
  //   this.eventsService.getEvent(id).subscribe(event => {
  //     this.event = event;
  //   });
  // }

  // fetchAllEvents() {
  //   this.eventsService.getAllEvents().subscribe(events => {
  //     this.events = events;
  //   });
  // }

  // createEvent() {
  //   const newEvent: Evento = {
  //     id: 14,
  //     nombre: "Nuevo Evento",
  //     precio: 100
  //   };

  //   this.eventsService.createEvent(newEvent).subscribe((event) => {
  //     const newEventData = event as Evento;
  //     this.events.push(newEventData);
  //     this.fetchAllEvents();
  //     console.log(newEventData);
  //   });
  // }

  // updateEvent() {
  //   const updateEvent: Partial<Evento> = {
  //     id: 9,
  //     nombre: "Evento Actualizado",
  //     precio: 150
  //   };
  //   this.eventsService.updateEvent('1', updateEvent).subscribe(event => {
  //     console.log(event);
  //   });
  // }

  // deleteEvent(id: number) {
  //   this.eventsService.deleteEvent(id).subscribe(rta => {
  //     console.log(rta);
  //     // Actualizar la lista de eventos después de eliminar uno
  //     this.fetchAllEvents();
  //   });
  // }
}
