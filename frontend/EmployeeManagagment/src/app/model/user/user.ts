export class User {
    id:number;
    first_name: String;
    last_name: String
    username: String;
    email: String;
    password: String;

    constructor(){
        this.id = 0;
        this.first_name = '';
        this.last_name = '';
        this.username = '';
        this.email = '';
        this.password = '';
    }
}
