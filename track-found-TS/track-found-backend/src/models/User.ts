export interface User {
    id?:number;
    name:string;
    email:string;
    password:string;
}

export interface UserDTO {
    id?:number;
    name:string;
    email:string;
}

export function toUserDto(user:User){
 const {password, ...dto} = user;
 return dto;
}