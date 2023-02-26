import { Component, OnInit } from '@angular/core';
import {Route, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {Processing} from "../core/Models/processing-model";
import {ProcessingService} from "../core/services/processing-service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-consent',
  templateUrl: './consent.component.html',
  styleUrls: ['./consent.component.scss']
})

export class ConsentComponent implements OnInit{
 processings!: Processing[];

  constructor(private processingService: ProcessingService, private router: Router){}
  ngOnInit(): void {
    this.processings = this.processingService.getAllProcessings();

  }
  onSubmitForm() {
    this.router.navigateByUrl(`contract`);
  }


}
