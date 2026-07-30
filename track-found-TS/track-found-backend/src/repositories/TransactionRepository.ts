import { pool } from "../database/postgres"
import {Transaction, TransactionDTO, TransactionUpdate} from "../models/Transaction";

export const getAllByUserId = async(userId:number):Promise<TransactionDTO[]> => {
    const query = "SELECT t.id, t.description, t.amount, t.date, c.id as category_id, c.name AS category_name, c.type AS category_type, c.icon AS category_icon, c.color AS category_color FROM transactions t INNER JOIN categories c ON t.category_id = c.id WHERE t.user_id = $1 ORDER BY t.date DESC"
    const result = await pool.query(query,[userId])
    return result.rows.map(transaction => mapTransactionToDto(transaction));
}

export const getByIdAndUserId = async(id:number, userId:number):Promise<TransactionDTO | null> => {
    const query = "SELECT t.id, t.description, t.amount, t.date,c.id as category_id, c.name AS category_name, c.type AS category_type, c.icon AS category_icon, c.color AS category_color FROM transactions t INNER JOIN categories c ON t.category_id = c.id WHERE t.id = $1 AND t.user_id = $2"
    const result = await pool.query(query,[id,userId])
    if(result.rows.length === 0) return null;
    return mapTransactionToDto(result.rows[0]);
}

export const createTransaction = async(data:Transaction):Promise<TransactionDTO> => {
    const query = "INSERT INTO transactions (description,date,amount,user_id,category_id) VALUES ($1,$2,$3,$4,$5) RETURNING id"
    const values = [data.description,data.date,data.amount,data.userId,data.categoryId];
    const result = await pool.query(query, values);
    const newId = result.rows[0].id;
    const savedTransaction = await getByIdAndUserId(newId,data.userId)
    if (!savedTransaction) {
        throw new Error("Erro interno: A transação foi criada, mas não pôde ser recuperada do banco de dados.");
    }
    return savedTransaction;
}

export const updateTransaction = async(data: TransactionUpdate): Promise<TransactionDTO | null> => {
    const query = "UPDATE transactions SET description = $1, date = $2, amount = $3, category_id = $4 WHERE id = $5 AND user_id = $6 RETURNING id"
    const { description, date, amount, categoryId } = data.transaction;
    const result = await pool.query(query, [description, date, amount, categoryId, data.id, data.userId]);
    if (result.rows.length === 0) {
        return null; 
    }
    const updatedTransaction = await getByIdAndUserId(data.id, data.userId);
    if (!updatedTransaction) {
        throw new Error("Erro interno: A transação foi atualizada, mas não pôde ser recuperada do banco de dados.");
    }
    
    return updatedTransaction;
}

export const deleteTransaction = async(id:number,userId:number):Promise<boolean> => {
    const query = "DELETE FROM transactions WHERE id = $1 AND user_id = $2";
    const result = await pool.query(query,[id,userId])
    return result.rowCount !== null && result.rowCount > 0;
}

const mapTransactionToDto = (transaction:any) => ({
   id:transaction.id,
        description:transaction.description,
        date: transaction.date,
        amount: Number(transaction.amount),
        category: {
            id: transaction.category_id,
            name: transaction.category_name,
            type: transaction.category_type,
            icon: transaction.category_icon,
            color: transaction.category_color
        }  
})