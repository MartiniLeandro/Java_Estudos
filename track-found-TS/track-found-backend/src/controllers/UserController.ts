import { User, UserDTO } from "../models/User";
import * as userService from "../services/UserService";
import { Request, Response } from "express";

export const createUser = async(req:Request, res:Response) => {
    try{
        const {name, email,password} = req.body;
        const user:User = {name:name, email:email,password:password}
        const newUser:UserDTO = await userService.createUser(user)
        res.status(201).json(newUser)
    }catch(error){
        if(error instanceof Error){
            return res.status(400).json({ error: error.message })
        }
        return res.status(500).json({ error: "Erro interno no servidor ao criar usuário" });
    }
}