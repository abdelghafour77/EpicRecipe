export interface CategoryInterface {
	id?: number;
	name?: string;
}

export class Category implements CategoryInterface {
	constructor(public id?: number, public name?: string) {}
}
