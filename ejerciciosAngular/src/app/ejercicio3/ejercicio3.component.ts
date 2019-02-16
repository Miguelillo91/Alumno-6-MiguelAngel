import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio3',
  templateUrl: './ejercicio3.component.html',
  styleUrls: ['./ejercicio3.component.css']
})
export class Ejercicio3Component implements OnInit {

  valor: number;
  valor1: number;
  valor2: number;

  constructor() { }

  ngOnInit() {
    this.valor = Math.trunc(Math.random() * 6) + 1;
    this.valor1 = Math.trunc(Math.random() * 6) + 1;
    this.valor2 = Math.trunc(Math.random() * 6) + 1;
  }

}
