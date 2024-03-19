export interface CommentInterface {
	id?: string;
	content?: string;
	userId?: string;
	firstName?: string;
	lastName?: string;
	createdAt?: Date | undefined;
	email?: string;
}

export class Comment implements CommentInterface {
	constructor(
		public id?: string,
		public content?: string,
		public userId?: string,
		public firstName?: string,
		public lastName?: string,
		public email?: string,
		public createdAt?: Date | undefined,
	) {}
}
