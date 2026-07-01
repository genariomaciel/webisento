# Build stage
FROM node:20-alpine AS build

WORKDIR /app

COPY package*.json ./

RUN npm ci

COPY . .

RUN npm run build

# Runtime stage - not needed for JAR embedding
# The built files will be copied to the backend's static resources
