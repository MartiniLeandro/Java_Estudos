import { pool } from "../database/postgres";
import { User } from "../models/User";


export const createUser = async(data:User):Promise<User> => {
    const query = "INSERT INTO users (name,email,password) VALUES ($1,$2,$3) RETURNING *"
    const values = [data.name, data.email,data.password]
    const result = await pool.query(query,values)
    return result.rows[0]; 
}


export const existByEmail = async(email:string):Promise<boolean> => {
    const query = "SELECT * from users where email = $1"
    const result = await pool.query(query,[email])
    return result.rowCount !== null && result.rowCount > 0
}