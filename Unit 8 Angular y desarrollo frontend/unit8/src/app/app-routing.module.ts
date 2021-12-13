import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnguMaterialComponent } from './components/angu-material/angu-material.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { ReactiveDrivenFormComponent } from './components/reactive-driven-form/reactive-driven-form.component';
import { TemplateDrivenFormComponent } from './components/template-driven-form/template-driven-form.component';

const routes: Routes = [
  {
    path: '',
    component: TemplateDrivenFormComponent,
  },
  {
    path: 'reactive',
    component: ReactiveDrivenFormComponent
  },
  {
    path: 'angular-material',
    component: AnguMaterialComponent
  },
  {
    path: '**',
    component: PagenotfoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
