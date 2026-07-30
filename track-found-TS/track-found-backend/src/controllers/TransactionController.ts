import { Request, Response } from 'express';
import * as transactionService from '../services/TransactionService';
import { Transaction, TransactionUpdate } from '../models/Transaction';

const getUserIdFromHeader = (req: Request): number => {
    const userId = req.headers['x-user-id'];
    if (!userId) {
        throw new Error("Usuário não autenticado. Envie o 'x-user-id' no Header.");
    }
    return parseInt(userId as string);
}

export const getAllTransactions = async (req: Request, res: Response) => {
    try {
        const userId = getUserIdFromHeader(req);
        const transactions = await transactionService.getAllTransactions(userId);
        
        return res.status(200).json(transactions);
    } catch (error) {
        if (error instanceof Error) return res.status(400).json({ error: error.message });
        return res.status(500).json({ error: "Erro interno ao buscar lançamentos." });
    }
}

export const getTransactionById = async (req: Request, res: Response) => {
    try {
        const userId = getUserIdFromHeader(req);
        const id = parseInt(req.params.id as string);

        if (isNaN(id)) return res.status(400).json({ error: "ID da transação inválido." });

        const transaction = await transactionService.getTransactionById(id, userId);
        return res.status(200).json(transaction);
    } catch (error) {
        if (error instanceof Error) return res.status(400).json({ error: error.message });
        return res.status(500).json({ error: "Erro interno ao buscar o lançamento." });
    }
}

export const createTransaction = async (req: Request, res: Response) => {
    try {
        const userId = getUserIdFromHeader(req);
        
        // Extrai apenas os dados da transação do corpo da requisição
        const { description, amount, date, categoryId } = req.body;
        
        const newTransaction: Transaction = {
            description,
            amount,
            date,
            categoryId,
            userId // Injetamos o usuário dono da transação aqui de forma segura
        };

        const createdTransaction = await transactionService.createTransaction(newTransaction);
        return res.status(201).json(createdTransaction);
    } catch (error) {
        if (error instanceof Error) return res.status(400).json({ error: error.message });
        return res.status(500).json({ error: "Erro interno ao criar o lançamento." });
    }
}

export const updateTransaction = async (req: Request, res: Response) => {
    try {
        const userId = getUserIdFromHeader(req);
        const id = parseInt(req.params.id as string);

        if (isNaN(id)) return res.status(400).json({ error: "ID da transação inválido." });

        const { description, amount, date, categoryId } = req.body;

        // Monta o objeto DTO TransactionUpdate exatamente como você desenhou
        const updateData: TransactionUpdate = {
            id: id,
            userId: userId,
            transaction: { description, amount, date, categoryId, userId }
        };

        const updatedTransaction = await transactionService.updateTransaction(updateData);
        return res.status(200).json(updatedTransaction);
    } catch (error) {
        if (error instanceof Error) return res.status(400).json({ error: error.message });
        return res.status(500).json({ error: "Erro interno ao atualizar o lançamento." });
    }
}

export const deleteTransaction = async (req: Request, res: Response) => {
    try {
        const userId = getUserIdFromHeader(req);
        const id = parseInt(req.params.id as string);

        if (isNaN(id)) return res.status(400).json({ error: "ID da transação inválido." });

        await transactionService.deleteTransaction(id, userId);
        
        // Status 204 significa "No Content" (Deletado com sucesso, sem corpo na resposta)
        return res.status(204).send(); 
    } catch (error) {
        if (error instanceof Error) return res.status(400).json({ error: error.message });
        return res.status(500).json({ error: "Erro interno ao deletar o lançamento." });
    }
}