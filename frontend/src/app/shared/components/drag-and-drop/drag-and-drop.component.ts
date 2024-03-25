import { Component, ViewChild, ElementRef } from "@angular/core";

interface UploadFile {
	file: File;
	progress: number;
	realFilePath: string; // Added realFilePath property
}

@Component({
	selector: "app-drag-and-drop",
	templateUrl: "./drag-and-drop.component.html",
	styleUrls: ["./drag-and-drop.component.css"],
})
export class DragAndDropComponent {
	@ViewChild("fileDropRef", { static: false }) fileDropEl!: ElementRef<HTMLInputElement>;
	files: UploadFile[] = [];

	constructor() {}

	/**
	 * on file drop handler
	 */
	onFileDropped(event: DragEvent) {
		event.preventDefault();
		if (event.dataTransfer) {
			this.prepareFilesList(event.dataTransfer.files);
		}
	}

	/**
	 * handle file from browsing
	 */
	fileBrowseHandler(event: Event) {
		const input = event.target as HTMLInputElement;
		if (input.files) {
			this.prepareFilesList(input.files);
		}
	}

	/**
	 * Delete file from files list
	 * @param index (File index)
	 */
	deleteFile(index: number) {
		if (this.files[index].progress < 100) {
			console.log("Upload in progress.");
			return;
		}
		this.files.splice(index, 1);
	}

	/**
	 * Simulate the upload process
	 */
	uploadFilesSimulator(index: number) {
		setTimeout(() => {
			if (index === this.files.length) {
				return;
			} else {
				const progressInterval = setInterval(() => {
					if (this.files[index].progress === 100) {
						clearInterval(progressInterval);
						this.uploadFilesSimulator(index + 1);
					} else {
						this.files[index].progress += 5;
					}
				}, 200);
			}
		}, 1000);
	}

	/**
	 * Convert Files list to normal array list
	 * @param files (Files List)
	 */
	prepareFilesList(files: FileList) {
		for (let i = 0; i < files.length; i++) {
			const file = files[i];
			if (this.isValidImage(file)) {
				const uploadFile: UploadFile = {
					file: file,
					progress: 0,
					realFilePath: URL.createObjectURL(file), // Setting realFilePath to the object URL of the file
				};
				this.files.push(uploadFile);
			} else {
				console.log(`${file.name} is not a valid image file.`);
			}
		}
		// Clear the input field
		if (this.fileDropEl) {
			this.fileDropEl.nativeElement.value = "";
		}
		this.uploadFilesSimulator(0);
	}

	/**
	 * Check if the file is a valid image
	 * @param file (File)
	 */
	isValidImage(file: File): boolean {
		return file.type.startsWith("image/");
	}

	/**
	 * format bytes
	 * @param bytes (File size in bytes)
	 * @param decimals (Decimals point)
	 */
	formatBytes(bytes: number, decimals = 2) {
		if (bytes === 0) {
			return "0 Bytes";
		}
		const k = 1024;
		const dm = decimals <= 0 ? 0 : decimals;
		const sizes = ["Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"];
		const i = Math.floor(Math.log(bytes) / Math.log(k));
		return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + " " + sizes[i];
	}
}
