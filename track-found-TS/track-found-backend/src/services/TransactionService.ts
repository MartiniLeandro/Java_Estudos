import { Transaction, TransactionDTO, TransactionUpdate } from '../models/Transaction';
import * as transactionRepository from '../repositories/TransactionRepository';
import * as categoryService from './CategoryService';

export const getAllTransactions = async(userId: number): Promise<TransactionDTO[]> => {
    return await transactionRepository.getAllByUserId(userId);
}

export const getTransactionById = async(id: number, userId: number): Promise<TransactionDTO> => {
    const transaction = await transactionRepository.getByIdAndUserId(id, userId);
    if (!transaction) {
        throw new Error("Lançamento não encontrado ou não pertence a você.");
    }
    return transaction;
}

export const createTransaction = async(data: Transaction): Promise<TransactionDTO> => {
    if (data.amount <= 0) {
        throw new Error("O valor da transação deve ser maior que zero.");
    }
    await categoryService.getCategoryById(data.categoryId);
    return await transactionRepository.createTransaction(data);
}

export const updateTransaction = async(data: TransactionUpdate): Promise<TransactionDTO> => {
    await getTransactionById(data.id, data.userId);
    if (data.transaction.amount <= 0) {
        throw new Error("O valor da transação deve ser maior que zero.");
    }
    const updatedTransaction = await transactionRepository.updateTransaction(data);
    if (!updatedTransaction) {
        throw new Error("Erro interno: Falha ao retornar a transação atualizada.");
    }
    return updatedTransaction;
}

export const deleteTransaction = async(id: number, userId: number): Promise<void> => {
    const isDeleted = await transactionRepository.deleteTransaction(id, userId);
    if (!isDeleted) {
        throw new Error("Não foi possível excluir. Lançamento não encontrado ou não pertence a você.");
    }
}