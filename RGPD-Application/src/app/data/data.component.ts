import {Component, Input} from '@angular/core';
import {Processing} from "../core/Models/processing-model";
import {Data} from "../core/Models/data-model";
import {ProcessingService} from "../core/services/processing-service";
import {Router} from "@angular/router";
import {DataService} from "../core/services/data-service";

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.scss']
})
export class DataComponent {
   data!: Data[];
  headers = ['Attribute name', 'Data conservation','Data source', 'IsPersonal', 'IsPortable','Action'];
  constructor(private dataService: DataService){}
  ngOnInit(): void {
    this.data = this.dataService.getAllData();

  }
}

