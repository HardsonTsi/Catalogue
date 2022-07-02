import {Component, Injectable, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ContactsService} from "../contacts.service";

@Injectable()
@Component({
  selector: 'contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {

  contacts: any;
  prenoms: string = '';


  constructor(private service: ContactsService, private router: Router) {
  }

  getContacts() {
    this.service.getContacts()
      .subscribe(datas => {
        this.contacts = datas;
      }, error => {
        console.log(error)
      })
  }

  doSearch() {
    this.service.searchContacts(this.prenoms)
      .subscribe(results => {
        console.log(this.prenoms)
        this.contacts = results;
        console.table(this.contacts)
      }, error => {
        console.log(error)
      })
  }

  ngOnInit() {
    this.getContacts();
  }

  selectContact(contact: any) {
    let link = ['contacts/', contact.id];
    this.router.navigate(link);
  }
}
