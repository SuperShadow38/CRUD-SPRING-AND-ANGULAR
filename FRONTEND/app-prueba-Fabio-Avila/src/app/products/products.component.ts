import { Component, OnInit } from '@angular/core';
import { Evento } from './../evento.model';
import { ProductsService } from './../core/services/products/products.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit  {
  eventos: Evento[] = []; // Cambiado a 'eventos' en lugar de 'evento'

  constructor(
    private productsService: ProductsService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.fetchProducts();
  }

  fetchProducts() {
    this.productsService.getAllEvents().subscribe(eventos => { // Cambiado 'evento' a 'eventos'
      this.eventos = eventos;

      
    });
  }

  deleteProduct(id: string) {
    this.productsService.deleteEvent(id).subscribe(rta => {
      console.log(rta);
    });
  }

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();  
  }

  isAdmin(): boolean {
    return this.authService.hasRole('ROLE_ADMIN');
  }
}
