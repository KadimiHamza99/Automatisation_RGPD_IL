import {Injectable} from '@angular/core';
import {Processing} from "../Models/processing-model";

@Injectable({
  providedIn: 'root'
})
export class ProcessingService {
  processings: Processing[] = [
    {
      id: 0,
      name: 'Order management',
      age: 30,
      address: 'New York',
      isChecked: false,
      isObligatory: true,
      purpose: ['Proposal of new products', 'Management of deliveries'],
      isModifiable: false,
      isReadable: true,
      isDeleted: false,
      isCreatable: false
    },
    {
      id: 1,
      name: 'Profiling',
      age: 25,
      address: 'London',
      isChecked: false,
      isObligatory: false,
      purpose: ['Proposal of new products', 'Management of deliveries'],
      isModifiable: false,
      isReadable: true,
      isDeleted: false,
      isCreatable: false
    },
    {
      id: 2,
      name: 'Advertising Management',
      age: 35,
      address: 'Paris',
      isChecked: false,
      isObligatory: false,
      purpose: ['Proposal of new products', 'Management of deliveries'],
      isModifiable: false,
      isReadable: true,
      isDeleted: false,
      isCreatable: false
    }
  ];

  getAllProcessings(): Processing[] {
    return this.processings;
  }

  getProcessingById(processingId: number): Processing {
    const processing = this.processings.find(processing => processing.id === processingId);
    if (!processing) {
      throw new Error('Details not found!');
    } else {
      return processing;
    }
  }
}
