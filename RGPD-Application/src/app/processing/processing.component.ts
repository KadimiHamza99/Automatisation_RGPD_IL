import {Component, Input} from '@angular/core';
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {Processing} from "../core/Models/processing-model";

@Component({
  selector: 'app-processing',
  templateUrl: './processing.component.html',
  styleUrls: ['./processing.component.scss']
})
export class ProcessingComponent {
  @Input() processing!: Processing;

  constructor(private router: Router) { }

  onSubmit() {
    this.router.navigateByUrl('/contract');
  }
  onView(){
    this.router.navigateByUrl(`processing/${this.processing.id}`);
  }

  onAgree(){
  console.log(!this.processing.isChecked);
  }
}
