import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ContactsService} from "../contacts.service";

@Component({
  selector: 'about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  contact: any;

  constructor(private route: ActivatedRoute, private router: Router, private service: ContactsService) {
  }

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    this.service.selectContact(id)
      .subscribe(datas => {
        this.contact = datas;
      }, error => console.log(error))
  }

  deleteContact() {
    this.service.deleteContact(this.contact.id)
      .subscribe(() => {
          console.log("Contact supprimé");
          this.goBack();
        }, error => {
          console.log(error);
        }
      )


  }

  goBack(): void {
    let link = ['/contacts'];
    this.router.navigate(link);
  }

  goEdit() {
    let link = ['/contacts/edit/', this.contact.id];
    this.router.navigate(link);
  }

}
