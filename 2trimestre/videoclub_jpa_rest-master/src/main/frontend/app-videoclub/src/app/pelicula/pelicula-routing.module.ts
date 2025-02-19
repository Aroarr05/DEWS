import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {IndexComponent} from "../pelicula/index/index.component"
import {CreateComponent} from "../pelicula/create/create.component";
import {EditComponent} from "../pelicula/edit/edit.component";

const routes: Routes = [
  { path: 'pelicula', redirectTo: 'pelicula/index', pathMatch: 'full'},
  { path: 'pelicula/index', component: IndexComponent },
  { path: 'pelicula/create', component: CreateComponent },
  { path: 'pelicula/edit/:idPelicula', component: EditComponent }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PeliculaRoutingModule { }
