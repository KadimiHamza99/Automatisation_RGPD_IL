import { DatasourceEnum } from "../Enum/datasource-enum";

export class Data{
  dataID!: number;
  dataConservation?: number;
  dataSource?: DatasourceEnum;
  isPersonal?: boolean;
  isPortable!: boolean;
  attributeName?: string;

}
