import { Request, Response } from 'express';
import * as categoryService from '../services/CategoryService'
import { Category } from '../models/Category'

export const getAllCategories = async(_:Request, res:Response) => {
    try{
        const categories:Category[] = await categoryService.getAllCategories();
        res.status(200).json(categories);
    }catch(error){
        if(error instanceof Error) {
            return res.status(400).json(error.message);
        }
        res.status(500).json({error: "Erro interno no servidor ao buscar categorias"})
    }
}

export const getCategoryById = async(req:Request, res:Response) => {
    try{
        const id = parseInt(req.params.id as string);
        if (isNaN(id)) {
            return res.status(400).json({error: "O ID fornecido é inválido. Deve ser um número."});
        }
        const category = await categoryService.getCategoryById(id);
        res.status(200).json(category)
    }catch(error){
        if(error instanceof Error){
            return res.status(400).json(error.message);
        } 
        res.status(500).json({error: "Erro interno no servidor ao buscar categoria"})
    }
}