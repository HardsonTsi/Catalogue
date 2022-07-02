import {Component, OnInit} from '@angular/core';
import {Contact} from "../contact";

@Component({
  selector: 'add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit {

  contact: Contact = null;

  constructor() {
  }

  ngOnInit(): void {
    this.contact = new Contact();
  }


}
