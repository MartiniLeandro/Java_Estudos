import express from 'express';
import cors from 'cors';
import userRouter from './routes/UserRouter' 
import categoryRouter from './routes/CategoryRouter'
import transactionRouter from './routes/TransactionRouter'

const app = express();

app.use(cors());
app.use(express.json());

app.use("/users", userRouter)
app.use("/categories", categoryRouter)
app.use('/transactions', transactionRouter);

app.get('/test', (_, res) => {
  res.status(200).json({ status: 'A API está no ar e pronta para receber código!' });
});

export { app };