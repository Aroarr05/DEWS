import {NgModule} from "@angular/core";
import {IndexComponent} from "../pelicula/index/index.component";
import {CreateComponent} from "../pelicula/create/create.component";
import {EditComponent} from "../pelicula/edit/edit.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {PeliculaRoutingModule} from "../pelicula/pelicula-routing.module";

@NgModule({
  declarations: [
    IndexComponent,
    CreateComponent,
    EditComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    PeliculaRoutingModule
  ]
})
export class PeliculaModule { }
