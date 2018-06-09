export class RequestModel{
    constructor(
        public reqId ?:  number,
        public requestDatetime ?: Date,
        public customerId ?:  number,
        public email ?: string,
        public firstName ?: string,
        public lastName ?: string,
        public phone ?: string,
        public preferredContactMethod ?: string,        
        public address ?: string,
        public priority ?: string,
        public serviceType ?: string,
        public status ?: string,
        public symptoms ?: string,
        public vendorId ?:  number,     
        public assigedToEmpId ?:  number,
        public comments ?: string,
        public completionDatetime ?: Date

    ) {}
}