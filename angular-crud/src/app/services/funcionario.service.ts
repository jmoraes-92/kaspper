//src/app/services/funcionario.service.ts
import { Injectable } from '@angular/core';
import { Funcionario } from '../models/funcionario.model';
 
@Injectable({
 providedIn: 'root'
})

export class FuncionarioService {
    private funcionarios: Funcionario[] = [
        {id: 1, nome: 'Daiane', funcao: 'Dev. Jr', 
         dataAdmissao: '12/05/2024', salario: 6890.98},
        {id: 2, nome: 'Juliano', funcao: 'Q&A', 
        dataAdmissao: '13/03/2024', salario: 16890.98}
    ];

    constructor() {}
 
getFuncionarios(): Funcionario[] {
   return this.funcionarios;
 }
 
addFuncionario(funcionario: Funcionario): void {
  this.funcionarios.push(funcionario);
 }
 
editarFuncionario(id: number, funcionario: Funcionario): void {
   const index = this.funcionarios.findIndex(f => f.id === id);
   if (index !== -1) {
     this.funcionarios[index] = funcionario;
   }
 }
 
 deletarFuncionario(id: number): void {
   const index = this.funcionarios.findIndex(f => f.id === id);
   if (index !== -1) {
     this.funcionarios.splice(index, 1);
   }
 }

}