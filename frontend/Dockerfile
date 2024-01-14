# Use the official Node.js image as the base image
FROM node:18.18.2 as build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install 

# Copy the entire project to the working directory
COPY . .

# Build the Angular app
RUN npm run build 

# Use a lightweight Nginx image to serve the Angular app
FROM nginx:stable

# COPY nginx-custom.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist/aftas/browser/ /usr/share/nginx/html

# Copy the built Angular app to the Nginx public directory
# COPY --from=build /app/dist/AFTAS-Angular /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Command to run Nginx
# CMD ["nginx", "-g", "daemon off;"]
