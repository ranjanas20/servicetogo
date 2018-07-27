
import { CarServiceRequestTrackerModel } from "./carservicerequesttracker.model";

export class SearchResponseModel{
    success: boolean;
    respCode: string;
    respMessage: string;
    pageNumber: number;
    totalPapges: number;
    data: CarServiceRequestTrackerModel[]; 
}