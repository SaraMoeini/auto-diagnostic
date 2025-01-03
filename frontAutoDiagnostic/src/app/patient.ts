import { Pathology } from "./pathology";

export class Patient {
    id!: number;
    firstname!: string;
    lastname!: string;
    dateOfBirth!:Date;
    telNumber!: string;
    healthIndex!: number;
    pathologies!:Pathology[];
}
