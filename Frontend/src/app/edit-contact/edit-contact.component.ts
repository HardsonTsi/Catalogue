import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ContactsService} from "../contacts.service";

@Component({
  selector: 'edit-contact',
  templateUrl: 'edit-contact.component.html'
})
export class EditContactComponent implements OnInit {

  contact: any;

  constructor(private route: ActivatedRoute, private router: Router, private service: ContactsService) {
  }

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    this.service.selectContact(id)
      .subscribe(contact => this.contact = contact)
  }

}
