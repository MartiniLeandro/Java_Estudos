import { Category } from "./Category";

export interface Transaction{
    id?:number;
    description:string;
    date:string;
    amount:number;
    categoryId:number;
    userId:number
}

export interface TransactionDTO{
    id?:number;
    description:string;
    date:string;
    amount:number;
    category:Category;
}

export interface TransactionUpdate{
    transaction:Transaction;
    id:number;
    userId:number;
}