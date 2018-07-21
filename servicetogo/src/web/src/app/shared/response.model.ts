import { CarServiceRequestTrackerModel } from "./careervicerequesttracker.model";

export class ResponseModel{
    success: boolean;
    respCode: string;
    respMessage: string;
    pageNumber: number;
    totalPapges: number;
    data: CarServiceRequestTrackerModel; 
}