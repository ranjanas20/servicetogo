export class CarServiceRequestTrackerModel{
    requestId: number;
    customerId: number;
    customerFirstName: string;
    customerLastName: string;
    customerMiddleName: string;
    email: string;
    customerPhone: string;
    addressLine1:string;
    addressLine2:string;
    addressCity: string;
    addressState: string;
    addressZip: string;
    requestedDate: Date;

    vehicleMake: string;
    vehicleModel: string;
    vehicleYear: number;
    vehicleVin: string;
    symptoms: string;
    userComments: string;
    preferredContactMethod: string;
    vehicleLocation: string;

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

    createdOn:Date;
    createdBy:string;
    updatedOn:Date;
    updatedBy:string;
}