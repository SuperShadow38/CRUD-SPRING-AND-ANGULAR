import { Component, Input } from '@angular/core';
import { Evento } from '../evento.model';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent {
  constructor(private authService: AuthService) {
    
  }
  @Input() eventos: Evento[]; // Cambiado a 'eventos' en lugar de 'evento'

  // ... Otras propiedades y métodos ...

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();  
  }
}
export { Evento };
