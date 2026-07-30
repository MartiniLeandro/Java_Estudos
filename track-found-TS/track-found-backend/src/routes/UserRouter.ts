import { Router } from "express";
import * as userController from "../controllers/UserController"

const router = Router();
router.post("/", userController.createUser);

export default router;