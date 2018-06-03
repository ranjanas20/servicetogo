export class RequestModel{
    constructor(public requestId?: number,
        public firstName?: string,
        public lastName?: string,
        public make?: string,
        public model?: string,
        public year?: number,
        public status?: string,
        public serviceAddress?: string,
        public city?: string,
        public state?: string,
        public zip?: string,
        public serviceDate?: string,
        public servicedBy?: string,
        public symptoms?: string,
    ) {}
}