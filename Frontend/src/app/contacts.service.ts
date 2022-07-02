import {HttpClient} from "@angular/common/http";
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContactsService {

  url: string = 'http://localhost:8080/contacts/';

  constructor(private http: HttpClient) {
  }

  getContacts() {
    return this.http.get(this.url);
  }

  searchContacts(prenoms: string) {
    return this.http.get(this.url + 'search?prenoms=' + prenoms)
  }

  selectContact(id: number) {
    return this.http.get(this.url + id);
  }

  deleteContact(id: number) {
    return this.http.delete(this.url + 'delete/' + id)
  }

  addContact(contact: any) {
    return this.http.post(this.url + 'add', contact);
  }

  editContact(contact: any) {
    return this.http.put(this.url + 'update', contact);
  }


}
