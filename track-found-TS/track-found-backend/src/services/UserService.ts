import { toUserDto, User,UserDTO } from "../models/User";
import bcrypt from 'bcrypt'
import * as userRepository from '../repositories/UserRepository'

export const createUser = async(data:User):Promise<UserDTO> => {
    if(await userRepository.existByEmail(data.email)) throw new Error("Já existe usuário com este email cadastro")
    const hashedPassword = await bcrypt.hash(data.password, 10)
    const newUser:User = {...data, password: hashedPassword}
    const savedUser = await userRepository.createUser(newUser);
    return toUserDto(savedUser);
    
}