import { pool } from "../database/postgres";
import { Category } from "../models/Category";

export const getAllCategories = async():Promise<Category[]> => {
    const query = "SELECT * from CATEGORIES";
    const result = await pool.query(query);
    return result.rows;
}

export const getCategoryById = async(id:number):Promise<Category> => {
    const query = "SELECT * from CATEGORIES where ID = $1";
    const result = await pool.query(query,[id]);
    return result.rows[0];
}