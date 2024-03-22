export interface FavoriteInterface {
	id?: number;
	userId?: number;
	recipeId?: number;
}
export class Favorite implements FavoriteInterface {
	constructor(public id?: number, public userId?: number, public recipeId?: number) {}
}
