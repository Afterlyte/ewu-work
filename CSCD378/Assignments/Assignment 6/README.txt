After unzipping the .zip file
1. In the BaseballPlayers directory, enter the command "composer install"
2. Seed the players database with php artisan db:seed --class=PlayerSeeder
3. enter the command "php artisan serve" to run the server
4. Open a web browser and go to 127.0.0.1:8000
5. You should be redirected to 127.0.0.1:8000/players and the application can be used from there