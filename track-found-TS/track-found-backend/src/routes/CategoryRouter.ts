import { Router } from 'express'
import * as categoryController from '../controllers/CategoryController'

const router = Router();

router.get("/", categoryController.getAllCategories);
router.get("/:id", categoryController.getCategoryById);

export default router;