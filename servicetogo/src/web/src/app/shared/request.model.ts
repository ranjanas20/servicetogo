export class RequestModel{
    constructor(public address ?: string,
        public assigedToEmpId ?:  number,
        public comments ?: string,
        public completionDatetime ?: Date,
        public customerId ?:  number,
        public email ?: string,
        public firstName ?: string,
        public lastName ?: string,
        public phone ?: string,
        public preferredContactMethod ?: string,
        public priority ?: string,
        public reqId ?:  number,
        public requestDatetime ?: Date,
        public serviceType ?: string,
        public status ?: string,
        public symptoms ?: string,
        public vendorId ?:  number     

    ) {}
}