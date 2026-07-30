import { app } from './app';
import { createTables } from './database/initDb'

const PORT = 3030;

createTables().then(() => {
  app.listen(PORT, () => {
    console.log(`🚀 Servidor rodando na porta ${PORT}`);
  });
})