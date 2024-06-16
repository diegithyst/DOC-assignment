FROM node:14-alpine

# Copy package.json and package-lock.json if available to allow for installing dependencies
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Expose the port on which the React app will run
EXPOSE 3000

# Define the command to run the React app
CMD ["npm", "start"]
