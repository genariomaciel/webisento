@echo off

setlocal enabledelayedexpansion

echo ===================================
echo Building WebIsento Application
echo ===================================

echo.
echo [1/4] Building Frontend Angular...
cd frontend
call npm ci
call npm run build
cd ..

echo.
echo [2/4] Frontend build complete!

echo.
echo [3/4] Building Backend Spring Boot...
cd backend
call mvn clean package -DskipTests
cd ..

echo.
echo [4/4] Build complete!
echo.
echo ===================================
echo Build completed successfully!
echo ===================================
echo.
echo To run the application:
echo java -jar backend/target/webisento-*.jar
echo.
echo Application will be available at: http://localhost:8080
pause
