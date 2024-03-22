export interface TagInterface {
	id?: number;
	name?: string;
}
export class Tag implements TagInterface {
	constructor(public id?: number, public name?: string) {}
}
