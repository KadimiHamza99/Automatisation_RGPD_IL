import {Component, Input} from '@angular/core';
import {Processing} from "../core/Models/processing-model";
import {ProcessingService} from "../core/services/processing-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-contract',
  templateUrl: './contract.component.html',
  styleUrls: ['./contract.component.scss']
})
export class ContractComponent {
  processings!: Processing[];
  constructor(private processingService: ProcessingService){}

  ngOnInit(): void {
    this.processings = this.processingService.getAllProcessings();

  }
}
