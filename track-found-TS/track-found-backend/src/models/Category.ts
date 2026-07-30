
export type TransactionType = 'REVENUE' | 'EXPENSE';

export interface Category {
    id?:number;
    name:string;
    type:TransactionType;
    icon:string;
    color:string;
}