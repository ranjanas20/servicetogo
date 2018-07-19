export class CarServiceRequestTrackerModel{
    symptoms: string;
    userComments: string;
    preferredContactMethod: string;
    vehicleLocation: string;

    requestId: number;
    customerId: number;
    customerFirstName: string;
    customerLastName: string;
    email: string;
    customerPhone: string;
    vehicleMake: string;
    vehicleModel: string;
    vehicleYear: number;
    vehicleVin: string;
    addressCity: string;
    addressState: string;
    addressZip: string;
    requestedDate: Date;
    
    serviceStatus: string;
    assigedEmployeeId: string;
    assigedEmployeeFirstName: string;
    assigedEmployeeLastName: string;
    servicePriority: string;
    serviceScheduleDatetime: Date;    
    serviceCompletionDatetime: Date;
    serviceCompletedById: string;
    serviceCompletedByFirstName: string;
    serviceCompletedByLastName: string;

    addressLine1:string;
    addressLine2:string;
    
    createdOn:Date;
    createdBy:string;
    updatedOn:Date;
    updatedBy:string;
}