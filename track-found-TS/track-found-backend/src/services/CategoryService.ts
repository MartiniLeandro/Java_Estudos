import { Category } from '../models/Category';
import * as categoryRepository from '../repositories/CategoryRepository'

export const getAllCategories = async():Promise<Category[]> => {
    return await categoryRepository.getAllCategories();
}

export const getCategoryById = async(id:number):Promise<Category> => {
    const category = await categoryRepository.getCategoryById(id);
    if(!category)throw new Error("Não existe categoria com este ID");
    return category;
}