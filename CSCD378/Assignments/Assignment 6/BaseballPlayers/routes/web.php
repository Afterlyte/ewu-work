<?php

/**
 * Ian Kaiserman
 * CSCD 378 - Assignment 6: CRUD Assignment
 * Web application for a baseball players database with creating, editing, viewing, deleting, and sorting capabilities
 */

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\PlayerController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return redirect()->route('players.index');
});

Route::resource('players', PlayerController::class);
