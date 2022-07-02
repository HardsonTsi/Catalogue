import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {NgModule} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule, Routes} from "@angular/router";
import {AboutComponent} from "./about/about.component";
import {AddContactComponent} from './add-contact/add-contact.component';
import {AppComponent} from './app.component';
import {ContactFormComponent} from "./contact-form/contact-form.component";
import {ContactsService} from "./contacts.service";
import {ContactsComponent} from './contacts/contacts.component';
import {EditContactComponent} from "./edit-contact/edit-contact.component";
import {LoaderComponent} from "./loader/loader.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";

const appRoutes: Routes = [
  {path: 'contacts', component: ContactsComponent},
  {path: 'contacts/:id', component: AboutComponent},
  {path: 'contacts/edit/:id', component: EditContactComponent},
  {path: 'add', component: AddContactComponent},
  {path: '', component: ContactsComponent},
  {path: '**', component: PageNotFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoaderComponent,
    AboutComponent,
    ContactsComponent,
    AddContactComponent,
    EditContactComponent,
    ContactFormComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule, CommonModule, HttpClientModule, FormsModule, RouterModule.forRoot(appRoutes)
  ],
  providers: [ContactsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
