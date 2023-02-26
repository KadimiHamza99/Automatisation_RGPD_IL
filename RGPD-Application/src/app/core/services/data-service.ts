import {Injectable} from '@angular/core';
import {Data} from "../Models/data-model";
import {DatasourceEnum} from "../Enum/datasource-enum";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  allData: Data[] = [
    {
      dataID:0,
      dataConservation: 360 ,
      dataSource: DatasourceEnum.direct,
      isPersonal: true,
      isPortable:false,
      attributeName: 'First name',
    },
    {
      dataID:1,
      dataConservation: 360 ,
      dataSource: DatasourceEnum.direct,
      isPersonal: true,
      isPortable:false,
      attributeName: 'Last name',
    },
    {
      dataID:2,
      dataConservation: 360 ,
      dataSource: DatasourceEnum.direct,
      isPersonal: true,
      isPortable:false,
      attributeName: 'address',
    },
    {
      dataID:3,
      dataConservation: 360 ,
      dataSource: DatasourceEnum.produced,
      isPersonal: true,
      isPortable:false,
      attributeName: 'Age',
    }
  ];

  getAllData(): Data[] {
    return this.allData;
  }

  getDataById(_dataId: number): Data {
    const _data = this.allData.find(data => data.dataID === _dataId);
    if (!_data) {
      throw new Error('Data not found!');
    } else {
      return _data;
    }
  }
}
