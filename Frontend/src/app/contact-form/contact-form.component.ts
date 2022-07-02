import {Component, Input, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ContactsService} from "../contacts.service";

@Component({
  selector: 'contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  @Input() contact: any; // propriété d'entrée du composant
  linkVerification: string = this.route.snapshot.url[0].path;

  constructor(
    private service: ContactsService,
    private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
  }

  // La méthode appelée lorsque le formulaire est soumis.
  onSubmit(form: NgForm): void {
    if (this.linkVerification === 'add') {
      console.log(this.linkVerification);

      this.service.addContact(this.contact)
        .subscribe(() => {
          console.log("Contact ajouté", this.contact)
          this.goBack();
        }, error => {
          console.log(error)
        })
    } else {
      this.service.editContact(this.contact)
        .subscribe(() => {
          console.log("Contact modifié !")
          this.goDetail();
        }, error => {
          console.log(error)
        });
    }
  }

  goDetail(): void {
    let link = ['contacts', this.contact.id];
    this.router.navigate(link);
  }

  goBack() {
    let link = ['contacts'];
    this.router.navigate(link);
  }
}
