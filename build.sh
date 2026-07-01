#!/bin/bash

set -e

echo "==================================="
echo "Building WebIsento Application"
echo "==================================="

echo "\n[1/4] Building Frontend Angular..."
cd frontend
npm ci
npm run build
cd ..

echo "\n[2/4] Frontend build complete!"

echo "\n[3/4] Building Backend Spring Boot..."
cd backend
mvn clean package -DskipTests
cd ..

echo "\n[4/4] Build complete!"
echo ""
echo "==================================="
echo "✓ WebIsento build completed successfully!"
echo "==================================="
echo ""
echo "To run the application:"
echo "java -jar backend/target/webisento-*.jar"
echo ""
echo "Application will be available at: http://localhost:8080"
