// src/app/components/funcionario-list/funcionario-list.component.ts
import { Component, OnInit } from '@angular/core';
import { Funcionario } from '../../models/funcionario.model';
import { FuncionarioService } from '../../services/funcionario.service';
 
@Component({
 selector: 'app-funcionario-list',
templateUrl: './funcionario-list.component.html',
 styleUrls: ['./funcionario-list.component.css']
})
export class FuncionarioListComponent implements OnInit {
 funcionarios: Funcionario[] = [];
 
constructor(private funcionarioService: FuncionarioService) {}
 
 ngOnInit(): void {
  this.funcionarios = this.funcionarioService.getFuncionarios();
 }
 
deletarFuncionario(id: number): void {
   this.funcionarioService.deletarFuncionario(id);
  this.funcionarios = this.funcionarioService.getFuncionarios(); // Atualiza a lista após exclusão
 }
}