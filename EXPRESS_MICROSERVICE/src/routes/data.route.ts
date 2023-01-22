import { Router } from 'express';
import DataController from '@controllers/data.controller';
import { Routes } from '@interfaces/routes.interface';
import apiKeyAuthMiddleware from '@middlewares/apiKey.middleware';

class DataRoute implements Routes {
  public path = '/express/data';
  public router = Router();
  public dataController = new DataController();

  constructor() {
    this.initializeRoutes();
  }

  private initializeRoutes() {
    this.router.get(`${this.path}/getAll`, this.dataController.getData);

    this.router.get(`${this.path}/getAllByDataSubjectId/:dataSubjectID(\\d+)`, this.dataController.getDataByDataSubjectId); //Method used by datasubject
    this.router.get(
      `${this.path}/getAllWithoutRequestByDataSubjectId/:dataSubjectID(\\d+)`,
      this.dataController.getDataWithoutRequestsByDataSubjectId,
    ); //Method used by datasubject
    this.router.get(`${this.path}/getById/:dataID(\\d+)`, this.dataController.getDataById);
    this.router.post(`${this.path}/create`, this.dataController.createData); //Method used by datasubject
    this.router.put(`${this.path}/update/:dataID(\\d+)`, this.dataController.updateData);
    this.router.delete(`${this.path}/delete/:dataID(\\d+)`, this.dataController.deleteData);
    this.router.delete(
      `${this.path}/deleteAllFromDataSubject/:dataSubjectID(\\d+)`,

      this.dataController.deleteAllFromDataSubject,
    );
    this.router.delete(
      `${this.path}/flagAllAsDeletedFromDataSubject/:dataSubjectID(\\d+)`,

      this.dataController.flagAllAsDeletedFromDataSubject,
    );
    this.router.delete(`${this.path}/flagAsDeleted/:dataID(\\d+)`, this.dataController.flagAsDeleted);
  }
}

export default DataRoute;
