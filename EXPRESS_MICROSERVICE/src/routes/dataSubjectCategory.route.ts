import { Router } from 'express';
import DataSubjectCategoriesController from '@controllers/dataSubjectCategoriesController';
import { Routes } from '@interfaces/routes.interface';
import apiKeyAuthMiddleware from '@middlewares/apiKey.middleware';

class DataSubjectCategoryRoute implements Routes {
  public path = '/express/data-subject-category';
  public router = Router();
  public DataSubjectCategoryController = new DataSubjectCategoriesController();

  constructor() {
    this.initializeRoutes();
  }

  private initializeRoutes() {
    this.router.get(`${this.path}/getAll`, this.DataSubjectCategoryController.getAllDataSubjectCategory);
    this.router.get(`${this.path}/getById/:dsCategoryID`, this.DataSubjectCategoryController.getDataSubjectCategoryById);
    this.router.post(`${this.path}/create`, this.DataSubjectCategoryController.createDataSubjectCategory); //TODO : Validation middleware
    this.router.delete(`${this.path}/delete/:dsCategoryID`, this.DataSubjectCategoryController.deleteDataSubjectCategory);
  }
}

export default DataSubjectCategoryRoute;
